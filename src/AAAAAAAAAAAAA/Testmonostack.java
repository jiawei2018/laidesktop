package AAAAAAAAAAAAA;

import java.util.*;

public class Testmonostack {
    public static void main(String[] args) {
        List<Long> arr = List.of(2L, 4L, 3L, 8L);

        System.out.println(task(arr));
        System.out.println("real" + task2(arr));
    }

    public static List<Long> task(List<Long> arr) {
        List<Long> res = new ArrayList<>();
        //how about using
        //2 heap  maxheap , minheap ???
        // n ,nlogn, ....n^2 is what???

        for (int i = 0; i < arr.size(); i++) {

        }

        return res;
    }

    public static List<Long> task2(List<Long> arr) {
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            long counter = 0l;
            int idx = i;
            int curr = i;
            while (curr > 0) {
                if (arr.get(idx) < arr.get(curr - 1)) {
                    counter -= Math.abs(arr.get(idx) - arr.get(curr - 1));
                } else {
                    counter += Math.abs(arr.get(idx) - arr.get(curr - 1));
                }
                curr--;
            }
            res.add(counter);
        }
        for (long l : res) {
            //System.out.println(l);
        }
        return res;
    }


}
