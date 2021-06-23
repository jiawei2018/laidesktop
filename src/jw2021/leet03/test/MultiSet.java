package jw2021.leet03.test;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class MultiSet<T extends Comparable<T>> {

    TreeMap<T, Integer> map ;
    public MultiSet(){
        map = new TreeMap<>();
    }



    public boolean add(T t) {

        if(map.containsKey(t)) {
            map.put(t, map.get(t) + 1);
        } else {
            map.put(t, 1);
        }
        //.putIfAbsent(t, map.getOrDefault(t, 0) + 1);
        return true;
    }

    public int getCount(T t){
        return map.getOrDefault(t, 0);
    }

    public T remove(){
        Map.Entry<T, Integer> entry = map.lastEntry();
        int count = entry.getValue();
        T r = entry.getKey();
        if(count == 1){
            map.remove(r);
        } else {
            map.put(r, count - 1);
        }
        return r;
    }

    public int size() {
        return map.size();
    }
}
