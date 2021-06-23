package AAAAAAAAAAAAA.concurrent001;

public class TestInterrupt {
    private static Object obj = new Object();
    public static void main(String[] args)  {
//        Thread t = new Thread(){
//             @Override
//             public void run() {
//                 while(true) {
//                      //method 1 using sleep to catch interrupt signal;
////                     try {
////                         Thread.sleep(10);
////                     } catch (InterruptedException e) {
////                         System.out.println("got interrupt signal!");
////                         e.printStackTrace();
////                     }
//
//
//                     //using wait to catch interrupt signal;
//
//                     //any OBJ can be a monitor; string, list .......
//
//                     synchronized (obj){
//                         try {
//                             obj.wait(10);
//                         } catch (InterruptedException e) {
//                             System.out.println("got from wait");
//                             e.printStackTrace();
//                         }
//                     }
//                     //System.out.println(this.isInterrupted());//why when using lambda is not working?
//                 }
//             }
//        };

//        Thread t1 = new Thread(() -> {
//
//            System.out.println("qweqwe");
//        });




//        t.start();
//        Thread.sleep(100);
//        System.out.println(t.isInterrupted());
//        t.interrupt();
//        System.out.println(t.isInterrupted());


        //how to interrupt a join() thread

        Thread t = new Thread(){
            @Override
            public void run() {
                while(true) {
                }
            }
        };
        t.start();

        //we need another thread to interrupt the t; ->
        Thread main  = Thread.currentThread();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //t.interrupt(); // <- this will NOT work, since t is joined main Thread!
                main.interrupt();// this is how it worked!!!!!
                System.out.println("interrupt");
            }
        };
        t1.start();
        //join
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
