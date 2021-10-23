package AAAAAAAAAAAAA.concurrent001.synchroTest;

public class WhatSynchroOnForThis {
    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread("t1"){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("t2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();
        // till now m1 and m2 have the sam lock, so single pass

        new Thread("t3"){
            @Override
            public void run() {
                thisLock.m3();//now t3 is not locked,
            }
        }.start();


    }
}


class ThisLock {

    //static part is the monitor of 'This'
    //static will be init only once!
    static {
        synchronized (ThisLock.class){
            System.out.println(Thread.currentThread().getName() + " have lock");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void m1 (){
        System.out.println(Thread.currentThread().getName() + " have lock");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2 (){
        System.out.println(Thread.currentThread().getName() + " have lock");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m3 (){
        System.out.println(Thread.currentThread().getName() + " have lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}