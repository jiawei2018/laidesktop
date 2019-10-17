package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class shorestStepsWithMostKbreaks {

    class Node {
        int x, y;
        int k;
        Set<Cood> visited;
        public Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
            visited = new HashSet<>();
        }
        public boolean same(Cood end) {
            return x == end.x && y == end.y;
        }
    }

    class Cood {
        int x, y;
        public Cood(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shorest(int[][] grid, int k, Cood start, Cood end) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start.x, start.y, k));
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(cur.same(end)) {
                    return level;
                }
                for(int[] dir : dirs) {
                    int nx = dir[0] + cur.x;
                    int ny = dir[1] + cur.y;
                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && !cur.visited.contains(new Cood(nx, ny))) {
                        if(grid[nx][ny] == 1 && cur.k > 0) {
                            Node next = new Node(nx, ny, cur.k - 1);
                            next.visited.addAll(cur.visited);
                            next.visited.add(new Cood(nx, ny));
                            queue.offer(next);
                        } else if (cur.k > 0) {
                            Node next = new Node(nx, ny, cur.k);
                            next.visited.addAll(cur.visited);
                            next.visited.add(new Cood(nx, ny));
                            queue.offer(next);
                        }
                    }
                }//4dirs
            }//level
        }
        return 0;
    }
}
