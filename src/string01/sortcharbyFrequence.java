package string01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class sortcharbyFrequence {
    public String frequencySort(String s) {
        if(s == null ||s.length() < 3){
            return s;
        }
         s.toUpperCase();
        Map<Character, pair> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, new pair());
                map.get(c).c = c;
            }
            map.get(c).freq += 1;
        }
       // PriorityQueue<pair> heap = new PriorityQueue<pair>((a ,b) -> (a.freq - b.freq) );

        PriorityQueue<pair> heap = new PriorityQueue<pair>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return 0;
            }
        });

        for(pair p : map.values()){
            heap.offer(p);
        }
        StringBuilder sb = new StringBuilder();

        while(!heap.isEmpty()){
            pair cur = heap.poll();
            sb.append(gen(cur));
        }
        return sb.toString();
    }


    private String gen(pair p){
        StringBuilder sb = new StringBuilder();
        int i = p.freq;
        while(i > 0){
            sb.append(p.c);
        }
        return sb.toString();
    }

    class pair{
        char c;
        int freq;
        // public pair(char c, int freq){
        //     this.c = c;
        //     this.freq = freq;
        // }
    }
}
