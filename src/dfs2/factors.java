package dfs2;

import java.util.ArrayList;
import java.util.List;

public class factors {

    public static void main(String[] args) {
        factors t = new factors();
        System.out.println(t.factors(400));
    }

    public List<List<Integer>> factors(int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target < 4) {
            return res;
        }
        List<Integer> factors = new ArrayList<>();
        List<Integer> factors1 = new ArrayList<>();

        for (int i = 2; i * i <= target; i++) {
            if (target % i == 0) {
                factors.add(i);
                if (i * i < target) {
                    factors.add(target / i);
                }
            }


        }
        System.out.println(factors);
        //System.out.println(factors1);

        List<Integer> prefix = new ArrayList<>();
       dfs(target, factors, 0, prefix, res);
        return res;
    }


    private void dfs(int target, List<Integer> dict, int index, List<Integer> temp, List<List<Integer>> res) {
        if (index == dict.size()) {
            if (target == 1) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        dfs(target, dict, index + 1, temp, res);

        int factor = dict.get(index);
        int count = 0;
        int remain = target;
        while (remain > 0) {
            if (remain % factor != 0) {
                break;
            }
            count++;
            remain /= factor;
            temp.add(factor);
            dfs(remain, dict, index + 1, temp, res);

        }
        for (int i = 0; i < count; i++) {
            temp.remove(temp.size() - 1);
        }

    }


//    private void dfs(int target, List<Integer> dict, int index, List<Integer> temp, List<List<Integer>> res) {
//        if (index == dict.size()) {
//            if (target == 1) {
//                res.add(new ArrayList<>(temp));
//            }
//            return;
//        }
//
//        dfs(target, dict, index + 1, temp, res);
//
//        int factor = dict.get(index);
//        int count = 0;
//        int remain = target;
//        while (remain > 0) {
//            if (remain % factor != 0) {
//                break;
//            }
//            count++;
//            remain /= factor;
//            temp.add(factor);
//            dfs(remain, dict, index + 1, temp, res);
//
//        }
//        for (int i = 0; i < count; i++) {
//            temp.remove(temp.size() - 1);
//        }
//
//    }

}
