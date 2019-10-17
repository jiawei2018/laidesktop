package debug;

import java.util.*;

public class lc711me {


    public static void main(String[] args) {
        int[][] arr = {{0,0,1},{0,0,1},{1,1,0}};


        lc711me t = new lc711me();
        t.numDistinctIslands2(arr);
    }




    public int numDistinctIslands2(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<String> res = new HashSet<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    List<cood> cur = new ArrayList<>();
                    recur(grid, i, j, cur);
                    String curstr = format(cur);
                    System.out.println(curstr);
                    res.add(curstr);
                }
            }
        }
        return res.size();
    }
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    private void recur(int[][] grid, int x, int y, List<cood> tmp) {

        tmp.add(new cood(x, y));
        grid[x][y] = 0;//visited
        for(int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                recur(grid, nx, ny, tmp);
            }
        }
    }
    private final int[][] trans = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private String format(List<cood> list) {

        List<String> all = new ArrayList<>();
        // (x, y), (x, -y), (-x, y), (-x, -y)--xform
        // (y, x), (-y, x), (y, -x), (-y, -x)-- yform
        for(int[] form : trans) {
            List<cood> xform = new ArrayList<>();
            List<cood> yform = new ArrayList<>();
            for(cood cd : list) {
                //System.out.println(cd);
                xform.add(new cood(cd.x * form[0], cd.y * form[1]));
                yform.add(new cood(cd.y * form[1], cd.x * form[0]));//this is bug, (y, x)
            }
            all.add(getstr(xform));
            all.add(getstr(yform));
        }
        Collections.sort(all);
        System.out.println(all);
        return all.get(0);
    }

    private String getstr(List<cood> list){
        System.out.println(list + "    " + list.size());
        Collections.sort(list, new Comparator<cood>() {
            @Override
            public int compare(cood c1, cood c2){
                if(c1.x != c2.x) {
                    return c1.x - c2.x;
                } else {
                    return c1.y - c2.y;
                }
            }
        });
        //System.out.println(list + "   <<sorted");
        StringBuilder res = new StringBuilder();
        int startx = list.get(0).x;
        int starty = list.get(0).y;
        for(cood cd : list){
            //System.out.println(cd + "   1");
            res.append(cd.diffstr(startx, starty));
        }
        //System.out.println(res);
        return res.toString();
    }

    class cood {
        int x;
        int y;
        public cood(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            String res = "[" +  x + "," + y + "]";
            return res;
        }
        public String diffstr(int sx, int sy){
            int nx = x - sx;
            int ny = y - sy;
            String res = nx + "." + ny + ".";
            return res;
        }
    }
}
