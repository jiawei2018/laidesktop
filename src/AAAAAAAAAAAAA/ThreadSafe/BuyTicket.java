package AAAAAAAAAAAAA.ThreadSafe;

public class BuyTicket {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        new Thread(t, "aa").start();
        new Thread(t, "bb").start();
        new Thread(t, "cc").start();

    }

}


class Ticket implements Runnable{

    private int num = 15;
    private boolean flag = false;

    @Override
    public void run() {
        while(!flag){
            buy();
        }
    }

    public synchronized void buy(){
        if(num < 0){
            flag = true;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has " + num--);

    }

}
