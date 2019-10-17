package plan3;

import java.util.*;

public class lc436test {
    class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public void test(Interval[] arr){
        Arrays.sort(arr,  (a, b) ->(a.end - b.end));
        int a = 0;
        int[] nums = new int[1];
//        boolean flag = a > 0 ? true : false;
//        int idx = flag  ? nums.length - 1 : 0 ;
//
//        int[] res = new int[nums.length];
//        int left = 0;
//        int right = nums.length - 1;
//        while(left <= right){
////            int l = cal(nums[left], a, b, c);
////            int r = cal(nums[right], a, b, c);
//            if(flag){
//                res[idx--] = l > r ? l : r;
//                int tmp = l > r ? left++ : right--;
//            } else {
//                res[idx++] = l < r ? l : r;
//                int tmp = l < r ? left++ : right--;
//            }
//        }
            String u = "asd";
           List<Integer> aa = new ArrayList<>();
          // Collections.sort();



    }


    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }


}
