package AAAAAAAAAAAAA;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestPool {

    public static void main(String[] args) {
        //creat a size = 10 Thread pool
        ExecutorService pool = Executors.newFixedThreadPool(10);

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.writeLock().lock();

        //execute
        //for Callable we need to use submit()
        // Future<T> f1 = executorService.submit(t1); t1 is implement callable<T>
        pool.execute(new TT());
        pool.execute(new TT());
        pool.execute(new TT());
        pool.execute(new TT());
        pool.execute(new TT());
        pool.execute(new TT());

        //quit
        pool.shutdown();

    }
}


class TT implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
