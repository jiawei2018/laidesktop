package Hashmap_String_I;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
 *
 * Assumptions
 *
 * In each of the two sorted arrays, there could be duplicate numbers.
 * Both two arrays are not null.
 * Examples
 *
 * A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 *
 * Easy
 */
public class commonNumbersInTwoSortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if(A.size() == 0 || B.size() == 0){
            return res;
        }
        int i = 0;
        int j = 0;
        while(i < A.size() && j < B.size()){
            if(A.get(i) == B.get(j)){
                res.add(A.get(i));
                i++;
                j++;
            }else if(A.get(i) < B.get(j)){
                i++;
            }else{
                j++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);

        b.add(1);
        b.add(1);
        b.add(1);
        b.add(1);


        commonNumbersInTwoSortedArrays t = new commonNumbersInTwoSortedArrays();
        System.out.println(t.commonB(a, b));


    }


    public List<Integer> commonA(List<Integer> A, List<Integer> B) {
        //binary search
        List<Integer> res = new ArrayList<>();
        if(A.size() == 0 || B.size() == 0){
            return res;
        }
       // List<Integer>  A1 = new ArrayList<>();
       // List<Integer>  B1 = new ArrayList<>();
        if(A.size() > B.size()) {
            List<Integer> tmp = A;
            A = B;
            B = tmp;
        }                            //make sure A is the shorter one
//        }else{
//               A1 = A;
//               B1 = B;
//        }

        boolean[] used = new boolean[B.size()];

        for(int i = 0; i < A.size(); i++){
            Integer tmp = search(B, A.get(i), used);
            if(tmp != null){
                res.add(A.get(i));
            }
        }
        return res;
    }
    private Integer search(List<Integer> A, int target, boolean[] used){
        int left = 0;
        int right = A.size() - 1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if( A.get(mid) == target){
                //used[mid] = true;// must find way to check duplicated ele in A,bs always get the same mid
                break;
            }else if(A.get(mid) < target ){
                left = mid + 1;
            }else
                right = mid - 1;
        }

        //blossom
        int i = mid;
        int j = mid;

            if (A.get(mid) == target) {
                if(!used[mid]) {
                    used[mid] = true;
                    return mid;
                } else {
                    while (A.get(i) == target && A.get(j) == target) {
                        i--;
                        if(i >= 0 && A.get(i) == target && !used[i]){
                            used[i] = true;
                            return i;
                        }
                        j++;
                        if(j < A.size() && A.get(j) == target && !used[j]){
                            used[j] = true;
                            return j;
                        }
                    }
                }
            }

        return null;
    }







    public List<Integer> commonB(List<Integer> A, List<Integer> B) {
        //hashmap
        List<Integer> res = new ArrayList<>();
        if(A.size() == 0 || B.size() == 0){
            return res;
        }
        Map<Integer, Integer> mapa = new HashMap<>();
        Map<Integer, Integer> mapb = new HashMap<>();

        for(int i : A){
            Integer a = mapa.get(i);
            if(a != null){
                mapa.put(i, a + 1);
            }else{
                mapa.put(i, 1);
            }
        }

        for(int i : B){
            Integer b = mapb.get(i);
            if(b != null){
                mapb.put(i, b + 1);
            }else{
                mapb.put(i, 1);
            }
        }

        for(Map.Entry<Integer, Integer> e : mapa.entrySet()){
            Integer valb = mapb.get(e.getKey());
            if(valb != null){
               int vala = e.getValue();
               int cur = Math.min(valb, vala);
               for(int j = 0; j < cur; j++){
                   res.add(e.getKey());
               }
            }
        }
        return res;
    }




}
