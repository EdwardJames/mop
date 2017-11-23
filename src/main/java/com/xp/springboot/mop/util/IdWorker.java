package com.xp.springboot.mop.util;

public class IdWorker
{
  private final long workerId;
  private static final long twepoch = 1412092800000L;
  private long sequence = 0L;
  private static final long workerIdBits = 10L;
  private static final long maxWorkerId = 1023L;
  private static final long sequenceBits = 12L;
  private static final long workerIdShift = 12L;
  private static final long timestampLeftShift = 22L;
  private static final long sequenceMask = 4095L;
  private long lastTimestamp = -1L;

  public IdWorker(long workerId)
  {
    if ((workerId > 1023L) || (workerId < 0L)) {
      throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", new Object[] { Long.valueOf(1023L) }));
    }

    this.workerId = workerId;
  }

  public synchronized long nextId()
  {
    long timestamp = timeGen();
    if (this.lastTimestamp == timestamp) {
      this.sequence = (this.sequence + 1L & 0xFFF);
      if (this.sequence == 0L)
        timestamp = tilNextMillis(this.lastTimestamp);
    }
    else
    {
      this.sequence = 0L;
    }
    if (timestamp < this.lastTimestamp) {
      throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", new Object[] { Long.valueOf(this.lastTimestamp - timestamp) }));
    }

    this.lastTimestamp = timestamp;
    return timestamp - 1412092800000L << 22 | this.workerId << 12 | this.sequence;
  }

  private long tilNextMillis(long lastTimestamp)
  {
    long timestamp = timeGen();
    while (timestamp <= lastTimestamp) {
      timestamp = timeGen();
    }
    return timestamp;
  }

  private long timeGen()
  {
    return System.currentTimeMillis();
  }
}