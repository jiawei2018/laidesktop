package other_also_importent;

public class divideBST {
    /*
    divide a BSt with a value to 2 bst, that t1 all nodes <= value and t2 > value
     */

    public Pair recur(TreeNode root, int value) {
        if(root == null) {
            return new Pair(null, null);
        }
        if(root.val <= value) {
            Pair rpair = recur(root.right, value);
            root.right = rpair.smaller;
            return new Pair(root, rpair.larger);
        } else {// root.val > value
            Pair lpair = recur(root.left, value);
            root.left = lpair.larger;
            return new Pair(lpair.smaller, root);
        }
    }


//    private TreeNode build(String str) {
//        String[] pre = str.split(",");
//        return preorder(pre, new int[]{0});
//    }
    int idx;
    private TreeNode recur(String[] pre) {
        String cur = pre[idx++];
        if(cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = recur(pre);
        root.right = recur(pre);
        return root;
    }
    public static void main(String[] args) {
        divideBST t = new divideBST();
        int[] bst = {1,2,3,4,5,10,15,20,25};
        TreeNode cur = t.helper(bst, 0, bst.length - 1);
        TreeNode root = cur;
        System.out.println(cur.val);
        cur = cur.right;
        System.out.println(cur.val);
        System.out.println(cur.right.val);
        cur = cur.left;
        System.out.println(cur.val);
        cur.left = new TreeNode(6);
        cur.right = new TreeNode(11);
//        cur = cur.right;
//        cur.right = new TreeNode(9);


        Pair p = t.recur(root, 10);
         t.inorder(p.larger) ;
         System.out.println(" ");
         t.inorder(p.smaller);

    }

    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
         inorder(root.left);
        System.out.print(String.valueOf(root.val + ","));
         inorder(root.right);

    }



    private TreeNode helper(int[] arr, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr, start, mid - 1);
        root.right = helper(arr, mid + 1, end);
        return root;
    }




    private static class Pair {
        TreeNode smaller;
        TreeNode larger;
        public Pair (TreeNode smaller, TreeNode larger) {
            this.larger = larger;
            this.smaller = smaller;
        }
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
