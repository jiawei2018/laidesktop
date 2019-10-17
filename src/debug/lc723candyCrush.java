package debug;

import myHelperUtil.MyPrintHelper;

public class lc723candyCrush {

    public static void main(String[] args) {
        int[][]  arr = {{1,3,5,5,2},{3,4,3,3,1},{3,2,4,5,2},{2,4,4,5,5},{1,4,4,1,1}};
        int[][] arr2 = {{1,3,2,4,3},{2,3,2,3,2},{4,4,2,5,4},{1,2,4,2,4},{3,3,5,5,1}};
        lc723candyCrush t = new lc723candyCrush();
        t.candyCrush(arr2);
        MyPrintHelper.printArray(arr2);


    }




    public int[][] candyCrush(int[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return board;
        }
        int m = board.length;
        int n = board[0].length;
        boolean loop = true;
        while(loop){
            System.out.println("new round ");
            MyPrintHelper.printArray(board);

            System.out.println("new round ");

            boolean[][] mark = new boolean[m][n];
            loop = markD(board, mark);
            crushAll(board, mark);
            //mark = new boolean[m][n];//how to restore this  use much better way?
        }
        return board;
    }

    private boolean markD(int[][] board, boolean[][] mark){
        //mark all  bricks that can be removed
        boolean res = false;
        for(int i = 0; i < board.length; i++){//scan each row
            if(i == 3 ){
                System.out.println("    ");
            }
            boolean row = markRow(board, mark, i);
            System.out.println(row);
            res |= row;

        }
        //System.out.println(res);
        for(int i = 0; i < board[0].length; i++){//scan each col
            boolean col = markCol(board, mark, i);
            System.out.println(col);
            res |= col;
        }
        //System.out.println(res);
        return res;
    }

    private boolean markRow(int[][] board, boolean[][] mark, int r){
        boolean res = false;
        int left = 0;
        for(int i = 0; i < board[0].length; i++){
            if(board[r][i] == 0) {
                left = i;
                continue;
            }
            while(left <= i && board[r][left] != board[r][i]){
                left++;
            }
            if(i - left + 1 >= 3){
                res = true;
                for(int j = left; j <= i; j++) mark[r][j] = true;
            }
        }
        return res;
    }

    private boolean markCol(int[][] board, boolean[][] mark, int c){
        boolean res = false;
        int left = 0;
        for(int i = 0; i < board.length; i++){
            //System.out.println(board[0].length + "   "+  c);
            if(board[i][c] == 0){
                left = i;
                continue;
            }
            while(left <= i && board[left][c] != board[i][c]){
                left++;
            }
            if(i - left + 1 >= 3){
                res = true;
                for(int j = left; j <= i; j++) mark[j][c] = true;
            }
        }
        return res;
    }

    private void crushAll(int[][] board, boolean[][] mark){
        // fall down all crush and drop
        for(int i = 0; i < board[0].length; i++){
            crush(board, mark, i);
        }
    }

    private void crush(int[][] board, boolean[][] mark, int c){
        //crush one col
        for(int i = board.length - 1; i >= 0; i--){
            if(mark[i][c] == true){
                board[i][c] = 0;
            }
        }
        int top = board.length - 1;
        int bot = board.length - 1;
        while(top >= 0){
            if(board[top][c] == 0){
                top--;
            } else {
                board[bot--][c] = board[top--][c];
            }
        }
        while(bot >= 0){
            board[bot--][c] = 0;
        }
    }
}
