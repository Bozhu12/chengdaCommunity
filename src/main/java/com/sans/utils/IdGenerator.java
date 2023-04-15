package com.sans.utils;

/**
 * id生成器
 * 使用唯一ID生成器生成一个唯一有序的整型数据作为用户ID
 * @author Sans
 */
public class IdGenerator {
    // 2021-05-01 00:00:00
    private static final long START_TIME = 1619827200000L;
    private static final long WORKER_ID_BITS = 10L;
    private static final long SEQUENCE_BITS = 12L;
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long TIMESTAMP_SHIFT = WORKER_ID_BITS + SEQUENCE_BITS;
    // 机器ID，可以根据需要修改
    private static final long WORKER_ID = 1L;
    private static long lastTimestamp = -1L;
    private static long sequence = 0L;

    public static synchronized long nextId() {
        long timestamp = System.currentTimeMillis() - START_TIME;
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id");
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        return (timestamp << TIMESTAMP_SHIFT) | (WORKER_ID << WORKER_ID_SHIFT) | sequence;
    }

    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis() - START_TIME;
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis() - START_TIME;
        }
        return timestamp;
    }
}
