package debug;



public class xycloestBinaryTree {
    public int getCloest(TreeNode root,int x, int y){

        return 0;
    }
    int resInt = Integer.MIN_VALUE;
    private Pair recur(TreeNode root, int x, int y) {
        //if root ==x then test left yand right y; and update globe res
        //if root == y then test left x , and right x;and update globe res
        //if root != x,y then test  left x-> right y and left y -> right x ;and update globe res

        //return min(left x, right x) ,min(left y, right y)
        if (root == null) {
            return new Pair(-1, -1);
        }
        Pair res = new Pair(0, 0);
        Pair left = recur(root.left, x, y);
        Pair right = recur(root.right, x, y);
        if(root.val != x && root.val != y) {
            resInt = Math.min(left.recentX + right.recentY, right.recentX + right.recentY);
        } else {
            if(root.val == x) resInt = Math.min(left.recentX - root.val, right.recentX - root.val);
            if(root.val == y) resInt = Math.min(left.recentY - root.val, right.recentY - root.val);
        }
        res.recentY = Math.min(left.recentY, right.recentY) + 1;
        res.recentX = Math.min(left.recentX, right.recentX) + 1;
        return res;

    }

    class Pair {
        int recentX;
        int recentY;
        public Pair(int x, int y) {
            recentX = x;
            recentY = y;
        }
    }



    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
