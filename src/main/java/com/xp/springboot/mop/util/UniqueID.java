package com.xp.springboot.mop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UniqueID
{
  private static Logger logger = LoggerFactory.getLogger(UniqueID.class);
  private static IdWorker idWorder;

  public static synchronized long generateId()
  {
    return idWorder.nextId();
  }

  static
  {
    int machineNo = Integer.parseInt(LocalHostUtil.getLastSegment());
    idWorder = new IdWorker(machineNo);
    logger.info("当前运行机器LastSegmentIP:" + machineNo);
  }
  public static synchronized long generateNumberId() {
      return idWorder.nextId();
  }
}