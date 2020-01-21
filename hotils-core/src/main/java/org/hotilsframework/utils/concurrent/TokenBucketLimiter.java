package org.hotilsframework.utils.concurrent;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: TokenBucketLimiter
 * @Author: hireny
 * @Date: Create in 2019/12/04 14:01
 * @Description: TODO   令牌桶算法限流器
 */
public class TokenBucketLimiter implements RateLimiter {

    private static final int DEFAULT_RATE_LIMIT_PER_SECOND = Integer.MAX_VALUE;

    private static final long NANOSECOND = 1000 * 1000 * 1000;
    /**
     * 令牌
     */
    private static final Object TOKEN = new Object();
    /**
     * 令牌桶
     */
    private Queue<Object> tokenBucket;

    public TokenBucketLimiter() {
        this(DEFAULT_RATE_LIMIT_PER_SECOND);
    }

    public TokenBucketLimiter(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("limit less than zero");
        }
        tokenBucket = new LinkedBlockingDeque<>(limit);
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        TimestampHolder holder = new TimestampHolder(System.nanoTime());
        long interval = NANOSECOND / limit;
        threadPool.submit(() -> {
            while (true) {
                long current = System.nanoTime();
                if (current - holder.getTimestamp() >= interval) {
                    tokenBucket.offer(TOKEN);
                    holder.setTimestamp(current);
                }

                try {
                    TimeUnit.NANOSECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void acquire() throws RejectException {
        Object token = tokenBucket.poll();
        if (Objects.isNull(token)) {
            throw new RejectException();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new TokenBucketLimiter(10);

        Runnable runnable = () -> {
            int num = 100;
            while (num > 0) {
                try {
                    rateLimiter.acquire();
                } catch (Exception e) {
                    continue;
                }

                num--;
                System.out.println("Thread: " + Thread.currentThread().getName() + ", sec: " + System.currentTimeMillis() / 1000L + ", mil: " + System.currentTimeMillis() + " got a token");
            }
        };

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.submit(runnable);
        }
        threadPool.awaitTermination(100, TimeUnit.SECONDS);
    }
}
