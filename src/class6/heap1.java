package class6;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description
 * Find the K smallest numbers in an unsorted integer array A.
 * The returned numbers should be in ascending order.
 *
 * Assumptions
 *
 * A is not null
 * K is >= 0 and smaller than or equal to size of A
 * Return
 *
 * an array with size K containing the K smallest numbers in ascending order
 * Examples
 *
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 */
public class heap1 {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if(k == 0){
            return new int[0];
        }
        PriorityQueue<Integer> tmp = new PriorityQueue<>(new IntegerCom());//(n
        int[] res = new int[k];
        int i = 0;
        for(i = 0; i < k ; i++){
            tmp.add(array[i]);
        }

         for( i = i ; i < array.length; i++){//mistake the i didnt chang to i++, so there the i is the old i cant be i+1
             System.out.println(tmp.peek());
             if(tmp.peek() > array[i]){
                 tmp.poll();
                 tmp.add(array[i]);
             }
         }

         for(int j = k -1 ; j >= 0; j--){
             res[j] = tmp.poll();
         }

         return res;
    }

    class IntegerCom implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 < o2){
                return 1;
            }else if( o1 > o2){
                return -1;
            }else
                return 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,1,5,2,4};
        heap1 t = new  heap1();
        t.kSmallest(a,3);

    }

}
