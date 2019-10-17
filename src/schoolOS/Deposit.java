package schoolOS;

public class Deposit implements Runnable{
    private static final int DELAY = 10;
    private BankAccount account;
    private int amount;
    private int id;

    public Deposit(BankAccount anAccount, int anAmount, int anID) {
        account = anAccount;
        amount = anAmount;
        id = anID;
    }

    public void run() {
        try {
            account.deposit(amount, id);
            Thread.sleep(DELAY);
        } catch (InterruptedException exception) {}
    }
}
