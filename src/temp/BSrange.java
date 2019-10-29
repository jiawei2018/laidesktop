package temp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BSrange {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,5,5,6,7,8};
        //System.out.println(Arrays.toString(getR(arr, 9)));

        int[] arr1 = {1,0,1,1,0,1,0,0,0,0,0,0,1,1};
        //System.out.println(get0101(arr1, 2));
        //System.out.println(Integer.toBinaryString(16));
        //System.out.println(Integer.parseInt("0001001", 2));
        int a = Integer.parseInt("1001", 2);
        int b = Integer.parseInt("0001", 2);
        Set<Character> set = new HashSet<>();
         String gg = "";

        System.out.println(Integer.toBinaryString(7 ^ 4));
    }

    private static int get0101(int[] nums, int k){
        //sliding window
        // array contains 1 and 0  find the length of length sub array which
        // perform only k steps (0 -> 1) convert
        int res = 0;
        int left = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count++;
            }
            while(count > k && left <= i){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }


    private static int[] getR(int[] nums, int target){
        //sanity chk
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int[] res = {-1, -1};
        res[0] = get(nums, target, true)  ;
        res[1] = get(nums, target, false)  ;
        return res;
    }

    private static int get(int[] nums, int target, boolean isLeft){
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                res = mid;
                if(isLeft){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }


}
