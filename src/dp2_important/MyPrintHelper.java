package dp2_important;

import java.util.ArrayList;
import java.util.List;

public class MyPrintHelper {
    public static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("array is empty or null!");
            return;
        }
        int len = array.length;
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < len ; i++) {
            out.add(array[i]);
        }
        System.out.println("Array: " + out);

    }

    public static void printArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            System.out.println("array is empty or null!");
            return;
        }
        int len = array.length;
        int width = array[0].length;
        List<List<Integer>> out = new ArrayList<>();
        System.out.println("2-D Array: " );
        for (int i = 0; i < len ; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j < width; j++){
                temp.add(array[i][j]);
            }
            System.out.println(temp);
        }
        //System.out.println("2-D Array: " + out);
    }


}
