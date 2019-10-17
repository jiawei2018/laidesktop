package schoolOS;

public class Withdraw implements Runnable{
    private BankAccount account;
    private int amount;
    private int id;

    public Withdraw(BankAccount anAccount, int anAmount, int anID) {
        account = anAccount;
        amount = anAmount;
        id = anID;
    }

    public void run() {
        try {
            account.withdraw(amount, id);
        } catch (InterruptedException exception) {}
    }
}
