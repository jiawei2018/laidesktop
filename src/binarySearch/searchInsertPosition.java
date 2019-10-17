package binarySearch;

public class searchInsertPosition {
    public int searchInsert(int[] input, int target) {
        // Write your solution here
        if (input == null || input.length < 1){
            return 0;
        }
        int res = bs(input, target);
        return res;
    }
//1 2 3 4 5 6
    private int bs(int[] input, int target){
        int left = 0;
        int right = input.length - 1;
        while(left <  right-1){
            int mid = left + (right - left) / 2;
            if(input[mid] >= target){
                right = mid;
            }else{
                left = mid ;
            }
        }
        if(input[right] < target){
            return right + 1;//this must come before left,because right is always bigger than left!!!i am so stupid
        }else if(input[left] < target){
            return left + 1;
        }else
            return left;
    }

    public static void main(String[] args) {
        int[] r = {0,4,5,8};
        int[] r1 = {2,5,7,11,13};
        searchInsertPosition t = new searchInsertPosition();
        System.out.println(t.searchInsert(r1, 16));

    }
}
