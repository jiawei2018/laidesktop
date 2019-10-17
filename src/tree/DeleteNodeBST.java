package tree;

public class DeleteNodeBST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode deleteOneNodeInBST(TreeNode root, int v) {


        return root;
    }

    private TreeNode recur(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val > val) {
            root.left = recur(root.left, val);

        } else if(root.val < val)  {
            root.right = recur(root.right, val);
        } else {//root.val == val;
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null || root.right == null) {
                return root.right == null ? root.left : root.right;
            } else {
                TreeNode smallest = find(root.right);
                root.val = smallest.val;
                return recur(root.right, smallest.val);
            }
        }
        return root;
    }

    private TreeNode find(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
