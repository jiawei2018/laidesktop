package slidingWindows;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

public class slidingWindowMedian {

    public static void main(String[] args) {
        int[] arr = new int[]{6,6,6};
        slidingWindowMedian t = new slidingWindowMedian();
        System.out.println(t.medianSlidingWindow(arr, 2));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        TreeSet<Pair>  left = new TreeSet<>(new PairComparator().reversed());
        TreeSet<Pair>  right = new TreeSet<>(new PairComparator());


        int lefthalf = k / 2;
        int righthalf = k - k / 2;
        double[] res = new double[nums.length - k + 1];
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            Pair p = new Pair(i, nums[i]);
            System.out.println(left.add(p));
            if(!right.isEmpty() && right.first().value < left.first().value){
                right.add(left.pollFirst());
                left.add(right.pollFirst());
            }
            System.out.println(left.size() + " <left right> " + right.size());
            if(left.size() > lefthalf){
                right.add(left.pollFirst());
            }
            if(i >= k - 1){
                //System.out.println(left.size() + "  " + right.size());
                if(left.size() == 1 && right.isEmpty()) right.add(left.first());
                res[idx++] = lefthalf == righthalf ?  (right.first().value / 2.0 + left.first().value / 2.0) :  right.first().value;
                int leftmost = nums[i - k + 1];
                if( leftmost < right.first().value) {
                    left.remove(leftmost);
                } else {
                    right.remove(leftmost);
                }
            }
        }
        return res;
    }

    private Pair make(int[] nums, int i){
        return new Pair(i, nums[i]);
    }
    class PairComparator implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2){
            if(o1.value == o2.value){
                return 0;
            }else
                return o1.value > o2.value ? 1 : -1;
        }
    }

    class Pair{
        int index;
        int value;
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
        @Override
        public String toString(){
            return "" + index + " <> " + value;
        }
    }
}
