package AAAAAAAAAAAAA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class TestProducerConsumerModule {

    public static void main(String[] args) {
        Container container = new Container(10);


        Producer p = new Producer(container, 15);
        Consumer c = new Consumer(container, 15);

        p.start();
        c.start();
    }

}


class Producer extends Thread{
    Container container;
    int num;
    public Producer(Container c, int i){
        container = c;
        num = i;
    }

    @Override
    public void run() {
        for(int i = 0; i < num; i++) {
            //produce here
            Product p = new Product("#"+ i);
            container.push(p);
            System.out.println("produced a new product--->" + p.id);
        }
    }
}

class Consumer extends Thread{
    Container container;
    int num;
    public Consumer(Container c, int i){
        container = c;
        num = i;
    }

    @Override
    public void run() {
        for(int i = 0; i < num; i++){
            Product p = container.pop();
            System.out.println("consumed the product--->" + p.id);
        }
    }

}

class Product {
    String id;
    public Product(String s){
        id = s;
    }
}


class Container {

    Queue<Product> products;
    private int count;

    public Container(int num){
        products = new LinkedList<>();
        count = num;
    }

    public synchronized void push(Product product){

        if(products.size() == count) {
            //means the buffer is full need to consume before produce
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //we can produce products
        products.offer(product);
        this.notifyAll();

    }

    public synchronized Product pop(){
        if(products.size() == 0){
            //means all products is consumed, need refill
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Product product = products.poll();
        this.notifyAll();
        return product;
    }

}