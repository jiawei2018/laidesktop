package midTerm_I;

import java.util.PriorityQueue;

/**
 * Problem 5(Submitted)
 * #5 Given two sorted arrays A and B, with their sizes to be m and n, respectively.
 *
 * We can pick one element a from A and the other element b from B, and their sum s is defined to be s = a + b.
 *
 * How to find k-th smallest s from all possible values of s.
 *
 * Assumption: k < m * n. e.g. A = {1, 3, 5}, B = {2, 3},
 * k = 1, the result is A[0] + B[0] = 3 k = 2,
 * the result is A[0] + B[1] = 4 k = 3, the result is A[1] + B[0] = 5
 */
public class q5 {
    class Sum implements Comparable<Sum>{
        int x;
        int y;
        int val;
        public Sum(int x, int y, int[] ax , int[] by){
            this.x = x;
            this.y = y;
            this.val = ax[x] + by[y];
        }
        @Override
        public int compareTo(Sum o) {
            if(this.val == o.val){
                return 0;
            }
            return this.val < o.val ? 1 : -1;
        }
    }

    public int getKthSum(int[] a, int[] b, int k){
        //corner case
        if(k < 0 || k > a.length * b.length ){//k cant be negative;
            return 0;
        }
        if(k == 0){
            return Math.min(a[0], b[0]);
        }
        if(a.length == 0 || b.length == 0){
            return a.length == 0 ? b[k - 1] : a[k - 1];
        }
        int m = a.length;
        int n = b.length;
        PriorityQueue<Sum> pq = new PriorityQueue<>();//minheap
        boolean[][] used = new boolean[m][n];
        pq.offer(new Sum(0, 0, a, b  ));
        used[0][0] = true;
        for(int i = 0; i < k; i++){
            Sum s = pq.poll();//this means we pool the smallest element at this point;
            //in for loop, we do this on time ,the smallest ele will be delete from queue, and
            // if we did k times ,the answer will be here
            if(!used[s.x + 1][s.y] && s.x + 1 < m){//1 of the nearest two sums is when a[m+ 1]
                //and b don't move ;
                pq.offer(new Sum(s.x + 1, s.y, a, b));
                used[s.x + 1][s.y] = true;
            }

            if(!used[s.x][s.y + 1] && s.y + 1 < n){// another of the nearest two sums is when b
                //b[n + 1] and a don;t move
                pq.offer(new  Sum(s.x, s.y + 1, a, b));
                used[s.x ][s.y + 1] = true;
            }
        }
        return pq.peek().val;
    }

    public int getKthSumA(int[] a, int[] b, int k){
        //corner case
        if(k < 0){//k cant be negative;
            return 0;
        }
        if(k == 0){
            return Math.min(a[0], b[0]);
        }
        if(a.length == 0 || b.length == 0){
            return a.length == 0 ? b[k - 1] : a[k - 1];
        }
        int m = 0;
        int n = 0;
        int count = 0;
        int res = 0;
        int tmp1 = a[0];
        int tmp2 = b[0];
        while(count < k){

            if(a[m] < b[n]){
                 tmp1 = a[m] + b[n];
                m++;
            }else{
                 tmp2 = a[m] + b[n];
                n++;
            }
            res = Math.min(tmp1 , tmp2);
            count++;
        }
        return res;
    }































}
