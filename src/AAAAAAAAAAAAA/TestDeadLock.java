package AAAAAAAAAAAAA;

public class TestDeadLock {

    public static void main(String[] args) {
//        Person p1 = new Person(true, "aaa");
//        Person p2 = new Person(false, "bbb");
//
//        new Thread(p1).start();
//        new Thread(p2).start();


    }
}

class Hack extends Thread {

    @Override
    public void run() {

    }
}
//class Book{
//}
//
//class Phone{}
//
//class Person implements Runnable{
//
//    static Book book = new Book();
//    static Phone phone = new Phone();
//
//    boolean flag;
//    String name;
//
//    Person(boolean f, String n){
//        flag = f;
//        name = n;
//    }
//
//    @Override
//    public void run() {
//        try {
//            get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void get() throws InterruptedException {
//        if(flag){
//            synchronized (book){
//                System.out.println(this.name + " had book lock");
//                Thread.sleep(100);
//
//                //remove this out of the book lock will not be a lock
//                synchronized (phone){
//                    System.out.println(this.name + " had phone lock");
//                }
//            }
////            synchronized (phone){
////                System.out.println(this.name + " had  phone lock");
////            }
//
//        } else {
//            synchronized (phone){
//                System.out.println(this.name + " had phone lock");
//                Thread.sleep(100);
//
//                synchronized (book){
//                    System.out.println(this.name + " had book lock");
//                }
//            }
////                synchronized (book){
////                    System.out.println(this.name + " had book lock");
////                }
//
//        }
//
//    }


//}