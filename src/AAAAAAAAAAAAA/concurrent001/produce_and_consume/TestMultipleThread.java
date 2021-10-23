package AAAAAAAAAAAAA.concurrent001.produce_and_consume;

public class TestMultipleThread {

        //private String name;
        private int age = 0;

        //表示共享资源对象是否为空，如果为 true，表示需要生产，如果为 false，则有数据了，不要生产
        private boolean isEmpty = true;
        /**

         */
        public synchronized void push(){
            try {
                //不能用 if，因为可能有多个线程
                while(!isEmpty){//进入到while语句内，说明 isEmpty==false，那么表示有数据了，不能生产，必须要等待消费者消费
                    this.wait();//导致当前线程等待，进入等待池中，只能被其他线程唤醒
                }

                //-------生产数据开始-------
                //this.name = name;
                //延时代码
                //Thread.sleep(10);
                //this.age = age;
                age++;
                //-------生产数据结束-------
                isEmpty = false;//设置 isEmpty 为 false,表示已经有数据了
                this.notifyAll();//生产完毕，唤醒所有消费者
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        /**
         * 取数据，消费数据
         * @return
         */
        public synchronized void pop(){
            try {
                //不能用 if，因为可能有多个线程
                while(isEmpty){//进入 while 代码块，表示 isEmpty==true,表示为空，等待生产者生产数据，消费者要进入等待池中
                    this.wait();//消费者线程等待
                }
                //-------消费开始-------
                //Thread.sleep(10);
                System.out.println(" >>" + age);
                //-------消费结束------
                isEmpty = true;//设置 isEmpty为true，表示需要生产者生产对象
                this.notifyAll();//消费完毕，唤醒所有生产者
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    public static void main(String[] args) {
        TestMultipleThread t = new TestMultipleThread();

        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        t.push();
                    }
                }
            }.start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true)
                        t.pop();
                }
            }.start();
        }
    }

}
