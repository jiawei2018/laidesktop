package crossTraining_I;

import java.util.Arrays;

/**
 * Given a sorted integer array,
 * remove duplicate elements.
 * For each group of elements with the same value do not keep any of them. Do this in-place,
 * using the left side of the original array and and maintain the relative order of the elements of the array.
 * Return the array after deduplication.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {1, 2, 2, 3, 3, 3} → {1}
 */
public class arrayDeduplication_III {
    public int[] dedup(int[] array) {
        // Write your solution here
        if(array == null || array.length < 2){
            return array;
        }
        int slowidx = 0;
        //int count = 1;
        int end = 0;
        boolean isD = false;
        for(int i = 1; i < array.length; i++){
            if(array[i] == array[end]){
                isD = true;
            }else if(isD){
                array[end] = array[i];
                isD = false;
            }else{
                array[++end] = array[i];
            }
            System.out.println(end);
        }
        System.out.println(end + "  <<<");
        //isD means last one is dup ,like 1 2 3 4 4 ;;
        //notice that length = manx index +1
        return Arrays.copyOf(array, isD ? end : end + 1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,4};
        int[] b = {1,2,3,4};
        arrayDeduplication_III t = new arrayDeduplication_III();
        t.dedup(a);
        t.dedup(b);

    }

}
