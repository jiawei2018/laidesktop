package jw2021.leet03.sort;

import java.util.*;

public class lc1834 {

    public static void main(String[] args) {
        //[[7,10],[7,12],[7,5],[7,4],[7,2]]
        int[][] aa = {{7,10},{7,12},{7,5},{7,4},{7,2}};

        lc1834 t = new lc1834();

        System.out.println( 1 & 5);
        //
        // t.getOrder(aa);
    }


    public int[] getOrder(int[][] tasks) {
        List<Tuple> jobs = new ArrayList<>();

        for(int i = 0; i < tasks.length; i++){
            int[] tmp = tasks[i];
            jobs.add(new Tuple(tmp[0], tmp[1], i));
        }
        Collections.sort(jobs, (a, b ) -> {
            if(a.st == b. st){
                return a.pt - b.pt;
            }
            return a.st - b.st;
        });
        System.out.println(jobs);

        PriorityQueue<Tuple> heap = new PriorityQueue<>((a, b) -> {
            if(a.pt == b.pt){
                return a.idx - b.idx;
            }
            return a.pt - b.pt;
        });

        //Set<Integer> used = new HashSet<>();// record index
        List<Tuple> used = new ArrayList<>();
        int time = 1; //jobs.get(0).st + jobs.get(0).pt;
        heap.offer(jobs.get(0));
        jobs.remove(0);
        while(!jobs.isEmpty() || !heap.isEmpty()){
            Tuple job = heap.isEmpty() ? jobs.get(0) : heap.poll();
            time += job.pt;
            used.add(job);
            //jobs.remove(job);
            List<Tuple> lv = new ArrayList<>();

            for(Tuple t : jobs){
                if(t.st <= time){
                    lv.add(t);
                    heap.offer(t);
                } else {
                    break;
                }
            }
            jobs.removeAll(lv);
        }


        List<Integer> res = new ArrayList<>();

        for(Tuple t : used){
            res.add(t.idx);
        }

        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    class Tuple{
        int st;
        int pt;
        int idx ;
        Tuple(int s, int p, int i){
            st =s ;pt = p; idx = i;
        }

        @Override
        public String toString() {
            return "["+st+","+pt+","+idx+"]";
        }
    }

}
