package debug;

import myHelperUtil.MyPrintHelper;

import java.util.*;

public class lc711a {
    int[][] dirs={{-1,0}, {1,0}, {0,-1}, {0,1}};
    int[][] trans={{1,1}, {1,-1}, {-1,1}, {-1,-1}};


    public static void main(String[] args) {
        int[][] arr = {{0,0,1},{0,0,1},{1,1,0}};


        lc711a t = new lc711a();
        t.numDistinctIslands2(arr);
    }

    public int numDistinctIslands2(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int m=grid.length, n=grid[0].length;
        Set<String> islands=new HashSet<>();

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1){
                    List<int[]> cells=new ArrayList<>();
                    dfs(grid, i, j, cells);
                    String key=norm(cells);
                    System.out.println(key);
                    islands.add(key);
                }
            }
        }
        return islands.size();
    }

    private void dfs(int[][] grid, int i, int j, List<int[]> cells){
        cells.add(new int[]{i, j});
        grid[i][j]=-1;

        for (int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1)
                dfs(grid, x, y, cells);
        }
    }

    private String norm(List<int[]>cells){
//        for(int[] i : cells){
//            MyPrintHelper.printArray(i);
//        }

        List<String> forms=new ArrayList<>();
        // generate the 8 different transformations
        // (x, y), (x, -y), (-x, y), (-x, -y)
        // (y, x), (-y, x), (y, -x), (-y, -x)
        for (int[] ts:trans){
            List<int[]> list1=new ArrayList<>();
            List<int[]> list2=new ArrayList<>();
            for (int[] cell:cells){
                //System.out.println(cell[0] + "  " + cell[1]);
                list1.add(new int[]{cell[0]*ts[0], cell[1]*ts[1]});
                list2.add(new int[]{cell[1]*ts[1], cell[0]*ts[0]});
            }
            forms.add(getKey(list1));
            forms.add(getKey(list2));
        }

        // sort the keys: take the first one as the representative key
        Collections.sort(forms);
        System.out.println(forms);
        return forms.get(0);
    }

    private String getKey(List<int[]>cells){
        System.out.println(cells.size() + "  size");
        // sort the cells before generate the key
        Collections.sort(cells, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1]-b[1];
                }
            }
        });
        for(int[] i : cells) {
           MyPrintHelper.printArray(i);
        }
        StringBuilder sb=new StringBuilder();
        int x=cells.get(0)[0], y=cells.get(0)[1];
        for (int[] cell:cells) {
            //System.out.println(cell[0] +"," + cell[1] + "   m" );
            sb.append((cell[0]-x)+":"+(cell[1]-y)+":");
        }


        return sb.toString();
    }
}
