package AAAAAAAAAAAAA.concurrent001.produce_and_consume;

public class BasicSingleProduceConsume {

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
                System.out.println("new Produce->" + i);
                isProduced = true;
                LOCK.notify();//easy to forget!!!
            }
        }
    }


    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                //use!
                System.out.println("consume->" + i);
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

    public static void main(String[] args) {
        BasicSingleProduceConsume b = new BasicSingleProduceConsume();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    b.produce();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    b.consume();
                }
            }
        }.start();

    }

}
