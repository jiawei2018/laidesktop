package other_also_importent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class postorderTraversal {
    class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int key;
        public  TreeNode(int key){
            this.key = key;
        }

    }
    private List<Integer> postorder(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }
        TreeNode prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root != null ||!stack.isEmpty() ){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode  temp = stack.peek();
            if(temp.right == null || temp.right == prev){
                res.add(stack.pop().key);
            }else{
                root = temp.right;
            }
            prev = temp;
        }
        return res;
    }
}
