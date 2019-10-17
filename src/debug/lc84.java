package debug;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc84 {
    public static void main(String[] args) {
        lc84 t = new lc84();
        int[] arr = {4,2,0,3,2,4,3,4};
        t.largestRectangleArea(arr);
    }



    public int largestRectangleArea2(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int curidx = stack.pop();
                int curleft = stack.isEmpty() ? 0 : stack.peek() + 1;
                res = Math.max(res, heights[curidx] * (i - curleft));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int curidx = stack.pop();
            int curleft = stack.isEmpty() ? 0 : stack.peek() + 1;
            res = Math.max(res, heights[curidx] * (len -  curleft));
        }

        return res;
    }


    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        Deque<Pair> stack = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i < len; i++){
            int left = -1;
            if(stack.isEmpty() || heights[i] > stack.peek().h){
                left = i;
            } else if(!stack.isEmpty() && heights[i] == stack.peek().h) { //height.i = h
                left = stack.peek().left;
            } else {
                while(!stack.isEmpty() && stack.peek().h > heights[i]){
                    Pair cur = stack.pop();
                    cur.right = i;
                    left = cur.left;
                    res = Math.max(res, cur.getArea());
                }
            }
            stack.push(new Pair(left, -1, heights[i]));
        }
        while(!stack.isEmpty()){
            Pair cur = stack.pop();
            cur.right = len;
            res = Math.max(res, cur.getArea());
        }

        return res;
    }

    class Pair{
        int left;
        int right;
        int h;
        public Pair(int l, int r, int h){
            left = l;
            right= r;
            this.h = h;
        }
        @Override
        public String toString(){
            return left+" <   > " + right + "  h: " + h;
        }
        public int getArea(){
            if(left == -1 || right == -1){
                return -1;
            }
            return (right - left) * h;
        }
    }

}
