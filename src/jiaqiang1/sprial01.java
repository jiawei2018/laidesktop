package jiaqiang1;

import java.util.ArrayList;
import java.util.List;

public class sprial01 {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        int len = matrix.length;
        List<Integer> res = new ArrayList<>();
        if(len < 1){
            return res;
        }
        if(len == 1){
            res.add(matrix[0][0]);
            return res;

        }
        int start = 0;
        int end = len - 1;
        while(start < end){

            for(int i = start; i<  end ; i++){
                res.add(matrix[start][i]);
            }
            for(int i = start  ; i <  end ; i++){
                res.add(matrix[i][end]);
            }
            for(int i = end; i >  start ; i--){
                res.add(matrix[end][i]);
            }
            for(int i = end; i >  start ; i--){
                res.add(matrix[i][start]);
            }
            start++;
            end--;
        }
        if(start == end){//center
            res.add(matrix[start][start]);
        }
        return res;


//        recur(matrix, res, 0, len);
//        return res;
    }


    private void recur(int[][] matrix, List<Integer> res , int level, int size){
        if(size == 0){
            return;
        }
        if(size == 1){
            res.add(matrix[level][level]);
            return;
        }
        for(int i =0; i < size - 1; i++){
            res.add(matrix[0 + level][i + level]);
        }
        for(int i =0; i < size - 1; i++){
            res.add(matrix[i + level][level + size - 1]);
        }
        for(int i = size - 1; i > 0; i--){
            res.add(matrix[level + size - 1][i + level]);
        }
        for(int i = size - 1; i > 0; i--){
            res.add(matrix[i + level][0 + level]);
        }


        recur(matrix, res, level + 1, size - 2);

    }
}
