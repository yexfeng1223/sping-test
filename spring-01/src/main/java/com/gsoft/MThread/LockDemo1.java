package com.gsoft.MThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LockDemo1 {

   volatile int i=0;
    Lock lock=new ReentrantLock();
    public void add(){
        lock.lock();
        try{
            i++;

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo1 ld=new LockDemo1();
        for(int j=0;j<2;j++){
            new Thread(()->{
                for (int i=0;i<10000;i++) {
                    ld.add();
                }

            }).start();
        }
        sleep(2000L);
        System.out.println("....."+ld.i);
    }

}
