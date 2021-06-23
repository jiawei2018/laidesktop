package AAAAAAAAAAAAA.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

public class UnSafeList {
    public static void main(String[] args) {
        List<String> d = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            new Thread(()->{
                synchronized (d) {
                    d.add(Thread.currentThread().getName());
                }


            } ).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(d.size());
        System.out.println(d);
    }
}
