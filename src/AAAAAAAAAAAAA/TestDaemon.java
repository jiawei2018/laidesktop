package AAAAAAAAAAAAA;

public class TestDaemon {


    public static void main(String[] args) {
        MyDaemon myDaemon = new MyDaemon();
        NorT norT = new NorT();

        Thread td = new Thread(myDaemon);
        td.setDaemon(true); //default is false, means is user Thread
        td.start();

        new Thread(norT).start();
    }

}


class MyDaemon implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("daemon is running....");
        }
    }
}


class NorT implements Runnable{

    @Override
    public void run() {
        for(int i =0; i < 5; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("user thread " + i);
        }
        System.out.println("=====user finished=====");
    }
}