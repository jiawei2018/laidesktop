package class6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Get the list of list of keys in a given binary tree layer by layer.
 * Each layer is represented by a list of keys and the keys are traversed from left to right.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 *  1     4        11
 *
 * the result is [ [5], [3, 8], [1, 4, 11] ]
 *
 * Corner Cases
 *
 * What if the binary tree is null? Return an empty list of list in this case.
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
public class level02 {
    class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
  }
        public List<List<Integer>> layerByLayer(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            List<Integer> tmp = new ArrayList<>();
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);//init
            int size = 0;
            while(!q.isEmpty()){//termination
                size = q.size();
                tmp.clear();
                for(int i = 0; i < size; i++){
                    TreeNode cur = q.poll();//expend
                    tmp.add(cur.key);
                    if(cur.left != null){
                        q.offer(cur.left);//generate
                    }
                    if(cur.right != null){
                        q.offer(cur.right);//generate
                    }
                }
                res.add( new ArrayList<>(tmp));
            }
            return res;

        }
}
