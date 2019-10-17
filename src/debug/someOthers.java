package debug;

public class someOthers {
    public static void main(String[] args) {
        someOthers t = new someOthers();
        int[] ar = {0,0,1,0,0,0,1,1};
        System.out.println(t.minNumToAll1Subarray(ar));
    }

    public int minNumToAll1Subarray(int[] arr){
        //arr only contains 1 and 0
        //return minimum number that require to flip 0 -> 1 make all 1 continous
        int ones = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                ones++;
            }
        }

        int zero = 0;
        for(int i =0; i < ones; i++){
            if(arr[i] == 0){
                zero++;
            }
        }
        int res = zero;
        int left = 0;
        for(int i = ones; i < arr.length; i++){
            //1 0 1 0 1 1 1
            //0 1 2 3 4 5 6
            if(arr[i] == 0){
                zero++;
            }
            if(i - left >= ones){
                if(arr[left] == 0){
                    zero--;
                }
                left++;
                res = Math.min(res, zero);
            }
        }
        return res;
    }
}
