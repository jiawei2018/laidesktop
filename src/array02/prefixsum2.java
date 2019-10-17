package array02;

import myHelperUtil.MyPrintHelper;

import java.util.HashMap;
import java.util.Map;

public class prefixsum2 {
    public int subarraySum(int[] nums, int k) {
        //o(n^2)?
        int res = 0;
        if (nums == null || nums.length < 1) {
            return res;
        }
        int[] sum = new int[nums.length + 1];
        int[] sums = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            sum[i + 1] = tmp;
            sums[i + 1] = tmp;
        }
        MyPrintHelper.printArray(sum);
        MyPrintHelper.printArray(sums);
        int result = 0;

        for (int i = 0; i < sum.length; i++) {
//            int cur = sum[i] - k;
//            Integer count = map.get(cur);
//            // int val = 1;
//            System.out.println(count);
//            if (count != null) {
//                res += count;
//            }
//            int val = count == null ? 1: count + 1;
//                    map.put(sum[i], val);

              if (map.containsKey(sums[i] - k)) {
                   result += map.get(sums[i] - k);
              }
              int val2 = map.containsKey(sums[i]) ? map.get(sums[i]) + 1 : 1;
              map.put(sums[i], val2);
              System.out.println("   <1  21>" + val2);

        }
        if(result != 0){
            return result;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        prefixsum2 t = new prefixsum2();
        System.out.println(" ==>  " + t.subarraySum(a, 2));
    }
}
