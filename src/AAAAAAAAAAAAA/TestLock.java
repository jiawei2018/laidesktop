package AAAAAAAAAAAAA;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Test1 t = new Test1();

        new Thread(t, "aa").start();
        new Thread(t, "bb").start();
        new Thread(t, "cc").start();

    }


}
class Test1 implements Runnable{

    int num = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {// start with try by recommend
            lock.lock();
            //now to start thread safe block!
            while(true){
                if(num > 0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + num--);
                } else {
                    break;
                }
            }

        } finally {// always remember to unlock the resource!!!!!

            lock.unlock();
        }


    }
}


//class Test1 implements Runnable{
//
//    int num = 10;
//
//    @Override
//    public void run() {
//        while(true){
//            if(num > 0){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " " + num--);
//            } else {
//                break;
//            }
//        }
//    }
//}
