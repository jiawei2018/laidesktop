package dp3;

public class closestInBST {
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int closest(TreeNode root, int target) {
        // Write your solution here
        if (root.left == null && root.right == null) {
            return root.key;
        }
        int[] res = new int[1];
        res[0] = root.key;//_VALUE
        min(root, target, res);
        return res[0];
    }

    private void min(TreeNode root, int target, int[] res) {
        if (root == null) return;
        if (root.key == target) {
            res[0] = root.key;
            return;
        }
        if (Math.abs(root.key - target) < Math.abs(res[0] - target)) {
            res[0] = root.key;
        }
        if (root.key < target) {
            min(root.right, target, res);
        } else {
            min(root.left, target, res);
        }
    }

}

