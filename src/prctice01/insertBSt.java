package prctice01;

public class insertBSt {
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode insert(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (root.key > key) {
            return insert(root.left, key);
        } else if (root.key < key) {
            return insert(root.right, key);
        }
        return null;

    }

    private int maxleaftoleaf(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.key;
        }
        int left = maxleaftoleaf(root.left, max);

        int right = maxleaftoleaf(root.right, max);
        if (root.left == null || root.right == null) {
            return root.left == null ? right + root.key : left + root.key;
        }
        max[0] = Math.max(max[0], left + right + root.key);
        return Math.max(left, right) + root.key;
    }

}
