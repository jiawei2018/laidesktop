package AAAAAAAAAAAAA.concurrent001.synchroTest.deadlocktest;

public class OtherService {

    private final Object L1 = new Object();

    private DeadLock deadLock;


    public void f1() {
        synchronized (L1) {
            System.out.println("Other f1");
        }
    }

    public void f2() {
        synchronized (L1) {
            System.out.println("Other f2");
            deadLock.m2();
        }
    }


    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
}
