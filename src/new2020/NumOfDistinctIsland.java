package new2020;

import java.util.*;

public class NumOfDistinctIsland {
    enum dirs{
        up(new int[]{0, 1}, 'u'),
        down(new int[]{0,-1}, 'd'),
        right(new int[]{1,0}, 'r'),
        left(new int[]{-1,0}, 'l');

        private int[] d;
        private char c;

        private dirs(int[] d, char c){
            this.d = d;
            this.c = c;
        }
    }

    private void f(){
        for(dirs d : dirs.values()){
            System.out.println(d.c);
        }
    }

    public int numDistinctIslands2(int[][] grid) {
        if(grid == null){
            return 0;
        }

        Set<String> res = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i =0; i < m; i++){
            for(int j=0; j < n; j++){
                if(visited[i][j] || grid[i][j] == 0){
                    continue;
                }
                //dfs to get the shape
                List<Pair> island = new ArrayList<>();
                recur(island, grid, i, j, visited);
                Shape cur = new Shape(island);
                res.add(cur.getNorShape());
            }
        }
        return res.size();
    }

    private void recur(List<Pair> island, int[][] grid, int x, int y, boolean[][] visited){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if(grid[x][y] == 0 || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        island.add(new Pair(x, y));
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d : dirs){
            int x2 = x + d[0];
            int y2 = y + d[1];
            recur(island, grid, x2, y2, visited);
        }
    }

    class Pair{
        int x, y;
        Pair(int a, int b){
            x = a;
            y = b;
        }
        @Override
        public String toString(){
            return "#" + x + "&" + y + "#";
        }
    }

    class ShapeString{
        List<Pair> shape;
        Pair base;
        ShapeString(List<Pair> input){
            shape = new ArrayList<>(input);
        }

        public String getString(){
            shape.sort((Pair a, Pair b) -> {
                if(a.x == b.x){
                    return a.y - b.y;
                }
                return a.x - b.x;
            });
            base = shape.get(0);
            return genString();
        }

        private String genString(){
            StringBuilder sb = new StringBuilder();
            shape.forEach(v -> sb.append(getOffset(v)));
            return sb.toString();
        }

        private String getOffset(Pair p){
            return "x" + (p.x - base.x) + "y" + (p.y - base.y) + "/";
        }

    }

    class Shape{
        //this class is used to normalize a island that makes same shape will have same out put;
        List<Pair> shape;
        int[][] covs = {{1,-1},{1, 1},{-1, 1},{-1, -1}};
        String _shape;
        Shape(List<Pair> input){
            //input a shape
            shape = input;
            getHeadShape(getAllShape());
        }


        private String covToString(List<Pair> shape){
            //wrong with this method.....
            // StringBuilder sb = new StringBuilder();
            // shape.forEach(v -> sb.append(v.toString()));
            // return sb.toString();
            ShapeString ss = new ShapeString(shape);
            return ss.getString();
        }

        private List<List<Pair>> getAllShape(){
            List<List<Pair>> res = new ArrayList<>();

            List<Pair> mirror = getMirror(shape);
            for(int[] cov : covs){
                res.add(covShape(shape, cov));
                res.add(covShape(mirror, cov));
            }
            return res;
        }

        private void getHeadShape(List<List<Pair>> input){
            List<String> res = new ArrayList<>();
            input.forEach(v -> res.add(covToString(v)));
            Collections.sort(res);
            _shape = res.get(0);
        }

        private List<Pair> getMirror(List<Pair> input){
            List<Pair> res = new ArrayList<>();
            input.forEach(v -> res.add(new Pair(v.y , v.x)));
            return res;
        }

        private List<Pair> covShape(List<Pair> input, int[] cc){
            if(cc[0] == 1 && cc[1] == 1){
                return new ArrayList<>(input);
            }
            List<Pair> res = new ArrayList<>();
            input.forEach(v -> res.add(new Pair(v.x * cc[0] , v.y * cc[1])));
            return res;
        }

        String getNorShape(){
            //return a string to represent a shape's normalizetion
            return _shape;
        }



    }
}
