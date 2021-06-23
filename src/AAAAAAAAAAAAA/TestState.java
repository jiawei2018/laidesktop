package AAAAAAAAAAAAA;

public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> {
            for(int i =0; i < 10; i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finished");
        });



        Thread.State state = t.getState();
        System.out.println(state);

        t.start();
        state = t.getState();
        System.out.println(state);

        while(state != Thread.State.TERMINATED){
            Thread.sleep(200);
            state = t.getState();
            System.out.println(state);
        }

        //after Thread is terminated we can not start it again!!!
        t.start();
    }





}
