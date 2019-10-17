package debug;

import java.util.HashMap;
import java.util.Map;

public class lc437pathsum3 {
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);

    }

        /*
    0 1 2 3 4 5
    1 2 1 2 1 3

  0 1 2 3 4 5 6
  0 1 3 4 6 7 10
  i     j
   so  idx 3 - idx 0  =  sum 0 to 3
   as for prefix sum, we add 0 before this array,
    */
        public int pathSum(TreeNode root, int sum) {
            if(root ==  null){
                return 0;
            }
            //<prefixSum, freq> pair
            count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);// may not need this NO we definitely need this since
            //recursion start sum from 0....
            recur(root, 0, sum, map);
            return count;
        }
        int count;
        private void recur(TreeNode root, int sum, int target, Map<Integer, Integer> map){
            if(root == null){
                return;
            }
        /*
        0 1 -1 -4

        -1
        */
            //sum.a -sum.b - target => sum.a - target = sum.b
            int cursum = sum + root.val;
            System.out.println(sum +"  >>"+ root.val  +"  >>"+ cursum);
            //map.put(cursum, map.getOrDefault(cursum, 0) + 1);
            //WRONG HERE! we can not update map first met the num
            // when sum == 0 we cant find any SUM = 0
            int search = cursum - target;
            // count += map.getOrDefault(search, 0);
            Integer num = map.get(search);
            if(num != null) {
                //System.out.println(num + " <> " + search+"  >>"+ root.val +"  >>"+ cursum);
                count += num;
            }
            map.put(cursum, map.getOrDefault(cursum, 0) + 1);
            recur(root.left, cursum, target, map);
            recur(root.right, cursum, target, map);
        }
}
