package binarySearch;

public class shiftPosition {
    public int shiftPosition(int[] array) {
        // Write your solution here
        if(array == null || array.length < 1){
            return -1;
        }

        if(array[0] < array[array.length - 1 ]|| array.length == 1){
            return 0;
        }
        int left = 0;
        int right = array.length -1;
        while(left <= right){
            int pos = left + (right -left) /2;

            if(array[pos] > array[pos + 1]){
                return pos;
            }else if(array[pos] > array[left]){
                left = pos + 1;
            }else {
                right = pos - 1;
            }
        }
        return -1;
    }
}
