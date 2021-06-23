package AAAAAAAAAAAAA;

import java.util.concurrent.*;

public class TestCallable implements Callable<Integer> {

    private String name;

    public TestCallable(String n){
        name = n;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println("start " + name);
        return (int) (Math.random() * 1000);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("aa");
        TestCallable t2 = new TestCallable("bb");
        TestCallable t3 = new TestCallable("cc");


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Integer> f1 = executorService.submit(t1);
        Future<Integer> f2 = executorService.submit(t2);
        Future<Integer> f3 = executorService.submit(t3);

        Integer r1 = f1.get();
        Integer r2 = f2.get();
        Integer r3 = f3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        executorService.shutdown();
    }
}
