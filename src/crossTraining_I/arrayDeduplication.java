package crossTraining_I;

/**
 * Description
 * Given a sorted integer array, remove duplicate elements.
 * For each group of elements with the same value
 * keep only one of them. Do this in-place,
 * using the left side of the original array and
 * maintain the relative order of the elements of the array.
 * Return the array after deduplication.
 *
 * Assumptions
 *
 * The array is not null
 * Examples
 *
 * {1, 2, 2, 3, 3, 3} → {1, 2, 3}
 */
public class arrayDeduplication {
    public int[] dedup(int[] array) {
        // Write your solution here
        if(array == null || array.length < 2){
            return array;
        }
        int slowidx = 0;

        for(int i = 1; i < array.length; i++){
            if(array[i] > array[slowidx]){
                slowidx++;
            }
            array[slowidx] = array[i];
        }
        int[] res = new int[slowidx];
        for(int i = 0; i < slowidx; i++ ){
            res[i] = array[i];
        }




        return res;
    }
}
