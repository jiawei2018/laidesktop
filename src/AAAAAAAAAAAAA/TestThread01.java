package AAAAAAAAAAAAA;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestThread01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(30);
        List<Integer>  list = new CopyOnWriteArrayList<>();
        List<Future<Integer>> flist = new ArrayList<>();

        for(int i = 0; i < 30; i++) {
            Future<Integer> f = service.submit(new AA( ));
            flist.add(f);
        }

         for(Future<Integer> f : flist) {
             list.add(f.get());
         }
        service.shutdown();
        System.out.println(list);
        System.out.println("main finished...");
    }
}


class AA implements Callable<Integer>{



    @Override
    public Integer call() throws Exception {
        int sleepTime = (int) (Math.random() * 20) * 1000;
        System.out.println(Thread.currentThread().getName() + " -->" + sleepTime / 1000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " completed");
        return sleepTime;

    }
}
