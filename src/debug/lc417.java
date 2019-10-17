package debug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc417 {
    public static void main(String[] args) {
        int[][] m = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        lc417 t = new lc417();
        t.pacificAtlantic(m);

    }


    public List<int[]> pacificAtlantic(int[][] matrix) {
        //List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //boolean[][] visited = new boolean[m][n];
        Set<drop> res = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 4 && j == 0) {
                    System.out.println("kjkjk");
                }
                recur(res, new drop(i, j), i, j, matrix[i][j], matrix, new boolean[m][n]);
            }
        }
        List<int[]> ans = new ArrayList<>();
        for(drop d : res) {
            System.out.println(d.x+"   " + d.y);
            ans.add(new int[]{d.x, d.y});
        }
       // System.out.println(ans);
        return ans;
    }

    private final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void recur( Set<drop> res, drop origin, int x, int y, int val, int[][] matrix, boolean[][] visited) {
//         if(origin.x == 4 && origin.y == 0) {
//              System.out.println(origin.pac + "  " + origin.atn);
//         }
        if(res.contains(origin)){
            return;
        }

        if(x < 0 || y < 0) {
            if(x == 4 && y == -1) {
                System.out.println(origin.pac + "  " + origin.atn);
            }
            origin.pac = true;
           // return;
        }
        if(x >= matrix.length || y >= matrix[0].length){
            origin.atn = true;
           // return;
        }

        if(origin.pac && origin.atn) {
            //System.out.println(origin.x + " " + origin.y );
            res.add(origin);
            return;
        }

        if(matrix[x][y] > val || visited[x][y]) {//
            return;
        }

        visited[x][y] = true;
        for(int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(origin.x == 4 && origin.y == 0) {
                if(ny == -1){
                    System.out.println("ccc");
                }
                 System.out.println(nx + "  " + ny);
            }
            recur(res, origin, nx, ny, matrix[x][y], matrix, visited);
        }

        // visited[x][y] = false;
    }

    class drop {
        int x;
        int y;
        boolean pac = false;
        boolean atn = false;
        public drop (int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            String res = "x: " + x + " y: " + y +"  "+ pac +"  " + atn;
            return res;
        }
    }
}
