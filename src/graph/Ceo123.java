package graph;

import com.sun.security.auth.NTDomainPrincipal;

import java.util.*;

public class Ceo123 {

    public int getShorestTime(NTree root){

        int[] max = {0};
        bkt(root, 0, max);

        int res = recur(root);
        return res;
    }
// for the first input is a tree;
    private void bkt(NTree root, int sum, int[] max){// back tracking
        if(root == null){
            return;///?
        }
        int next = sum + root.time;
        max[0] = Math.max(max[0], next);
        for(NTree i : root.kids){
            bkt(i, next, max);
        }
    }
    private int recur(NTree root){// pure recursion
        if(root == null){
            return 0; // ? or else
        }
        int res = 0;
        for(NTree i : root.kids){
            res = Math.max(res, root.time + recur(i));
        }
        return res;
    }
//end of solution for 1


    //1.1 get the next person id
 class myIter implements Iterator<NTree>{

        Queue<NTree> queue;
    public myIter(NTree root){//root is ceo
        queue = new PriorityQueue<>();
        queue.offer(root);
    }

    @Override
    public boolean hasNext() {

        return queue.isEmpty();
    }

    @Override
    public NTree next() {
        if(!hasNext()){
            return null;
        }
        NTree res = queue.poll();
        for(NTree i : res.kids){
            i.time += res.time;
            queue.offer(i);
        }
        return res;
    }
}



//follow up Q2
    //有圈没有环,既 某些node会有大于一个的 indegree
    public int getShorest2(NTree root){
        Queue<NTree> q = new PriorityQueue<NTree>((n1, n2) ->{
            return n1.time - n2.time;
        });
        Set<String> visited = new HashSet<>();
        q.offer(root);
        //fins shortest path for all node and find the longest of all ;
        int res = 0;

        while(!q.isEmpty()){
            while(!q.isEmpty() && visited.contains(q.peek())){
                q.poll();
            }
            NTree cur = q.poll();
            visited.add(cur.id);
            res = Math.max(res, cur.time);
            for(NTree i : cur.kids){
                if(!visited.contains(i.id)){
                    i.time = cur.time + i.time;
                    q.offer(i);
                }
            }
        }
        return res;
    }

    class myIter2 implements Iterator<NTree>{

        Queue<NTree> queue;
        Set<String> set;
        public myIter2(NTree root){//root is ceo
            queue = new PriorityQueue<>();
            queue.offer(root);
            set = new HashSet<>();
            set.add(root.id);
        }

        @Override
        public boolean hasNext() {
            while(!queue.isEmpty() && set.contains(queue.peek())){
                queue.poll();
            }
            return queue.isEmpty();
        }

        @Override
        public NTree next() {
            if(!hasNext()){
                return null;
            }
            NTree res = queue.poll();
            set.add(res.id);
            for(NTree i : res.kids){
                i.time += res.time;
                queue.offer(i);
            }
            return res;
        }
    }






















    class NTree{
        String id;
        int time;
        List<NTree> kids;
        public NTree(String i, int t){
            this.id = i;
            time = t;
            kids = new ArrayList<>();
        }

        public String toStiring(){
            return id+",";
        }

    }
}
