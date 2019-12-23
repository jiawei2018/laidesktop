package binarySearch;

public class missingN_number_find_Kth {

    public static void main(String[] args) {
        //                                            1 2    3 4 5   6  7  8  9  10
        int[] arr = {1,2,5,6,7,11,12,13,19};//missing 3 4    8 9 10, 14,15,16,17,18

        missingN_number_find_Kth t = new missingN_number_find_Kth();
        for(int i =1; i <= 10; i++){
            //System.out.println(t.findMissingK(arr, i));
        }

        int[] a1 = {4,1,0,3,2};
        System.out.println(t.getMissing(a1));
    }

    private int getMissing(int[] nums){
        //[4,1,0,3]
        int len = nums.length;
        int j = 0;
        for(int i = 0; i <= len; i++){
            //we cant xor every one since wedont know which one is missing
            j ^= i;
        }

        for(int i = 0; i< len; i++){
            j ^= nums[i];
        }
        return j;
    }


    public int findMissingK(int[] nums, int k){
        //sorted, [1 to n +1] missing 1 or more
        int left = 0;
        int right = nums.length - 1;

        int res = -1;
        int count = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] - mid - 1 >= k){
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int diff = nums[res] - res - 1;

        if(diff == k){
            return nums[res] - 1;
        } else {//diff > k
            int idx = diff - k;
            return nums[res] -1 - idx;
        }


    }
}
