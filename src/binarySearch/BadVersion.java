package binarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BadVersion {


    //find the first badversion
    public int badVersion(char[] input){
        if(input == null || input.length < 1){
            return -1;
        }
        int n = input.length;
        int left = 0;
        int right = n - 1;


        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(isBadVersion(input, mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if(isBadVersion(input, left)){
            return left;
        }
        return isBadVersion(input, right) ? right : -1;
    }

    private boolean isBadVersion(char[] input , int idx){
        if (input[idx] == 'b'){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[]  a1 = {'a','a','a','b'};
        char[]  a2 = {'a','a','a','a'};
        char[]  a3 = {'b','b','b','b'};
        BadVersion t = new BadVersion();
        System.out.println(t.badVersion(a1));
    }
    private int[] uu(){
        Queue<MyPair> showw = new PriorityQueue<MyPair>((a,b)-> 1);

        int[] oo = new int[]{1,2,3};
        return new int[]{1,2,3};
    }


    class MyComparattor implements Comparator<Integer> {
        @Override
        public int compare(Integer o1 ,Integer o2){
            return 0;
        }
    }

}
class MyPair{
    int val;
    String time;
    public MyPair(int val ,String time){
        this.time = time;
        this.val = val;
    }
}