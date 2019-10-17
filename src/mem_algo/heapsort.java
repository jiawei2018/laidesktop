package mem_algo;

import myHelperUtil.MyPrintHelper;

public class heapsort {

    public static void main(String[] args) {
        int[] a = {9, 7, 6, 8, 9, 7, 6, 8, 8, 65, 4, 3, 2, 2, 345, 7, 89, 8, 75};

        heapsort t = new heapsort();
        t.heapsort(a);
        MyPrintHelper.printArray(a);
    }

    public void heapsort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        heapify(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            percoDown(nums, 0, i);//
        }
    }


    //parent = (child - 1) / 2;
    //leftChild = parent * 2 + 1;
    //rightChild = parent * 2 + 2;
    private void heapify(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {// the parent idx = ( childidx - 1 )/2
            //and last idx = len - 1; so => last root idx = (lastelement_idx - 1)/2
            // idx = (len - 1 - 1) / 2 == len /2 - 1;
            percoDown(nums, i, len);
        }
    }


    private void percoDown(int[] nums, int idx, int bound) {
        while (idx <= bound / 2 - 1) {
            int leftchild = idx * 2 + 1;
            int rightchild = idx * 2 + 2;
            int max = idx;
            if (leftchild < bound && nums[leftchild] > nums[max]) {
                max = leftchild;
            }
            if (rightchild < bound && nums[rightchild] > nums[max]) {
                max = rightchild;
            }
            //get the  max between root, left, right with in bound [0, bound)
            if (max == idx) {
                break;
            }
            swap(nums, idx, max);
            idx = max;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


}
