package jw2021.leet03;

import java.util.Arrays;

public class ClosestDessertCost {
    public static void main(String[] args) {
        //[3,10]
        //[2,5]
        //9
        ClosestDessertCost tt = new ClosestDessertCost();
        int[] bb = {3,10};
        int[] cc = {2,5};
        int t = 9;

        System.out.println(tt.closestCost(bb, cc, t));
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(baseCosts);
        Arrays.sort(toppingCosts);

        res = baseCosts[0];
        absmin = Math.abs(res - target);//init

        for(int i =0; i < baseCosts.length; i++) {
            recur(toppingCosts, baseCosts[i], target, 0);
        }

        return res;
    }
    int res;
    int absmin;

    private void recur(int[] toppingCosts, int value, int target, int idxt) {
        System.out.println(value + "   <<   ");
        if(idxt >= toppingCosts.length){
            return;
        }
        int offset = Math.abs(value - target);
        if(offset <= absmin) { // base case
            if(offset == absmin) {
                // System.out.println("  # " + value + "   <<   " + res);
                res = Math.min(res, value);
            } else {
                res = value;
                absmin = offset;
            }
            System.out.println("  # " + value + "   <<   " + res);
        }

        // sorted
        if(offset > absmin && value > target){
            return;
        }
        int cur = toppingCosts[idxt];
        //pick 0
        recur(toppingCosts, value, target, idxt + 1);

        //pick 1
        recur(toppingCosts, value + cur, target, idxt + 1);

        //pick 2
        recur(toppingCosts, value + cur * 2, target, idxt + 1);
    }
}
