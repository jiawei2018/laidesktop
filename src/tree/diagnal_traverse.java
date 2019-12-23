package tree;

import java.util.LinkedList;
import java.util.Queue;

public class diagnal_traverse {


    public void diagonalPrint(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        Add(root, q);
        while (!q.isEmpty()) {
            TreeNode pop = q.poll();
            System.out.print(pop.val + " ");
            Add(pop.left, q);
        }
    }

    public void Add(TreeNode temp, Queue<TreeNode> q) {
        while (temp != null) {
            q.add(temp);
            temp = temp.right;
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
