package class6;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given a matrix of size N x M. For each row the elements are sorted in ascending order,
 * and for each column the elements are also sorted in ascending order.
 * Find the Kth smallest number in it.
 *
 * Assumptions
 *
 * the matrix is not null, N > 0 and M > 0
 * K > 0 and K <= N * M
 * Examples
 *
 * { {1,  3,   5,  7},
 *
 *   {2,  4,   8,   9},
 *
 *   {3,  5, 11, 15},
 *
 *   {6,  8, 13, 18} }
 *
 * the 5th smallest number is 4
 * the 8th smallest number is 6
 */
public class kthSmallestInMatrix {
    class node implements Comparable<node> {//this <noed> must
        int x;
        int y;
        int val;
        public node(int x, int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(node n) {
            if(this.val == n.val){
                return 0;
            }else
                return this.val < n.val ? -1 : 1;   //why min heap?
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        if(k == 0 || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if( m * n < k){
            return matrix[m - 1][n - 1];
        }

        PriorityQueue<node> minHeap = new PriorityQueue<>();


        boolean[][] visited = new boolean[m][n];
        minHeap.offer(new node(0,0,matrix[0][0]));//init
        visited[0][0]  = true;
        int col = 0;
        int row = 0;
        int count = k;
        //init 2.expand 3.generate 4.terminate 5.dedup
        node res  = new node(0,0,0);
        while(count > 1 ){//the next poll will be the 9th!, dont poll it out !   //termination
            node tmp = minHeap.poll();// poll will be poll the Nth  smallest ele!   //expend
            //System.out.println(tmp.x + "    "+ tmp.y);
            count--;
//            if (count  == 0) {
//                res = tmp;
//            }
            if(tmp.x + 1 <= m - 1 && !visited[tmp.x + 1][tmp.y]) { //deduplication and generation
                minHeap.offer(new node(tmp.x + 1, tmp.y ,matrix[tmp.x + 1][tmp.y]));
                visited[tmp.x + 1][tmp.y] = true;
            }
            if(tmp.y + 1 <= n - 1 && !visited[tmp.x][tmp.y + 1]){
                minHeap.offer(new node(tmp.x , tmp.y + 1 ,matrix[tmp.x ][tmp.y + 1]));
                visited[tmp.x][tmp.y + 1] = true;
            }
        }
        return matrix[minHeap.peek().x][minHeap.peek().y];
    }

    public static void main(String[] args) {
        int[][] a = { {1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
        kthSmallestInMatrix t = new kthSmallestInMatrix();
        System.out.println(t.kthSmallest(a, 16));
        //t.kthSmallest(a, 16);
    }
}
