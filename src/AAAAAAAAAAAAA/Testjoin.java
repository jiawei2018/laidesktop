package AAAAAAAAAAAAA;

public class Testjoin implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println( " thread "+ i);
        }
    }
    // join 可以理解为插队, 不要多用,会造成阻塞
    public static void main(String[] args) throws InterruptedException {
        Testjoin t = new Testjoin();
        Thread thread = new Thread(t, "test join");
        thread.start();



        for(int i =0; i < 20; i++){
            if(i == 6){
                thread.join();
            }
            System.out.println("main " + i);
        }

        //below is means the current thread (main) is always running! never stop!!
        Thread.currentThread().join();
    }
}
