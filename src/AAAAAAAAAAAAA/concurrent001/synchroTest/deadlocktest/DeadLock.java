package AAAAAAAAAAAAA.concurrent001.synchroTest.deadlocktest;

import java.util.List;

public class DeadLock {

    private OtherService otherService;

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    private final Object LOCK = new Object();

    public void m1() {
        synchronized (LOCK) {
            System.out.println("dead m1");
            otherService.f1();
        }
    }

    public void m2(){
        synchronized (LOCK) {
            System.out.println("dead m2");
        }
    }
}
