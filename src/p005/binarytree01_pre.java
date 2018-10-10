package p005;

import java.util.LinkedList;
import java.util.List;

public class binarytree01_pre {
  class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
  }
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        List<Integer> res = new LinkedList<>();

        res.add(root.key);
        res.addAll(preOrder(root.left));
        res.addAll(preOrder(root.right));
        return res;
    }
}
