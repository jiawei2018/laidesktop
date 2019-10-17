package crossTraining_I;

/**
 * Given a sorted integer array,
 * remove duplicate elements.
 * For each group of elements with the same value keep at most two of them.
 * Do this in-place,
 * using the left side of the original array and maintain the relative order of the elements of the array.
 * Return the array after deduplication.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
 *
 * Medium
 */
public class arrayDeduplication_II {
    public int[] dedup(int[] array) {
        // Write your solution here
        if(array == null || array.length < 2){
            return array;
        }
        int slowidx = 0;
        int count = 1;

        for(int i = 1; i < array.length; i++){
            if(array[i] == array[slowidx]){
                count++;
                if(count > 2){
                    continue;
                }
                slowidx++;
            }else {
                slowidx++;
                array[slowidx] = array[i];
                count = 1;
            }
        }
        int[] res = new int[slowidx + 1];

        for(int i = 0; i < slowidx + 1; i++){
            res[i] = array[i];
        }
        return res;
    }
}
