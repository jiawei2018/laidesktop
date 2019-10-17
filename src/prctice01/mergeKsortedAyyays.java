package prctice01;

import java.util.*;

public class mergeKsortedAyyays {
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here
        int[][] nums = arrayOfArrays;
        int m = nums.length;
        //int n = nums[0].length;
        List<Integer> res =  new ArrayList<>();
        if(m == 0 ){
            return toarray(res);//toArray(new int[res.size()]);
        }

        PriorityQueue<Pair> heap = new PriorityQueue();
        //initial
        for(int i =0; i< m; i++){
            if(nums[i].length == 0){
                continue;
            }
            Pair tmp = new Pair(i, 0, nums[i][0]);
            heap.offer(tmp);
        }
        int i = 0;
        while(!heap.isEmpty()){
            Pair tmp = heap.poll();
            res.add(tmp.val);
            int n = nums[tmp.row].length;
            if(tmp.idx < n - 1){
                Pair newtmp = new Pair(tmp.row, tmp.idx + 1, nums[tmp.row][tmp.idx + 1]);
                heap.offer(newtmp);
            }
        }

        return toarray(res);
    }

    private int[] toarray(List<Integer> list){
        int[] res = new int[list.size()];
        int n = 0;
        for(int i : list){
            res[n++] = i;
        }
        return res;
    }

    class Pair implements Comparable<Pair>{
        int row;
        int idx;
        int val;
        public Pair(int row, int idx,int val){
            this.row = row;
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            if(o.val == val){
                return 0;
            }else{
                return o.val < val ? 1 : -1;
            }
        }
    }

}
