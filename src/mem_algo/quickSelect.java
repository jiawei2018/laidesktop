

package mem_algo;
import myHelperUtil.MyPrintHelper;
import myHelperUtil.Swaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class quickSelect {

//    public List<List<Integer>> minimumAbsDifference(int[] arr) {
//        Arrays.sort(arr);
//        int min = Integer.MAX_VALUE;
//        for(int i = 1; i < arr.length; i++ ){
//            min = Math.min(min, arr[i] - arr[i - 1]);
//        }
//        //now we can get all the pairs
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> tmp = new ArrayList<>();
//        for(int i = 1; i < arr.length; i++){
//            tmp.add(arr[i - 1]);
//            tmp.add(arr[i]);
//            if(arr[i] - arr[i - 1] == min){
//                res.add(new ArrayList<>(tmp));
//            }
//            tmp.clear();
//        }
//        return res;
//
//    }

    public void quicksort(int[] nums){

        quicksort(nums, 0, nums.length - 1);
    }

    private void quicksort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int pivot_idx = partition(nums,  start, end);
        quicksort(nums, start, pivot_idx - 1 );
        quicksort(nums,pivot_idx + 1, end);
    }

    public int qselec(int[] nums , int k){
        //corner case skipped
        return quickSelect(nums, k, 0, nums.length - 1);

    }

    private int quickSelect(int[] nums, int k , int start ,int end){
        int pivot = partition(nums, start, end);

        if(k - 1 == pivot){
            return nums[pivot];
        } else if(k - 1 > pivot){
            return quickSelect(nums, k , pivot + 1, end);
        } else {
            return quickSelect(nums, k , start, pivot - 1);
        }
    }

    private int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int left = start;
        int right = end;
        while(left <= right){
            if(nums[left] < pivot){
                left++;
            } else if (nums[right] >= pivot){
                right--;
            } else {//means right < pivot && left > pivot
                Swaps.swap(nums, left, right);
                left++;
                right--;
            }
        }
        Swaps.swap(nums, end, left);
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,23,7,8,45,4,8,9,5,3,3,3,23};
        quickSelect t = new quickSelect();
        System.out.println(t.qselec(arr,6));
        t.quicksort(arr);
        MyPrintHelper.printArray(arr);
    }




}
