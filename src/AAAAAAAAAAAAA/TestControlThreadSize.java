package AAAAAAAAAAAAA;

import java.awt.font.TextHitInfo;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestControlThreadSize implements Runnable {

    private String name;

    public TestControlThreadSize(String n) {
        name = n;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + name);
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        for(int i = 0; i < 100; i++) {
            TestControlThreadSize tmp = new TestControlThreadSize(" " + i);
            executorService.submit(tmp);
        }

        executorService.shutdown();
    }

}
