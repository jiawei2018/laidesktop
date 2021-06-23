package AAAAAAAAAAAAA;

public class TurtleAndRabbit implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (isWin(i)) {
                break;
            }
            if (i % 50 == 0 && Thread.currentThread().getName().equalsIgnoreCase("rabbit")) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "  -==- step " + i);
        }
    }

    private static String winner;

    public static void main(String[] args) {
        TurtleAndRabbit turtleAndRabbit = new TurtleAndRabbit();

        new Thread(turtleAndRabbit, "turtle").start();
        new Thread(turtleAndRabbit, "rabbit").start();
        //new Thread(turtleAndRabbit,"rabbit2").start();
        //new Thread(turtleAndRabbit,"rabbit3").start();
    }

    private boolean isWin(int step) {
        if (winner != null) {
            return true;
        } else if (step >= 99) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is :" + winner);
            return true;
        }
        return false;
    }

}
