package AAAAAAAAAAAAA;

public class TestPriority {

    public static void main(String[] args) {
        //main thread priority
        System.out.println(Thread.currentThread().getName() + "--"+ Thread.currentThread().getPriority());

        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        Thread t4 = new Thread(myThread);
        Thread t5 = new Thread(myThread);
        Thread t6 = new Thread(myThread);


        //MUST set priority first then use it

        t1.setPriority(1);
        t1.start();


        t2.setPriority(5);
        t2.start();


        t3.setPriority(10);
        t3.start();


        t4.setPriority(6);
        t4.start();

        t5.setPriority(3);
        t5.start();

        t6.setPriority(8);
        t6.start();

    }


}



class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--"+ Thread.currentThread().getPriority());
    }
}