package debug;

import java.util.*;

public class MapTreeSet {
    Map<Integer, Integer> map ; // <id, freq>
    TreeMap<Integer, Set<Integer>> freqmap;//<ferq, <id>>
    public MapTreeSet(int n) {// n plays
        map = new HashMap<>();
        freqmap = new TreeMap<>((i1, i2) -> i2 - i1 );//reverse
        //init the treemap and hashmap
        freqmap.put(0, new HashSet<>());
        for(int id = 1; id <= n; id++) {
            map.put(id, 0);
            freqmap.get(0).add(id);
        }
    }

    public void check(int id) {
        //when we chk we add the current id's freq by 1;
        int freq = map.get(id);
        int newfreq = freq + 1;
        map.put(id, newfreq);
        Set<Integer> cur = freqmap.get(freq);
        cur.remove(id);//remove from old
        if(cur.size() == 0) {
            freqmap.remove(freq);
        }
        //add to new one
        freqmap.put(newfreq, new HashSet<>());
        freqmap.get(newfreq).add(id);

    }

    public List<Integer> leading(int k) {
        List<Integer> res = new ArrayList<>();
        for(int freq : freqmap.keySet()) {
            Set<Integer> cur = freqmap.get(freq);
            for(int id : cur) {
                if(res.size() == k) {
                    break;
                }
                res.add(id);
            }
        }
        return res;
    }

}
