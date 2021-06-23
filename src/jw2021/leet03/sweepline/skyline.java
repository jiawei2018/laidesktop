package jw2021.leet03.sweepline;

import java.util.*;

public class skyline {


    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings.length == 0){
            return res;
        }
        List<int[]> points = new ArrayList<>();
        for(int[] p : buildings){
            points.add(new int[]{p[0], -p[2]});//start
            points.add(new int[]{p[1], p[2]});//end
        }

        Collections.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        int premax = 0;//star from ground
        for(int[] p : points){
            if(p[1] < 0){
                //start, into heap
                heap.offer(-p[1]);
            } else {
                //end of queue
                heap.remove(p[1]);
            }

            if(premax != heap.peek()){
                //got a change!
                res.add(List.of(p[0], heap.peek()));
                premax = heap.peek();
            }

        }


        return res;

    }



    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings.length == 0){
            return res;
        }
        List<Point> points = new ArrayList<>();
        for(int[] p : buildings){
            points.add(new Point(p[0], p[2], true));//start
            points.add(new Point(p[1], p[2], false));//end
        }
        //tree map
        //no sort


        Collections.sort(points, this::compare);

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.offer(0);
        int premax = 0;//star from ground
        for(Point p : points){
            if(p.isLeft){
                //start, into heap
                heap.offer(p.height);
            } else {
                //end of queue
                heap.remove(p.height);
            }

            if(premax != heap.peek()){
                //got a change!
                res.add(List.of(p.idx, heap.peek()));
                premax = heap.peek();
            }

        }
        return res;
    }

    private int compare(Point a, Point b){
        if(a.idx == b.idx){
            if(a.isLeft && b.isLeft){

                //same start higher comes first
                return b.height - a.height;
            } else  {
                //both are end,
                return a.isLeft ? -1 : 1;
            }
        }
        return a.idx - b.idx;
    }

    class Point{
        int idx;
        int height;
        boolean isLeft;
        Point(int i, int h, boolean l){
            idx =i;
            height = h;
            isLeft = l;
        }
    }

}
