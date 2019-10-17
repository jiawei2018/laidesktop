package plan3;

import java.util.ArrayList;
import java.util.List;

public class last {
    public int maxDistancel(List<List<Integer>> arrays) {
        //WRONG
        return 0;
    }
    //    class Tuple {
    //
    //        int min;
    //        int max;
    //        int index;
    //
    //        public Tuple(int min, int max, int index) {
    //            this.min = min;
    //            this.max = max;
    //            this.index = index;
    //        }
    //    }
    //
    //    public int maxDistance(List<List<Integer>> arrays) {
    //
    //        int size = arrays.size();
    //
    //        if(size==0) {
    //            return 0;
    //        }
    //
    //        PriorityQueue<Tuple> minHeap = new PriorityQueue<>(
    //            new Comparator<Tuple>() {
    //                public int compare(Tuple a, Tuple b) {
    //                    return a.min-b.min;
    //                }
    //            });
    //
    //        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>(
    //            new Comparator<Tuple>() {
    //                public int compare(Tuple a, Tuple b) {
    //                    return b.max-a.max;
    //                }
    //            });
    //
    //        for (int i=0;i<size;i++) {
    //            Tuple t = new Tuple(arrays.get(i).get(0), arrays.get(i).get(arrays.get(i).size()-1), i);
    //            minHeap.add(t);
    //            maxHeap.add(t);
    //        }
    //
    //        Tuple maxHeap1 = maxHeap.poll();
    //        Tuple maxHeap2 = maxHeap.poll();
    //
    //        Tuple minHeap1 = minHeap.poll();
    //        Tuple minHeap2 = minHeap.poll();
    //
    //        if(maxHeap1.index!=minHeap1.index) {
    //            return maxHeap1.max - minHeap1.min;
    //        }
    //
    //        return Math.max((maxHeap1.max - minHeap2.min), (maxHeap2.max - minHeap1.min));
    //
    //    }

    public int maxDistance(List<List<Integer>> arrays) {

        List<Integer> pre = arrays.get(0);
        int min = pre.get(0);
        int max = pre.get(pre.size() - 1);
        int res = 0;
        for(int i = 1; i < pre.size(); i++){
            List<Integer> l = arrays.get(i);
            int first = l.get(0);
            int last = l.get(l.size() - 1);

            res = Math.max(res, last - min);
            res = Math.max(res, max - first);
            min = Math.min(min, first);
            max = Math.max(max, last);


        }
        return res;
    }





    public static void main(String[] args) {
        //[[1,2,3],[4,5],[1,2,3]]
        List<List<Integer>> a = new ArrayList<>();
       List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a3 = new ArrayList<>();
        a1.add(1);a1.add(2);a1.add(3);
        a2.add(4);a2.add(5);
        a3.add(1);a3.add(2);a3.add(3);

        a.add(a1);a.add(a2);a.add(a3);

        last t = new last();
        System.out.println(t.maxDistance(a));

    }
}
