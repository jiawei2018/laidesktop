package tree;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

public class inorder_preorder {
    /*
    *        2
    *       /  \
    *      3    4
    *     / \
    *    5   7
    *     \
    *      6
    *
    * */

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public List<Integer> preorder(diagnal_traverse.TreeNode root){
        List<Integer > res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //root-left-right
        Stack<diagnal_traverse.TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            diagnal_traverse.TreeNode cur = stack.pop();
            res.add(cur.val);
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
        return res;
    }


    public List<Integer> inorder(diagnal_traverse.TreeNode root){
        List<Integer > res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //left-root-right
        Stack<diagnal_traverse.TreeNode> stack = new Stack<>();
        firstNode(root, stack);
        while(!stack.isEmpty()){
            diagnal_traverse.TreeNode cur = stack.pop();
            res.add(cur.val);
            firstNode(cur.right, stack);
        }
        return res;
    }

    private void firstNode(diagnal_traverse.TreeNode root, Stack<diagnal_traverse.TreeNode> stack){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    ///*********************************************************

    //2 stack method
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode>  stack1 = new ArrayDeque<>();
        Deque<TreeNode>  stack2 = new ArrayDeque<>();

        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode tmp = stack1.pop();
            stack2.push(tmp);
            if(tmp.left != null){
                stack1.push(tmp.left);
            }
            if(tmp.right != null){
                stack1.push(tmp.right);
            }
        }

        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }



    public List<Integer> postorderTraversal_norm(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while(root != null || ! stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.peek();

            if (tmp.right == null || tmp.right == prev){//leaf have no child,
                res.add(tmp.val);
                stack.pop();
            } else {
                root = tmp.right;
            }

            prev = tmp;
        }

        return res;
    }



}
