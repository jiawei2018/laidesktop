package graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class bfs2waterRise {
    public static void main(String[] args) throws Exception {
        int[][] grid = {
                {0, 9, 9, 9, 9},
                {1, 9, 9, 9, 9},
                {2, 9, 2, 3, 2},
                {2, 3, 4, 9, 3},
                {1, 9, 9, 9, 7},
        };
        bfs2waterRise t = new bfs2waterRise();
        System.out.println(t.getMinDays(grid));

    }

    public int getMinDays(int[][] grid) throws Exception {
        // from 0,0 to end,end
        Math.pow(1, 2);
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Node start = new Node(0, 0, grid[0][0]);
        PriorityQueue<Node> heap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        //boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();
        heap.offer(start);
        //visited[start.x][start.y] = true;
        set.add(start.toString());
        while(!heap.isEmpty()) {
            Node cur = heap.poll();
            if(cur.x == m - 1 && cur.y == n - 1) {
                return cur.val;
            }
            for(int[] d: dir) {
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];
                //if(valid(nx, ny, grid) && !visited[nx][ny]) {
                //String nn = nx+","+ny;
                if(valid(nx, ny, grid) && !set.contains(nx+","+ny)) {
                    int nv = Math.max(cur.val, grid[nx][ny]);
                    Node nei = new Node(nx, ny, nv);
                    heap.offer(nei);
                    set.add(nei.toString());
                    //visited[nx][ny] = true;;
                }
            }
        }
        throw new Exception("cant find answer");
        //return -1;
    }

    final int[][] dir = {{0, 1},{0, -1},{1, 0},{-1, 0}};

    private boolean valid(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }


    class Node {
        int x, y;
        int val;
        public Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.val = v;
        }
        @Override
        public String toString(){
            return x+","+y;
        }
    }
}
