package Hashmap_String_I;

import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Given a composition with different kinds of words,
 * return a list of the top K most frequent words in the composition.
 *
 * Assumptions
 *
 * the composition is not null and is not guaranteed to be sorted
 * K >= 1 and K could be larger than the number of distinct words in the composition,
 * in this case, just return all the distinct words
 * Return
 *
 * a list of words ordered from most frequent one to least frequent one
 * (the list could be of size K or smaller than K)
 * Examples
 *
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
 */
public class topKFrequentWords {

    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here

        if(combo == null || combo.length == 0 || k < 1){
            return null;
        }
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < combo.length; i++){
            if(map.containsKey(combo[i])){
                int count = map.get(combo[i]);
                map.put(combo[i],count + 1);
            }else
            map.put(combo[i], 1);
        }

        PriorityQueue<MyPair> minHeap = new PriorityQueue<>();

        for(String s : map.keySet()){
            MyPair tmp = new MyPair(s, map.get(s));
            if(minHeap.size() < k){
                minHeap.offer(tmp);
            }else if(tmp.frequent > minHeap.peek().frequent){
                minHeap.poll();
                minHeap.offer(tmp);
            }
        }
        LinkedList<String> temp = new LinkedList<>();
        while(!minHeap.isEmpty()){
            temp.addFirst(minHeap.poll().word);
        }
        int j = 0;
        String[] res = new String[temp.size()];
        for(String s : temp){
            res[j++] = s;
        }


        return res;
    }

    class MyPair implements Comparable<MyPair>{
        String  word;
        int frequent;
        public MyPair(){

        }
        public MyPair(String word, int frequent){
            this.word = word;
            this.frequent = frequent;
        }

        @Override
        public int compareTo(MyPair o) {
            if(frequent < o.frequent){
                return -1;
            }else if(frequent > o.frequent){
                return 1;
            }else
                return 0;
        }//com
    }
}
