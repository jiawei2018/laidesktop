package debug;

import java.util.*;

public class slyline {
    public static void main(String[] args) {
        int[][] test = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

        slyline t = new slyline();
        t.getSkyline(test);
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings.length == 0){
            return res;
        }
        List<Point> points = new ArrayList<>();
        //swipe line
        for(int i = 0; i < buildings.length; i++){
            int[] b = buildings[i];
            int st = b[0];
            int ed = b[1];
            int h = b[2];
            points.add(new Point(h, st, true));
            points.add(new Point(h, ed, false));
        }

        Collections.sort(points, (a, b) -> {
            if(a.idx == b.idx){
                if(a.isStart &&b.isStart){
                    return b.height - a.height;
                } else if(!a.isStart && !b.isStart) {
                    return a.height - b.height;
                } else {
                    return a.isStart ? -1 : 1;
                }

            }
            return a.idx - b.idx;
        });
        //System.out.println(points);
        // PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> {
        //     return b - a;
        // });
        TreeMap<Integer, Integer> treemap = new TreeMap<>((a, b) -> b - a); // <height, freq>
        treemap.put(0, 1);
        //maxheap.offer(0);
        int prevHeight = 0;

        for(Point p : points){
            // System.out.println(maxheap);
            if(p.isStart){
                treemap.put(p.height, treemap.getOrDefault(p.height, 0) + 1);
                //maxheap.offer(p.height);
            } else {
                //remove from
                //System.out.println(p);
                // System.out.println(maxheap);
                int del = treemap.get(p.height);
                //if(del != null ){
                if(del == 1) {
                    treemap.remove(del);
                } else {
                    treemap.put(p.height, del - 1);
                }
                //}
                //maxheap.remove(p.height);
                //System.out.println(maxheap);
            }
            System.out.println(treemap + " " + p);
            int cur = treemap.firstKey();
            //int cur = maxheap.peek();
            // System.out.println(cur);
            if(cur != prevHeight){
                res.add(Arrays.asList(p.idx, cur));
                prevHeight = cur;
            }
        }

        return res;
    }



    class Point{
        boolean isStart;
        int idx;
        int height;
        public Point(int h, int i, boolean b){
            isStart = b;
            height = h;
            idx = i;
        }

        public String toString(){
            return idx +","+height+","+isStart;
        }
    }
}
