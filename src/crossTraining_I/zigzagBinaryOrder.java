package crossTraining_I;

import java.util.*;

/**
 *
 Get Keys In Binary Tree Layer By Layer Zig-Zag Order
 Description
 Get the list of keys in a given binary tree layer by layer in zig-zag order.

 Examples

 5

 /    \

 3        8

 /   \        \

 1     4        11

 the result is [5, 3, 8, 11, 4, 1]

 Corner Cases

 What if the binary tree is null? Return an empty list in this case.
 How is the binary tree represented?

 We use the level order traversal sequence with a special symbol "#" denoting the null node.

 For Example:

 The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

 1

 /   \

 2     3

 /

 4
 */
public class zigzagBinaryOrder {
    class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
  }
        public List<Integer> zigZag(TreeNode root) {
            // Write your solution here
            List<Integer> res = new ArrayList<>();
            LinkedList<Integer> temp = new LinkedList<>();//use this will work
            //if use List<> = Linked List will need convert
            if(root == null){
                return res;
            }
            Deque<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            int size = 0;
            int dir = 1;
            while(!q.isEmpty()){
                size = q.size();
                for(int i = 0; i < size; i++){
                    TreeNode curr = q.poll();
                    if(dir == 1){
                        temp.addFirst(curr.key);
                    }else{
                        temp.add(curr.key);
                    }
                    if(curr.left != null){
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                       q.offer(curr.right);
                    }
                }
                res.addAll(new ArrayList<>(temp));
                temp.clear();
                dir = -dir;
            }
            return res;
        }
}
