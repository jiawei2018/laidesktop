package AAAAAAAAAAAAA.ThreadSafe;

public class DrawMoney {

    public static void main(String[] args) {
        Account a = new Account(100, "account");

        Drawing d = new Drawing(a, 88, "aaa");
        Drawing d1 = new Drawing(a, 77, "bbb");

        new Thread(d).start();
        new Thread(d1).start();

        System.out.println(a.total);
    }
}

class Account{
    int total;
    String name;

    public Account(int i, String str){
        total = i;
        name = str;
    }
}


class Drawing extends Thread {

    Account account;
    int num;

    public Drawing(Account a, int n, String s) {
        super(s);
        account = a;
        num = n;


    }


    @Override
    public void run() {
        draw();
    }

    private void draw(){
        synchronized ("ac") {//any object will work ....
            if(account.total < num){
            //failed
                System.out.println("not enough");
                return;
            }
        //succeed
            account.total -= num;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " has " + num);
        System.out.println(account.total + " << rest");
    }
}