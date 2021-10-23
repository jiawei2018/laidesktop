package AAAAAAAAAAAAA.concurrent001.produce_and_consume;

import java.util.stream.Stream;

public class BasicTwoProduceConsume {

    private final Object LOCK = new Object();

    //chk volatile means!
    private volatile boolean isProduced = false;
    private int i = 0;

    public void produce() {
        //produce a int number
        synchronized (LOCK) {
            if (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println(Thread.currentThread().getName() + "new Produce->" + i);
                isProduced = true;
                LOCK.notify();//easy to forget!!!
            }
        }
    }


    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                //use!
                System.out.println(Thread.currentThread().getName() + "consume->" + i);
                LOCK.notify();//easy to forget!!!
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //TODO This is WRONG! example!!!!
    public static void main(String[] args) {
        BasicTwoProduceConsume b = new BasicTwoProduceConsume();
        Stream.of("p1", "p2").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            b.produce();
                        }
                    }
                }.start()
        );

        Stream.of("c1", "c2").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            b.consume();
                        }
                    }
                }.start()
        );
    }

}
