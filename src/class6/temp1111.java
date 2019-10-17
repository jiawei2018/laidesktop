package class6;

public class temp1111 {


    public int findMin1(int[] array) {
        if ( array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length -1;
        while (left < right -1) {
            int mid = left + (right -left)/2;
            if (array[mid] == array[right]){
                right --;
            }
            else if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return array[left] <= array[right] ? array[left]:array[right];
    }


    //WRONG
    public int findMin(int[] array) {
        if ( array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length -1;
        while (left < right -1) {
            int mid = left + (right -left)/2;
            if (array[mid] == array[left]){
                left ++;
            }
            else if (array[mid] < array[left]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return array[left] <= array[right] ? array[left]:array[right];
    }



}
