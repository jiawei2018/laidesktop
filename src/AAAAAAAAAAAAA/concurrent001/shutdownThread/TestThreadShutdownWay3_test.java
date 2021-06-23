package AAAAAAAAAAAAA.concurrent001.shutdownThread;

public class TestThreadShutdownWay3_test {

    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(true) {
                    System.out.println("death loop...");
                }
            }
        };

        TestTreadShutDownWay3 way3 = new TestTreadShutDownWay3();
        long start = System.currentTimeMillis();
        way3.runTask(() -> {
            while(true){
            }
        });
        way3.shutdown(3000);
        System.out.println(System.currentTimeMillis() - start);
    }
}
