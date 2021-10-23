package AAAAAAAAAAAAA.concurrent001.synchroTest;

public class TestSynOnBlockOrMethod implements Runnable{
    static int idx = 0;
    final Object LOCK = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (LOCK){
                if(idx > 50){
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " -> " + idx++);
            }

        }
    }

    public static void main(String[] args) {
        TestSynOnBlockOrMethod t = new TestSynOnBlockOrMethod();
        Thread t1 = new Thread(t, "red");
        Thread t2 = new Thread(t, "blue");
        Thread t3 = new Thread(t,"green");
        t1.start();
        t2.start();
        t3.start();
    }
}
