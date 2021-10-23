package jw2021.leet03.myCanlandar123;

import java.util.*;

public class my1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3);
        deque.addFirst(4);

        System.out.println(new ArrayList<>(deque));
    }
    public my1() {
        treeMap = new TreeMap<>();
    }
    private TreeMap<Integer, Integer> treeMap;

    public boolean book(int start, int end) {


        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(start);
        if(entry == null) {
            treeMap.put(start, end);
        } else {
            if(entry.getValue() > start) {
                return false;
            }
        }
        treeMap.put(start, end);
        return true;
    }
}
