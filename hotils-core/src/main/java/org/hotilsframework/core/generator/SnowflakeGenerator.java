package org.hotilsframework.core.generator;

import org.hotilsframework.lang.StringUtils;
import org.hotilsframework.time.SystemClock;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


/**
 * SnowflakeSequence
 * 雪花算法的实现
 *
 * 全局唯一ID生成结构如下(每部分用-分开):<br>
 * 0 - 00 - 0000000000 0000000000 0000000000 0000000000 0 - 0000000000 00 - 00000000 <br>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
 * 2位生成发布方式，0代表嵌入式发布、1代表中心服务器发布模式、2代表rest发布方式、3代表测试用<br>
 * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
 * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
 * 8位的数据机器位，可以部署在256个节点，包括8位workerId<br>
 * 加起来刚好64位，为一个Long型。<br>
 * 优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(机器ID作区分)，并且效率较高，经测试，嵌入式的方式每秒能够产生40万ID左右。
 * 
 * @Author: hireny
 * @Date: Create in 2019/10/14 13:32
 */
public class SnowflakeGenerator implements IdGenerator {

//    private static final Logger logger = LoggerFactory.getLogger(SnowflakeSequence.class);

    /**
     * 时间起始标记点，作为基准，一般取系统的最近时间(一旦确定不能变动)
     */
    private final long twepoch = 1480166465631L;

    /**
     * 每一部分占用的位数
     */

    /**
     * 机器标识位数
     */
    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    private final long maxMachineId = -1L ^ (-1L << workerIdBits);
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    /**
     * 毫秒内自增位
     */
    private final long sequenceBits = 12L;
    private final long machineLeft = sequenceBits;
    private final long datacenterLeft = sequenceBits + workerIdBits;
    /**
     * 时间戳左移动位
     */
    private final long timestamppLeft = sequenceBits + workerIdBits + datacenterIdBits;
    private final long maxSequence = -1L ^ (-1L << sequenceBits);

    private long datacenterId;  //数据中心
    private long machineId;     //机器标识(工作机器ID)
    // 并发控制
    private long sequence = 0L; //序列号
    private long lastStmp = -1L;//上一次生产ID时间戳

    public SnowflakeGenerator() {
        this.datacenterId = getDatacenterId(maxDatacenterId);
        this.machineId = getMaxWorkerId(datacenterId, maxMachineId);
    }

    public SnowflakeGenerator(long datacenterId, long machineId) {
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
//            logger.warn("数据中心ID不能大于最大数据中心ID或小于0");
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > maxMachineId || machineId < 0) {
//            logger.warn("机器ID不能大于最大机器ID或小于0");
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 获取 maxWorkerId
     */
    protected static long getMaxWorkerId(long datacenterId, long maxWorkerId) {
        StringBuilder mpid = new StringBuilder();
        mpid.append(datacenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (!StringUtils.isBlank(name)) {
            /*
             * GET jvmPid
             */
            mpid.append(name.split("@")[0]);
        }
        /*
         * MAC + PID 的 hashcode 获取16个低位
         */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }

    /**
     * 数据标识id部分
     */
    protected static long getDatacenterId(long maxDatacenterId) {
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                if (null != mac) {
                    id = ((0x000000FF & (long) mac[mac.length - 1]) | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
                    id = id % (maxDatacenterId + 1);
                }
            }
        } catch (Exception e) {
//            logger.warn(" getDatacenterId: " + e.getMessage());
        }
        return id;
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    @Override
    public long nextId() {
        return nextId(timeGen());
    }

    /**
     * 生成ID
     * @return
     */
    @Override
    public UUID generateId() {
        return UUID.fromString(String.valueOf(nextId()));
    }

    /**
     * 生成指定时间的下一个ID
     * @param currStmp
     * @return
     */
    private synchronized long nextId(long currStmp) {
        if (currStmp < lastStmp) {
            // 发生时钟回退
            long offset = lastStmp - currStmp;
            if (offset <= 5) {
                // 回退时间小于5，则等待
                try {
                    wait(offset << 1);
                } catch (InterruptedException e) {
//                    logger.error("发生时钟回退，线程等待，中断异常");
                    throw new RuntimeException(e);
                }
            } else {
//                logger.warn("时钟回退，拒绝生成ID");
                throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
            }
        }

        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0L) {
                //同一毫秒的序列数已经达到最大
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为 1 -3 随机数
            sequence = ThreadLocalRandom.current().nextLong(1,3);
        }

        lastStmp = currStmp;

        return (currStmp - twepoch) << timestamppLeft   //时间戳部分
                | datacenterId << datacenterLeft       //数据中心部分
                | machineId << machineLeft             //机器标识部分
                | sequence;                             //序列号部分
    }

    private long getNextMill() {
        long mill = timeGen();
        while (mill <= lastStmp) {
            mill = timeGen();
        }
        return mill;
    }

    /**
     * 获取当前毫秒时间戳
     * @return
     */
    private long timeGen() {
        return SystemClock.now();
    }
}
