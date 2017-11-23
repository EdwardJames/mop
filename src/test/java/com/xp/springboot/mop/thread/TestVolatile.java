package com.xp.springboot.mop.thread;

public class TestVolatile extends Thread{
private static volatile boolean flag;
private static int num;
    public TestVolatile() {
    }
    public static void main(String[] args){
        TestVolatile t = new TestVolatile();
        t.start();
        try {
            Thread.sleep(1000);
            num = 5;
            flag = true;
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(!flag){
            System.out.println(num);
        }
        
    }
    
}
