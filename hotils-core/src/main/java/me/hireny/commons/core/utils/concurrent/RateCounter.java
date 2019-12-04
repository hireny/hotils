package me.hireny.commons.core.utils.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: RateCounter
 * @Author: hireny
 * @Date: Create in 2019/12/04 13:43
 * @Description: TODO   环形计数器(计数器限流)
 */
public class RateCounter implements RateLimiter {

    /**
     * 每秒的限流速率限制
     */
    private static final int DEFAULT_RATE_LIMIT_PER_SECOND = Integer.MAX_VALUE;
    /**
     * 限制
     */
    private int limit;
    /**
     * 计算器
     */
    private AtomicInteger counter;

    /**
     * 构造器
     */
    public RateCounter() {
        this(DEFAULT_RATE_LIMIT_PER_SECOND);
    }

    /**
     * 构造器
     * @param limit
     */
    public RateCounter(int limit) {
        if (limit < 0) {
            // 小于零的限制错误
            throw new IllegalArgumentException("limit less than zero");
        }
        this.limit = limit;
        counter = new AtomicInteger();
        TimestampHolder holder = new TimestampHolder();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            while (true) {
                long current = SystemClock.now();
                if (current - holder.getTimestamp() >= 1000) {
                    holder.setTimestamp(current);
                    counter.set(0);
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void acquire() throws RejectException {
        if (counter.incrementAndGet() > limit) {
            throw new RejectException();
        }
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateCounter(10);

        int num = 100;
        while (num > 0) {
            try {
                rateLimiter.acquire();
            } catch (Exception e) {
                continue;
            }

            num--;
            System.out.println("sec: " + System.currentTimeMillis() / 1000L + ", mil: " + System.currentTimeMillis() + " got a token");
        }
    }
}
