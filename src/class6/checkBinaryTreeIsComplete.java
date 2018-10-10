package class6;

import java.util.LinkedList;

/**
 * Check if a given binary tree is completed.
 * A complete binary tree is one in which every level of the binary tree
 * is completely filled except possibly the last level.
 * Furthermore, all nodes are as far left as possible.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \
 *
 * 1      4
 *
 * is completed.
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * is not completed.
 *
 * Corner Cases
 *
 * What if the binary tree is null? Return true in this case.
 * How is the binary tree represented?
 *
 * We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
 *
 *     1
 *
 *   /   \
 *
 *  2     3
 *
 *       /
 *
 *     4
 */
public class checkBinaryTreeIsComplete {
    class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
  }
        public boolean isCompleted(TreeNode root) {
            // Write your solution here
            if(root == null){
                return true;
            }
            boolean mark = false;//default is false
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);//init
            int size;
            while(!q.isEmpty()){
                size = q.size();
                for(int i = 0; i < size; i++){
                    TreeNode cur = q.poll();//expand
                    if(cur  == null){
                        mark = true;
                    }else if(cur != null && mark){
                        return false;//termination
                    }else{//generation
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                }
            }
            return true;
        }
}
