package com.xp.springboot.mop.sign;

public class Singleton {
  private static Singleton instance = null;
  public synchronized Singleton getInstance(){
      if(instance == null){
          instance = new Singleton();
      }
      return instance;
  }
}
