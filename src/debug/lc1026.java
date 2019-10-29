package debug;

import java.util.*;

public class lc1026 {



    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();

        int[] two = new int[n];//3 = {1, 2, 4}
        two[0] = 1;
        for(int i = 1; i < two.length; i++){
            two[i] = two[i - 1] * 2;
        }
        //System.out.println(Arrays.toString(two));
        List<Integer> eds = new ArrayList<>();
        for(int i : two){
            eds.add(start ^ i);
        }
        //System.out.println(eds);
        res.add(start);
        for(int t : eds){
            //System.out.println(start + "  " + t);
            if( recur(res, start, t, two, new boolean[(int)(Math.pow(2, n))]) ) break;
        }


        return res;
    }

    private boolean recur(List<Integer> res, int st, int ed, int[] two, boolean[] visited){
        //System.out.println(res);
        if(visited[st]){
            return false;
        }
        visited[st] = true;
        if(st == ed && res.size() == visited.length){
            //res.add(ed);
            return true;
        }

        for(int t : two){
            int next = st ^ t;
            //System.out.println(res + "   ,, "+ next);
            res.add(next);
            if(recur(res, next, ed, two, visited)) return true;
            res.remove(res.size() - 1);
        }
        visited[st] = false;
        return false;
    }



    public static void main(String[] args) {
        //List<String> arr = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p");
        lc1026 t = new lc1026();
        //System.out.println(t.circularPermutation(2, 3));
        //t.maxLength(arr);
        test(0);
    }

    private static void test(int j){
        for(int i = j; i < 100; i++){
            int cur = i ^ (i>>1);
            ////System.out.println(cur + "  "+ i );
            System.out.println(Integer.toBinaryString(cur));
            //System.out.println(Integer.toBinaryString(i));
            //System.out.println("   ");
        }
    }


    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0){
            return 0;
        }
        for(String str : arr){
            if(!isu(str)) arr.remove(str);
        }

        recur(new HashSet<>(), arr, 0, new boolean[arr.size()]);

        return max;
    }

    int max = 0;

    private void recur(Set<Character> set, List<String> arr, int idx, boolean[] used){
        System.out.println(idx);
        max = Math.max(set.size(), max);
        String cur = arr.get(idx);
        for(int i = 0; i < cur.length(); i++){
            if(set.contains(cur.charAt(i))) return;
        }
        used[idx] = true;
        for(char c : cur.toCharArray()){
            set.add(c);
        }

        for(int j = 0; j < arr.size(); j++){
            if(!used[j])recur(set, arr, j, used);
        }
        for(char c : cur.toCharArray()){
            set.remove(c);
        }
        used[idx] = false;

    }

    private boolean isu(String str){
        int[] map = new int[26];
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if(map[idx] > 0){
                return false;
            }
            map[idx]++;
        }
        return true;
    }
}
