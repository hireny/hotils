package org.hotilsframework.core.generator;

import org.hotilsframework.lang.ClassLoaders;
import org.hotilsframework.lang.RandomUtils;
import org.hotilsframework.lang.StringUtils;

import java.lang.management.ManagementFactory;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MongoDB ID生成策略实现 <br>
 * ObjectId由以下几部分组成：
 *
 * <pre>
 *     1. Time 时间戳。
 *     2. Machine 所在主机的唯一标识符，一般是机器主机名的散列值。
 *     3. PID 进程ID。确保同一机器中不冲突。
 *     4. INC 自增计算器。确保同一秒内产生ObjectId的唯一性。
 * </pre>
 *
 * @ClassName: ObjectId
 * @Author: hireny
 * @Date: Created in 2020-02-02 1:52
 * @Version: 1.0
 */
public class ObjectId {

    /**
     * 线程安全的下一个随机数，每次生成自增+1
     */
    private static final AtomicInteger nextIncrement = new AtomicInteger(0);

    /**
     * 机器信息
     */
    private static final int machine = getMachinePiece() | getProcessPiece();

    /**
     * 给定的字符串是否为有效的ObjectId
     * @param s     字符串
     * @return      是否为有效的ObjectId
     */
    public static boolean isValid(String s) {
        if (StringUtils.isBlank(s)) {
            return false;
        }
        final int length = s.length();
        if (length != 24) {
            return false;
        }

        char c;
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            if (c >= 'a' && c <= 'f') {
                continue;
            }
            if (c >= 'A' && c <= 'F') {
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 获取一个ObjectId的bytes表现形式
     * @return
     */
    public static byte[] nextBytes() {
        final ByteBuffer buffer = ByteBuffer.wrap(new byte[12]);
        buffer.putInt(4);   // 4位
        buffer.putInt(machine); // 4位
        buffer.putInt(nextIncrement.getAndIncrement()); // 4位
        return buffer.array();
    }

    /**
     * 获取一个ObjectId用下划线分隔
     * @return
     */
    public static String next() {
        return next(false);
    }

    /**
     * 获取一个ObjectId
     * @param withHyphen    是否包含分隔符
     * @return
     */
    public static String next(boolean withHyphen) {
        byte[] array = nextBytes();
        final StringBuilder buf = new StringBuilder(withHyphen ? 26 : 24);
        int t;
        for (int i = 0; i < array.length; i++) {
            if (withHyphen && i % 4 == 0 && i != 0) {
                buf.append("-");
            }
            t = array[i] & 0xff;
            if (t < 16) {
                buf.append('0');
            }
            buf.append(Integer.toHexString(t));

        }
        return buf.toString();
    }

    // ----------------------------------------------------------------------------------------- Private method start
    /**
     * 获取机器码片段
     *
     * @return 机器码片段
     */
    private static int getMachinePiece() {
        // 机器码
        int machinePiece;
        try {
            StringBuilder netSb = new StringBuilder();
            // 返回机器所有的网络接口
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            // 遍历网络接口
            while (e.hasMoreElements()) {
                NetworkInterface ni = e.nextElement();
                // 网络接口信息
                netSb.append(ni.toString());
            }
            // 保留后两位
            machinePiece = netSb.toString().hashCode() << 16;
        } catch (Throwable e) {
            // 出问题随机生成,保留后两位
            machinePiece = (RandomUtils.randomInt()) << 16;
        }
        return machinePiece;
    }

    /**
     * 获取进程码片段
     *
     * @return 进程码片段
     */
    private static int getProcessPiece() {
        // 进程码
        // 因为静态变量类加载可能相同,所以要获取进程ID + 加载对象的ID值
        final int processPiece;
        // 进程ID初始化
        int processId;
        try {
            // 获取进程ID
            final String processName = ManagementFactory.getRuntimeMXBean().getName();
            final int atIndex = processName.indexOf('@');
            if (atIndex > 0) {
                processId = Integer.parseInt(processName.substring(0, atIndex));
            } else {
                processId = processName.hashCode();
            }
        } catch (Throwable t) {
            processId = RandomUtils.randomInt();
        }

        final ClassLoader loader = ClassLoaders.getDefaultClassLoader();
        // 返回对象哈希码,无论是否重写hashCode方法
        int loaderId = (loader != null) ? System.identityHashCode(loader) : 0;

        // 进程ID + 对象加载ID
        // 保留前2位
        final String processSb = Integer.toHexString(processId) + Integer.toHexString(loaderId);
        processPiece = processSb.hashCode() & 0xFFFF;

        return processPiece;
    }
    // ----------------------------------------------------------------------------------------- Private method end
}