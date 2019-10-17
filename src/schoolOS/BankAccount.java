package schoolOS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance;
    private final Lock balanceChangeLock;
    private Condition sufficientFundsCondition;

    public BankAccount() {
        balance = 0;
        balanceChangeLock = new ReentrantLock();
        sufficientFundsCondition = balanceChangeLock.newCondition();
    }

    public void deposit(int amount, int anID) throws InterruptedException {

        balanceChangeLock.lock();
        try {
            System.out.print("Thread " + anID + " deposits $" + amount);
            int newBalance = balance + amount;
            System.out.println("                               Balance is $" + newBalance);
            balance = newBalance;
            sufficientFundsCondition.signalAll();
        } finally {
            balanceChangeLock.unlock();
        }
    }

    public void withdraw(int amount, int anID) throws InterruptedException {
        balanceChangeLock.lock();
        try {
            while (balance < amount)
                sufficientFundsCondition.await();

            if(balance < amount) {
                System.out.print("Thread " + anID + " withdraw $" + amount);
                System.out.println("Thread" + anID + " ninsufficient fund");
            }
            else {
                System.out.print("Thread " + anID + " withdraw $" + amount);
                int newBalance = balance - amount;
                System.out.println("      Balance is $" + newBalance);
                balance = newBalance;
            }
            sufficientFundsCondition.signalAll();
            //}
        } finally {
            balanceChangeLock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}