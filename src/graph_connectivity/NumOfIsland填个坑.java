package graph_connectivity;

import java.util.HashSet;
import java.util.Set;

public class NumOfIsland填个坑 {
        /*          0 0 0 1
                *   1 1 0 1
                *   1 1 0 1
                *   0 0 0 0
                *   0 0 1 1
                *   1 0 1 1
                *   1 0 0 0
                *
                *   chang only one 0 to 1 and makes the num of islands to minimum
                *   */
    public int getMinIslandsWithOneRemove(int[][] grid){
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dyeWithColor(grid, visited);
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    res = Math.max(res, getNeiColor(grid, i , j));
                }
            }
        }
        return res;
    }

    private int getNeiColor(int[][] grid, int x, int y) {
        // the max will be 4 color;
        //but we dong know how many different island;so we can use a set or ?
        Set<Integer> res = new HashSet<>();
        for(int[] d: dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(!valid(nx, ny, grid)) {
                continue;
            }
            if(grid[nx][ny] != 0) {
                res.add(grid[nx][ny]);
            }
        }
        return res.size();
    }

    private void dyeWithColor(int[][] grid, boolean[][] visited) {
        int color = 1;//better start from 2 or 1 is ok too
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    dye(grid, visited, i, j, color);
                    color++;
                }
            }
        }
    }

    final int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    private void dye(int[][] grid, boolean[][] visited, int x, int y, int color) {
        visited[x][y] = true;
        grid[x][y] = color;
        for(int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(!valid(nx, ny, grid)) {
               continue;
            }
            if(!visited[nx][ny] && grid[nx][ny] == 1) {
                dye(grid, visited, nx, ny, color);
            }
        }
    }

    private boolean valid(int x, int y, int[][] grid){
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
