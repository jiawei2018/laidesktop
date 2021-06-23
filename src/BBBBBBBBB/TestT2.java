package BBBBBBBBB;

public class TestT2 implements Runnable {
    private static final int max = 50;
    private int i = 0;
    @Override
    public void run() {

        while(i < max) {
            System.out.println(Thread.currentThread().getName() + " <> " + i++);
        }
    }


    public static void main(String[] args) {
        TestT2 testT2 = new TestT2();
        Thread t1 = new Thread(testT2, "aaa");
        Thread t2 = new Thread(testT2, "bbb");
        Thread t3 = new Thread(testT2, "ccc");
        t1.start();
        t2.start();
        t3.start();


    }
}
