package AAAAAAAAAAAAA.concurrent001.shutdownThread;

public class TestTreadShutDownWay3 {
    //the idea is to make the actrual Thread as a daemon Thread, the execute Thread is a THread to ans the
    //interrupt signal

    private Thread executeThread;
    private boolean flag = false;

    public void runTask(Runnable task) {
        executeThread = new Thread(){
            @Override
            public void run() {
                Thread taskThread = new Thread(task);
                taskThread.setDaemon(true);
                taskThread.start();
                try {
                    taskThread.join();//when join, the execute thread is running till task finished!
                    flag = true; // this means the task thread is finished normally!
                } catch (InterruptedException e) {
                    //otherwise, we will

                    e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(long time) {
        //send out the interrupt signal
        long start = System.currentTimeMillis();
        while(!flag) {//means only if the task is not finish!
            if(System.currentTimeMillis() - start >= time) {
                //means time out!
                executeThread.interrupt();
                break;// bug here! have to shutdown main!
            }

            try {
                executeThread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("signal from outside!!!");
                //executeThread interrupt!
                break;
            }
        }
        flag = false;
    }



}
