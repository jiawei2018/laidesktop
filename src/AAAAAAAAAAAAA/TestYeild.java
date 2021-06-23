package AAAAAAAAAAAAA;

public class TestYeild {

    public static void main(String[] args) {
        TY t = new TY();


        new Thread(t, "aaa").start();
        new Thread(t, "bbb").start();
        new Thread(t, "ccc").start();
        new Thread(t, "ddd").start();
        new Thread(t, "eee").start();

    }


}

class TY implements Runnable{

    @Override
    public void run() {
        System.out.println("start " + Thread.currentThread().getName());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.yield();
        System.out.println("end " + Thread.currentThread().getName());
    }
}