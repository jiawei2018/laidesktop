package bit;

import java.util.*;

public class test001 {

    public static void main(String[] args) {
        int a = 0;

        //a = 1 << 5 | a;

        for(int i = 31; i> 0; i--){
            a = 1 << i ;
            //System.out.println(a);
            a = 0;
        }
        //System.out.println(a);
        Set<String> set = new HashSet<>();
        for(int i =1; i < 88; i++){
            set.add("sv"+i);
        }
        List<String> list = new ArrayList<>();
        list.addAll(set);

         for(int i = 0; i < 150; i++){
             List<String> tmp = new ArrayList<>();
             tmp.addAll(set);
             System.out.println(com(tmp, list));
         }
        //test001  t = new test001();
        //System.out.println(t.findIntegers(999999936));
        // 5 = 2 so, 101;
        //5's
        //23-> 10111 4-> 3
        //System.out.println(1 == (23 >> 3 & 1));

        //System.out.println(Integer.toBinaryString((1 << 2) - 1) );
       // System.out.println(Integer.toBinaryString(1 << 2 ));
    }

    private static boolean com(List<String> tmp, List<String> list){
        for(int i =0; i < list.size();i++){
            if(!list.get(i).equals(tmp.get(i))){
                return false;
            }
        }
        return true;
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        // if(graph == null || graph.length == 0|| graph[0].length == 0){
        //     return res;
        // }
        //build a map <start, [ends]>
        map = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            map.put(i, new HashSet<>());
            for(int j: graph[i]){
                map.get(i).add(j);
            }
        }
        recur(res, new ArrayList<>(), 0, graph.length - 1);

        return res;
    }
    Map<Integer, Set<Integer>> map;

    private void recur(List<List<Integer>> res, List<Integer> tmp, int idx, int target){
        if(idx == target){
            res.add(new ArrayList<>(tmp));
            return;//acyclic
        }

        for(int kid : map.get(idx)){
            tmp.add(kid);
            recur(res, tmp, kid, target);
            tmp.remove(tmp.size() - 1);
        }
    }

//    public int findIntegers(int num) {
//        if(num == 0) {
//            return 0;
//        }
//
//        int len = 0;
//        for(int i = 31; i >= 0; i--){
//            if(isOne(num, i)){
//                len = i;
//                break;
//            }
//        }
//        count = 0;
//        recur(num, len, -1, 0);
//        return count;
//    }
//
//    int count;
//
//    private void recur(int num, int idx, int prevIdx, int tmp){
//        if(idx == -1){
//            if(tmp <= num) count++;
//            return;
//        }
//
//        if(prevIdx != -1 && !isOne(tmp, prevIdx)){
//            //a = 1 << i | a;
//            //tmp  = 0 << idx & tmp;
//             //recur(num, idx -1, idx, tmp);
//            int next  = 1 << idx | tmp;
//            recur(num, idx -1, idx, next);
//        }  else {
//            //tmp << idx = 0;
//            recur(num, idx -1, idx, tmp);
//            tmp  = 1 << idx | tmp;
//            recur(num, idx -1, idx, tmp);
//        }
//    }
//
//
//
//    private boolean isOne(int num, int idx){
//       // if(num >> idx & 1){
//        if(1 == (num >> idx & 1)){
//            return true;
//        }
//        return false;
//    }
}
