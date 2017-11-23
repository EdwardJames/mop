package com.xp.springboot.mop.sign;

public class Singleton2 {
   
  private static class getSingletonHolder{
      private static Singleton2 instance = new Singleton2();
  }
  public static Singleton2 getSingleton(){
      return getSingletonHolder.instance;
  }
}
