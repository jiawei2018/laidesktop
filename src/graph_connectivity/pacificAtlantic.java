package graph_connectivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pacificAtlantic {
    //[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]

    public static void main(String[] args) {
        int[][] arr = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        pacificAtlantic t = new pacificAtlantic();
        System.out.println(t.pacificAtlantic(arr));

    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        //List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //boolean[][] pacific = new boolean[m][n];
        //boolean[][] atlantic = new boolean[m][n];
        int[][] res = new int[m][n];
        recur(matrix, new boolean[m][n], 0, 0, res);//pacific
        recur(matrix, new boolean[m][n], m - 1, n - 1, res);//atlantic

        List<List<Integer>> out = new ArrayList<>();
        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.println(i + " " + j +"    rrr  " +res[i][j]);
                if(res[i][j] == 2) {
                    System.out.println(i + " " + j);
                    List<Integer> cur = Arrays.asList(i ,j);
                    out.add(cur);
                }
            }
        }
        return out;
    }

    final int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    private void dye(int[][] grid, boolean[][] visited, int row, int col, int[][] res) {
        for(int i = 0; i < grid[0].length; i++) {
            recur(grid, visited, row, i, res);
        }
        for(int i = 0; i < grid.length; i++) {
            recur(grid, visited, i, col, res);
        }
    }

    private void recur(int[][] grid, boolean[][] visited, int x, int y, int[][] res) {
        visited[x][y] = true;
        res[x][y]++;
        for(int[] d: dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(!valid(grid, nx, ny)) {
                continue;
            }
            if(!visited[nx][ny] && grid[x][y] <= grid[nx][ny]) {
                recur(grid, visited, nx, ny, res);
            }
        }
    }

    private boolean valid(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

}
