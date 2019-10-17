package xiaobanQUIZ;

import myHelperUtil.MyPrintHelper;

import java.util.*;

public class graphValidTree {

    public static void main(String[] args) {
        int[][] nums =  {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        System.out.println(validTree(4,nums));
        System.out.println(canFinish(5,nums));
    }
    public static boolean validTree(int n, int[][] edges) {
        int[] indegree = new int[n];
        //find every elements indegree number
        for (int i = 0; i < edges.length; i++) {
            indegree[edges[i][1]]++;
        }
        MyPrintHelper.printArray(indegree);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] i : edges) {
            int cur = i[0];
            if (!map.containsKey(cur)) {
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(i[1]);

        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> list = map.get(cur);
            if (list != null) {
                for (int i : list) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        int remain = numCourses;
        int[] ind = new int[remain];

        for(int[] cs : prerequisites){
            ind[cs[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < ind.length; i++){
            if(ind[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int tmp = q.poll();
            remain--;
            for(int[] cs : prerequisites){
                if(cs[1] == tmp){
                    ind[cs[0]]--;
                    if( ind[cs[0]] == 0){
                        q.offer(cs[0]);
                    }
                }
            }
        }

        return remain == 0;


    }








}
