package AAAAAAAAAAAAA.concurrent001.synchroTest.deadlocktest;

import javax.swing.*;

public class Dtest {
    public static void main(String[] args) {
        OtherService o1 = new OtherService();
        DeadLock deadLock = new DeadLock(o1);
        o1.setDeadLock(deadLock);

        new Thread(){
            @Override
            public void run() {
                for(;true;){
                    deadLock.m1();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                //equal while(true)
                for(;true;){
                    o1.f2();
                }
            }
        }.start();

    }
}
