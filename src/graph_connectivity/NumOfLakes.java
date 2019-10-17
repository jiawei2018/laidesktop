package graph_connectivity;

public class NumOfLakes {
    /*
    *   0 0 0 1
    *   1 1 1 1
    *   1 1 0 1
    *   1 1 1 1
    *   1 0 1 1
    *   1 1 1 1
    *   1 0 1 0
    *
    *   0 is lake surrounded by 1 ,out range is sea
    *
    * */
    public int numOfLakes(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dyeSea(grid, visited);
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 0) {
                    res++;
                    recur(grid, visited, i , j);
                }
            }
        }
        return res;
    }

    private void dyeSea(int[][] grid, boolean[][] visited) {
        // dye the lakes that connected to sea
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) { // left and right edge
            if(!visited[i][0] && grid[i][0] == 0) {
                recur(grid, visited, 0, i);
            }
            if(!visited[i][n - 1] && grid[i][n - 1] == 0) {
                recur(grid, visited, n - 1, i);
            }
        }

        for(int i = 0; i < n; i++) { // left and right edge
            if(!visited[0][i] && grid[0][i] == 0) {
                recur(grid, visited, i, 0);
            }
            if(!visited[m - 1][i] && grid[m - 1][i] == 0) {
                recur(grid, visited, i,m - 1);
            }
        }
    }

    final int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    private void recur(int[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for(int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == 0) {
                recur(grid, visited, nx, ny);
            }
        }
    }
}
