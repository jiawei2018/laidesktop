package practice08_heapify;

public class implementHeap_min {
    class minHeap{
        int size;
        int[] nums;
        private void swap(int[] nums, int idxa, int idxb){
            int temp = nums[idxa];
            nums[idxa] = nums[idxb];
            nums[idxb] = temp;
        }

        private void percolateUp(int[] nums, int idx){//i is index
            while(idx  >= 0){
                int parentIdx = (idx - 1) / 2;
                if(nums[parentIdx] > nums[idx]){
                    swap(nums, parentIdx, idx);
                    idx = parentIdx;
                }else{
                    break;
                }
            }
        }

        private void percolateDown(int[] nums, int idx){//lots of mistakes
            while(idx < (size - 2) / 2){//mistake
                int lchild = 2 * idx + 1;
                int rchild = 2 * idx + 2;
                int minchild =  lchild;

                if(rchild <= size - 1 && nums[lchild] > nums[rchild]){
                      minchild = rchild ;
                }

                if(nums[minchild] > nums[idx]){
                    swap(nums, idx, minchild);
                }else{
                    break;
                }
                idx = minchild;
             }

        }

        public void heapify(int[] nums){
            if(nums.length < 2){
                return;
            }
            int idx = (nums.length - 2) / 2;//use = size / 2 - 1
            for(int i = idx; i >= 0; i--){
                percolateDown(nums,nums[i]);
            }

        }

        public void offer(int in){//extend space include
            if(size == nums.length){
                int[] newarr = new int[(int)(size * 1.5)];
                copyarr(nums, newarr);
                nums= newarr;
            }
            nums[size] = in;
            size++;
            //forget again
            percolateUp(nums,size - 1);//because size is plus 1 by now!!!!
        }

        private void copyarr(int[] in, int[] out){
            //do
            for(int i = 0; i < in.length; i++){
                out[i] = in[i];
            }
        }
        public int peek(){
            if(size > 0) {
                return nums[0];
            }
            return 0;//some thing
        }

        public int poll(){
            int res = nums[0];
           // swap(nums, size, 0);//useless
            nums[0] = nums[size - 1];
            percolateDown(nums, 0);
            size--;
            return res;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }
    }
}
