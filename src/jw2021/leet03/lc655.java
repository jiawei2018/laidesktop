package jw2021.leet03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc655 {
    public static void main(String[] args) {
        lc655 t = new lc655();
        t.printTree(null);
    }
    public List<List<String>> printTree(TreeNode root) {

        //int rows = getH(root);
        int rows = 2;
        int colums = (int)(Math.pow(2, rows) - 1);
        List<List<String>> res = new ArrayList<>();//height is 1 based
        System.out.println(res.size());
        for(int i = 0; i < rows; i++){
            List<String> cur = new ArrayList<>(4);
            System.out.println(cur.size());
            Collections.fill(cur, "z");
            res.add(cur);
            //res.set(i, new ArrayList<>(colums));

            System.out.println(res.get(i));
        }
        // int mid = rows / 2;

        recur(res, root, 0, res.get(0).size() - 1, 0);

        return res;
    }
    /*
    r = 3; co = 2^3-1 = 7;


    */

    private void recur(List<List<String>> res, TreeNode root, int left, int right, int level){
        if(root == null){
            return;
        }
        //current position
        int mid = left + (right - left) / 2;
        res.get(level).set(mid, "" + root.val);

        recur(res, root.left, left, mid - 1, level + 1);
        recur(res, root.right, mid+ 1, right, level + 1);

    }


    private int getH(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getH(root.left);
        int right = getH(root.right);
        return Math.max(left, right) + 1;
    }

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
