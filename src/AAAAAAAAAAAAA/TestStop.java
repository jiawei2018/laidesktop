package AAAAAAAAAAAAA;

public class TestStop implements Runnable {
    private boolean flag = false;
    @Override
    public void run() {
        int i = 0;
        while(!flag){
            System.out.println("running..." + i++);
        }
    }

    public void quit(){
        flag = true;
    }


    public static void main(String[] args) {
        TestStop t1 = new TestStop();

        new Thread(t1).start();

        for(int i = 0;i < 100; i++){
            System.out.println("count...." + i);
            if(i == 90){
                t1.quit();
            }
        }

    }
}
