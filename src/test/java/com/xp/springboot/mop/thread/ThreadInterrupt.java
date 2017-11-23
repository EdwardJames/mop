package com.xp.springboot.mop.thread;

public class ThreadInterrupt {

    public ThreadInterrupt() {
    
    }
    public static void main(String[] args){
        MyThread thread = new MyThread();
        thread.start();
        MyThread thread1 = new MyThread();
        thread1.start();
        thread1.interrupt();
        System.out.println("线程："+thread1.getName()+":是否停止运行？"+thread1.isInterrupted());
        MyThread thread2 = new MyThread();
        thread2.start();
        
    }
}
class MyThread extends Thread{

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
