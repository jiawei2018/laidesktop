package myother;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class mock0831 {
    public int q1(int[] arr, int k){
        // 4 7 9 10 k=1   res = 5
        //arr is sorted and k-th > 0

        //how to find
        //j from 1 to end so
        int left = 0;
        int right = arr.length  - 1;
        int res = -1;
        int res2 = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(chk(arr, mid, k)){
                res2 = mid;
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }

        //perform binary search again?

        //perform bs to find rightmost idx that contains less than k elements
        //find leftmost idx contains more than k elementss


        if(res == -1 || res2 == -1){
            return -1;//corner case
            //4[5 6 7 8 ]  9 [10 11 12 13 14] 15; k = 5 return =10
        }
        int ans = (k- (arr[res2] - arr[0])) +arr[res] ;

        return  ans;
    }

    private boolean chk(int[] arr, int idx, int k) {
        if((arr[idx] - arr[0]) - (idx - 1) < k){
            return false;
        }
        return true;
    }



    public int[] getNprison(int[] nums, int N){
        // N > 0 && nums.length > 1
        Map<String ,Integer> map1 = new HashMap<>();
        Map<Integer, int[]> map2 = new HashMap<>();
        int[] res = getNextDay(nums);
        int j = 0;
        for(int i = 1; i < N; i++){
            //map1.put();Arrays.copyOf(res, res.length);
            Integer cur = map1.get(Arrays.toString(res));
            if(cur != null){
                res = map2.get(++cur);//loop
                continue;
            } else {
                res = getNextDay(res);
                map1.put(Arrays.toString(res), ++j);
                map2.put(j, res);
            }
        }
        return res;
    }

    private int[] getNextDay(int[] nums){
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = getIdx(nums, i);
        }
        return res;
    }

    private int getIdx(int[] nums, int idx){
        if(idx - 1 < 0 || idx + 1 >= nums.length){
            return 0;
        }
        if(nums[idx - 1] == nums[idx + 1]){
                return 1;
        }
        return 0;
    }
}
