package dfs2;

import java.util.*;

public class mazeIII {

    public static void main(String[] args) {
        byte a = 2;
        byte b = 3;
        //byte c = a + b; wrong
        int y = 1;
        //char t = 1  + y; wrong
        int i = 1;

                String hhh = "";
        switch ( args[0] ) {
            case "www":
                System.out.println(1);
            case "ddd":
                System.out.println(2);
           default:
                    System.out.println("eeee");
        }

    }


    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        //sanity chk
        //Queue<Cood> q = new LinkedList<>();
        Queue<Cood> q = new PriorityQueue<>((a, b) -> {
            if(a.dis == b.dis){
                return a.path.compareTo(b.path);
            }
            return a.dis - b.dis;
        });
        q.offer(new Cood(ball[0], ball[1], 0));
        //int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Set<String> visited = new HashSet<>();
        //Map<String, PriorityQueue<Cood>(a,b -> a.dis-b.dis)> visited = new
        //Map<String, List<StringBuilder>> visited = new HashMap<>();

        visited.add(q.peek().xy());//somthing different stor 1, path length 2, all path can reach here?

        List<String> res = new ArrayList<>();
        boolean found = false;
        while(!q.isEmpty()){
            // System.out.println(q);
            Cood cur = q.poll();

            if(cur.x == hole[0] && cur.y == hole[1]){
                //found = true;
                return cur.path.toString();
            }
            if(visited.contains(cur.xy())){
                continue;
            }
            for(dirs d : dirs.values()){
                int x = cur.x;
                int y = cur.y;
                int curdis = cur.dis;
                StringBuilder curpath = cur.path;

                int[] curd =  d.d;
                char curc = d.c;
                while(canMove(x, y, maze, curd)){
                    //System.out.println(x + "  / " + y);
                    x += curd[0];
                    y += curd[1];
                    //curdis++;
                    curpath.append(curc);
                    curdis++;
                    if(x == hole[0] &&  y == hole[1]){
                        //found = true;
                        // res.add(new ArrayList<>(curpath));
                        //now we can goto the hole
                        break;
                    }
                    //curdis++;
                }
                if(visited.contains(x +","+y)){
                    //means it goes into a hole!
                    //should we put into the heap?
                    // continue?
                }
                Cood newCood = new Cood(x, y, curdis);
                newCood.path.append(curpath);
                if(!visited.contains(newCood.xy())){
                    //for this situation, we need to store all the path-length equal to min for each cood?
                    q.offer(newCood);
                }
            }

        }

        //Collections.sort(res, (a,b) -> a.dis - b.dis);
        // if(!found) {
        return "impossible";
    }

    boolean canMove(int x, int y, int[][] maze, int[] dir){
        int a = dir[0];
        int b = dir[1];

        if(x + a >= 0 && y +b >= 0 && x + a < maze.length && y + b < maze[0].length) {
            if(maze[x+a][y+b] == 0){
                return true;
            }
        }
        return false;
    }

    class Cood{
        int x, y;
        int dis;
        StringBuilder path;
        Cood(int a, int b, int c){
            x = a;
            y = b;
            dis = c;
            path = new StringBuilder();
        }

        public String toString(){
            return x+","+y + ">"+dis + "#" + path.toString();
        }

        public String xy(){
            return x +","+y;
        }

    }

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
}
