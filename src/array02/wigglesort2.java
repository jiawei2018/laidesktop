package array02;

import java.math.BigInteger;
import java.util.Arrays;

public class wigglesort2 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        int rightBound = len - 1;
        int[] A = new int[len];
        int mid = (len - 1) / 2;
        int index = 0;
        // s1 s2 s2 M l1 l2 l3
        for (int i = 0;  i <= mid; i++){
            A[index] = nums[mid - i];
            if (index  < rightBound)  {
                //nums[i] = A[len - 1 + (j--)];
                A[index + 1] = nums[rightBound - i];
            }
            index += 2;
        }
//        BigInteger aa ;
//        aa = BigInteger.valueOf(999);
        nums = Arrays.copyOf(A, A.length);
    }

    //    public void wiggleSort(int[] nums) {
    //        int[] A = Arrays.copyOf( nums, nums.length );
    //        Arrays.sort( A );
    //        for(int i=0,j=0,n=nums.length,k=(n-1)/2,x=0;
    // i<n; x=(i<n)?(nums[i++]=A[n-1+(j--)]):0) nums[i++]=A[k+j];
    //    }

    //So what the heck is that doing?
    //After sorting, we're interspersing the low half and high half of the numbers.
    //i: destination index
    //j: source offset
    //n: array length
    //k: middle of array
    //x: nothing important. I just need a statement rather than just a ?: expression as my for iterator
}
