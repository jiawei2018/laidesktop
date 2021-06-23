package BBBBBBBBB;

public class ThreadLearn01 {

    public static void main(String[] args) {
        //another way to create a thread
        new Thread("read db"){
            @Override
            public void run() {
                mockReadFromDB();
            }
        }.start();

        new Thread("write to file"){
            @Override
            public void run() {
                mockWriteToFile();
            }
        }.start();


    }


    public static void mockReadFromDB(){
        try {
            System.out.println("start DB");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done DB");

    }


    public static void mockWriteToFile() {
        try {
            System.out.println("file start");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("file done");
    }
}
