package schoolOS;

import java.util.Random;


public class Tester {

    private int MIN = 2;
    private int dMax = 100;
    private int wMax = 25;

    Random number = new Random();

    BankAccount account = new BankAccount();
    Thread d1 = new Thread(new Deposit(account, 2 * (number.nextInt(dMax - MIN + 1) + MIN), 1));
    Thread d2 = new Thread(new Deposit(account, 2 * (number.nextInt(dMax - MIN + 1) + MIN), 2));
    Thread d3 = new Thread(new Deposit(account, 2 * (number.nextInt(dMax - MIN + 1) + MIN), 3));

    Thread w4 = new Thread(new Withdraw(account, 2 * (number.nextInt(wMax - MIN + 1) + MIN), 4));
    Thread w5 = new Thread(new Withdraw(account, 2 * (number.nextInt(wMax - MIN + 1) + MIN), 5));
    Thread w6 = new Thread(new Withdraw(account, 2 * (number.nextInt(wMax - MIN + 1) + MIN), 6));
    Thread w7 = new Thread(new Withdraw(account, 2 * (number.nextInt(wMax - MIN + 1) + MIN), 7));

    public static void main(String[] args) {

        System.out.println("Deposit            Withdrawal           Balance");
        System.out.println(" ");
        for(int i = 0; i < 3; i++)
            new Tester();
    }

    public Tester() {
        d1.start();
        w4.start();
        d2.start();
        w5.start();
        d3.start();
        w6.start();
        w7.start();
    }

}

