package AAAAAAAAAAAAA;

import java.util.ArrayList;
import java.util.List;

public class TestStreamParalle {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for( int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.parallelStream().forEach( x -> {

            System.out.println(Thread.currentThread().getName() + " >> "  +x);
        });


    }
}
