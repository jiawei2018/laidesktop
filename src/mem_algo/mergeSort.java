package mem_algo;

import myHelperUtil.MyPrintHelper;

public class mergeSort {
    public  void mg(int[] nums){

        int[] tmp = new int[nums.length];
        mergeSort(nums,tmp, 0, nums.length - 1 );
        nums = tmp;
       // MyPrintHelper.printArray(tmp);
    }

    private void mergeSort(int[] nums , int[] temp, int start, int end){
        if(start >= end){//base case
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid + 1, end);
        merge(nums, temp , start, mid, end);
    }

    private void merge(int[] nums, int[] temp, int start, int mid, int end){
        int left = start;
        int right = mid + 1;
        int cur = left;
        while(left <= mid && right <= end ){
            temp[cur++] = nums[left] >= nums[right] ? nums[right++] : nums[left++];

        }
        while(left <= mid){
            temp[cur++] = nums[left++];
        }
        while(right <= end){
            temp[cur++] = nums[right++];
        }
        for(int i = start; i < cur; i++){
            nums[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,23,7,8,45,4,8,9,5,3,3,3,23};
        mergeSort t = new mergeSort();
        t.mg(arr);
        MyPrintHelper.printArray(arr);

    }


}
