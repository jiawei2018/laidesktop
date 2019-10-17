package mem_algo;

public class rewrite {

    public void heapSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        int len = nums.length;
        //max heap
        heapify(nums);
        for(int i = len - 1; i >= 0; i--){
            swap(nums, 0, i);
            percuDown(nums, 0, i );
        }



    }

    private void heapify(int[] nums){

        // last root will be at idx = len / 2 - 1;
        int len = nums.length;
        for(int i = len / 2 - 1; i >= 0; i--){
            percuDown(nums, i, len);
        }
    }

    private void percuDown(int[] nums, int idx, int bound){
        while(idx <= bound / 2 - 1) {//此处写错
            int leftchild = idx * 2 + 1;
            int rightchild = idx * 2 + 2;
            int curmax = idx;

            if (leftchild < bound && nums[leftchild] > nums[curmax]) {
                curmax = leftchild;
            }
            if (rightchild < bound && nums[rightchild] > nums[curmax]) {
                curmax = rightchild;
            }
            if (curmax == idx) {
                break;
            }
            swap(nums, idx, curmax);
            idx = curmax;//此处忘了
        }
    }

    private void swap(int[] nums, int idxa, int idxb){
        int tmp = nums[idxa];
        nums[idxa] = nums[idxb];
        nums[idxb] = tmp;
    }
}
