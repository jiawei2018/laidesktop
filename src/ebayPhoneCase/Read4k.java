package ebayPhoneCase;

import java.util.LinkedList;
import java.util.Queue;

public class Read4k {

    Queue<Byte> queue = new LinkedList<>();
    Queue<Byte> buffer = new LinkedList<>();
    ReadFile4K reader = new ReadFile4K(5);
    private boolean isEnd = false;
    private final int max = 1000;
    public Read4k(int max) {

    }

    private void refill() {
        //refill the queue
        if(queue.size() <  max && !isEnd) {
            //fill!
            while(queue.size() < max && !buffer.isEmpty()) {
                queue.offer(buffer.poll());
            }
        }
    }

    private void fillBuffer() {
        //buffer will around 4k to 8 k
        byte[] r = reader.read();
        if (r.length == 0) {
            isEnd = true;
        }
        for(byte b : r) {
            buffer.offer(b);
        }
    }

    private void transfer() {
        while (!buffer.isEmpty() && queue.size() < max) {
            queue.offer(buffer.poll());
        }
    }

    public byte[] readSize(int size) {

        return null;
    }
}

class ReadFile4K{
    //
    private int idx;
    public ReadFile4K(int size) {
        idx = size;
    }
    public byte[] read(){

        return new byte[4];
    }
}