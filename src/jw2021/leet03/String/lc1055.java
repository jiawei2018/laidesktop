package jw2021.leet03.String;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class lc1055 {

    public static void main(String[] args) {
        //"aaaaa"
        //"aaaaaaaaaaaaa"
        String s = "aa";
        String t = "aaaaa";
        lc1055 tt = new lc1055();
        System.out.println(tt.shortestWay(s, t));

    }

    public int shortestWay(String source, String target) {
        List<Integer>[] map = new List[26];
        for(int i = 0; i < source.length(); i++){
            if(map[source.charAt(i) - 'a'] == null) {
                map[source.charAt(i) - 'a'] = new ArrayList<>();
            }
            map[source.charAt(i) - 'a'].add(i);
        }
        int idxs = 0;
        int res = 0;
        for(int i = 0; i < target.length();i++){
            List<Integer> list = map[target.charAt(i) - 'a'];
            if(list == null){
                return -1;
            }
            int nj = bs(list, idxs);
            if(nj == -1){
                res++;
                idxs = 0;
                i--;
            } else {
                idxs = nj + 1;
            }
        }

        return idxs == 0 ? res : res + 1;
    }

    private int bs(List<Integer> list, int st){
        //search the smallest > st;
        //2 3 6 9 11
        //  st
        int left = 0;
        int right = list.size() - 1;
        int res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) >= st){
                res = list.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

//public int shortestWay(String source, String target) {
//	char[] cs = source.toCharArray(), ts = target.toCharArray();
//	int res = 1;
//	List<Integer>[] idx = new List[26];
//	for (int i = 0; i < 26; i++) idx[i] = new ArrayList<>();
//	for (int i = 0; i < cs.length; i++) idx[cs[i] - 'a'].add(i);
//	int j = 0;
//	for (int i = 0; i < ts.length; ) {
//		List<Integer> tar = idx[ts[i] - 'a'];
//		if (tar.isEmpty()) return -1;
//		int k = Collections.binarySearch(tar,j);
//		if (k < 0) k = -k - 1;
//		if (k == tar.size()) {
//			res++;
//			j = 0;
//		} else {
//			j = tar.get(k) + 1;
//			i++;
//		}
//
//	}
//	return res;
//}
