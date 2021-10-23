package AAAAAAAAAAAAA.concurrent001.produce_and_consume;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class BasicMultiplePCsample {
    private final Object lock = new Object();

    //chk volatile means!
    private volatile boolean isProduced = false;
    private int i = 0;
    //using condition to try
//    private Condition notFull = lock.newCondition();
//    private Condition notEmpty = lock.newCondition();

    public void produce() throws InterruptedException {
        //produce a int number
        //LOCK.lock();
//        lock.lock();
//        try {
//            while (isProduced) {
//                notFull.await();
//            }
//            i++;
//            isProduced = true;
//            notEmpty.signal();
//        } finally {
//            lock.unlock();
//        }

        //not working....
        // synchronized (lock) {
        // the key here is while, and this cannnot be replaced with if
        synchronized (lock) {
            while (isProduced) {
                //System.out.println("waiting P" + isProduced);
                lock.wait();
            }
            i++;
            Thread.sleep(10);
            System.out.println("new Produce->" + i);
            //the key is to notify all and check in a while loop
            isProduced = true;
            lock.notifyAll();
        }


    }


    public void consume() throws InterruptedException {
//        lock.lock();
//        try {
//            while (!isProduced) {
//                notEmpty.await();
//            }
//            System.out.println("consume->" + i);
//            isProduced = false;
//            notFull.signal();
//        } finally {
//            lock.unlock();
//        }

        //not working....
        synchronized (lock) {
            while (!isProduced) {
                //System.out.println("waiting C" + isProduced);
                lock.wait();
            }
            Thread.sleep(10);
            System.out.println("consume->" + i);
            isProduced = false;
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        BasicMultiplePCsample b = new BasicMultiplePCsample();

        for (int i = 0; i < 13; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            b.produce();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            b.consume();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

    }
}
