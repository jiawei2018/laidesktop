package AAAAAAAAAAAAA;

public class TestSleep1 implements Runnable {


    public static void main(String[] args) {
        TestSleep1 t1 = new TestSleep1();


        new Thread(t1, "aaa").start();
        new Thread(t1, "bbb").start();
        new Thread(t1, "ccc").start();


    }

    private int ticket = 10;
    //this example is not SAFE!!!!
    @Override
    public void run() {

        while(true) {

            System.out.println(Thread.currentThread().getName() + ticket--);//notice here t-- is doing it now
            //ticket--; <<-- this is complete different from single thread!!!!!!
            //if set to two step then there may be other thread doing -- during this two step
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket <= 0 ){
                break;
            }
        }


    }


}
