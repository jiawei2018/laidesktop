package AAAAAAAAAAAAA.concurrent001.shutdownThread;

public class TestThreadCloseGracefullyTwo {

    private static class Worker extends Thread{
        //private volatile boolean flag = true;
        //using interrupt to shutdown a thread
        @Override
        public void run() {
            while(true){
                //doing something....

                //use sleep to quit
//                try {
//                    Thread.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    break;// <- how we shut down
//                }


                if(this.isInterrupted()) {
                    break;
                }
            }
        }


    }

    public static void main(String[] args) {
        Worker w = new Worker();
        w.start();

        try {
            Thread.sleep(1000);
            //we are waiting worker to do the job, max time is 1000ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.interrupt();

    }

}

/*
* 深入剖析volitail关键字

1.volatile关键字的语义

被volitail修饰的实例变量或者类变量具备如下两层语义：
保证了不同线程之间对共享变量操作时的可见性，也就是说当一个线程修改volitail修饰的变量，另外一个线程会立即看到最新的值。
禁止对指令进行重排序操作。

2.volitail保证可见性

Reader线程从主内存中获取init_value的值为0，并且将其缓存到本地工作内存中。
Updater线程将init_valued的值在本地工作内存中修改为1，然后立即刷新至主内存中。
Reader线程在本地工作内存中的init_value失效，因此需要到主内存中重新读取init_value的值。

3.volitail保证了顺序性

volatile会直接禁止JVM和处理器对volitail关键字修饰的指令重排序，但是对于volatile前后无依赖关系的的指令则可以随便怎么排序。
比如：
int x = 0;
int y = 1;
volitail int z = 20;
x++；
y–;
在语句volitail int z = 20之前，先执行x的定义还是先执行y的定义，我们并不关心，只要能百分之百保证到z=20的时候x=0,y=1，同理关于x的
的自增以及y的自减操作都必须在z=20之后发生。

4.volitail不保证原子性

private static volatile int i = 0;
多个线程对i执行i++;最后的结果肯定是错误的。
i++的操作其实是分三步组成的：
1）.从主内存中获取i的值，然后缓存至线程的工作内存中
2）.在线程工作内存中为i进行加1操作
3）.将i的最新值写入主内存中
上述3操作单独每一个都是原子性操作，但是合起来就不是了，因为在执行过程中很有可能被其他线程打断。例如如下的操作情况：
1）假设此时i 的值为100，线程A要对变量i执行自增操作，首先它需要都主内存中读取i的值，可是此时由于CPU的时间片调度的关系，执行权切换到了
线程B，A线程进入了RUNNABLE状态而不是RUNNING状态。（就是说A读取了主内存中i的值之后，CPU切换到了线程B下）
2）线程B同样需要读取主内存中i的值，由于线程A没有对i做过任何修改操作，因此此时B获取到的i仍然是100.
3）线程B工作内存中为i执行了加1的操作，但是未刷新至主内存中。
4）CPU时间片的调度又将执行权给了线程A，A线程直接对工作线程中的100进行加1运算（因为A线程已经从主内存中读取了i的值），由于B线程并未写入i
的最新值，因此A线程工作空间的100不会失效。（即使变量i被volitail关键字修饰，但是B线程还没有对i的值进行修改刷新到主内存，所以A的本地工作
内存中的i的值不会失效，A不会去主存中读取i的值）
5）线程A将i=101写入主内存中
6）线程B将i=101写入主内存中（上面虽然线程A修改了主内存中i的值，使线程B中的工作内存中i的值失效了，线程B会立即到主内存中去读取最新的i的值
这里体现了可见性，B线程读取到了i=101之后的操作是把自己工作内存中改动i=101并刷新到主内存中去）
*
* */
