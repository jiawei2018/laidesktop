package binarySearch;

public class searchShiftSortAII {
    public int searchII(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length < 1) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[left] == array[mid]) {
                left++;
            } else if (array[left] < array[mid]) {//must <=
                if (target < array[mid] && target >= array[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {  // mid < target
                if (target > array[mid] && target <= array[right]) {//must <=
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
