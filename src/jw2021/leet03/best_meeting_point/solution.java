package jw2021.leet03.best_meeting_point;

import java.util.ArrayList;
import java.util.List;

public class solution{


    public static void main(String[] args) {
        int[][] arr = {{1,0,1,0,1},{0,0,1,0,1},{1,0,1,0,0}};
        //[0, 0, 0, 1, 1, 2, 2]
        //[0, 0, 2, 2, 2, 4, 4] why it is sorted?

        solution t = new solution();
        t.minTotalDistance(arr);
    }

    public int minTotalDistance(int[][] grid) {

        if(grid == null || grid[0].length < 1){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        //{{1,0,1,0,1},
        // {0,0,1,0,1}
        //,{1,0,1,0,0}};

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                // up to down, left to right
                if(grid[i][j] == 1){
                    X.add(i);
                }
            }
        }

        System.out.println(X);
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                //left to right, up to down
                if(grid[j][i] == 1){
                    Y.add(i);
                }
            }
        }
        System.out.println(Y);
        return mins(X) + mins(Y);

    }

    private int mins(List<Integer> list){
        int left = 0;
        int right = list.size() - 1;
        int cursum = 0;
        while(left < right){
            cursum += list.get(right) - list.get(left);
            left++;
            right--;
        }
        return cursum;
    }

    private void test(){
        vme f = vme.ASD;
        System.out.println(f.name);
        System.out.println(f.value);
    }

    enum vme{
        BSD(1, "ha") , ASD(1, "ha"), CSD(1, "ha");

        int value;
        String name;
        vme(int i, String s){
            value = i;
            name = s;
        }
    }
}
