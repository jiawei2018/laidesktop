package myHelperUtil;

public class Swaps {
    public static void swap(int[] nums, int idxa, int idxb){
        int temp = nums[idxa];
        nums[idxa] = nums[idxb];
        nums[idxb]= temp;
    }
    public static void swap(char[] CharArray, int idxa, int idxb){
        char temp = CharArray[idxa];
        CharArray[idxa] = CharArray[idxb];
        CharArray[idxb]= temp;
    }
    public static void swap(long[] longArr, int idxa, int idxb){
        long temp = longArr[idxa];
        longArr[idxa] = longArr[idxb];
        longArr[idxb]= temp;
    }
    public static void swap(double[] doubleArr, int idxa, int idxb){
        double temp = doubleArr[idxa];
        doubleArr[idxa] = doubleArr[idxb];
        doubleArr[idxb]= temp;
    }
}
