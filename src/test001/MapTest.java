package test001;

import myUS.Time;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MapTest {
    public static void main(String[] args) {

        final long start = System.currentTimeMillis();
        Map<String , String> testMap = new HashMap<>();

        int pairNum = 10000000;
        for(int i = 0; i < pairNum; i++) {
            String u = UUID.randomUUID().toString();
            String v = UUID.randomUUID().toString();

            testMap.put(u, v);
        }

        System.out.println("time in ms : " + (System.currentTimeMillis() - start));

        System.out.println(testMap.size());

        int pn = 10;
        for(String u : testMap.keySet()){
            if(pn < 0) break;
            System.out.println(u + "  +  "+ testMap.get(u));
            pn--;
        }
    }
}
