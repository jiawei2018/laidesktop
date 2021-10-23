package wangjing_6205;

import java.util.Arrays;

public class ass01 {

    public static void main(String[] args) {
//        ass01 t = new ass01();
//        int[] t1 = {2,0,2,1,1,2,0,2};
//        t.sortEvenOdd(t1);
//        System.out.println(Arrays.toString(t1));
//        //int[][] t2 = {{0,30},{5,10},{15,20}};
//        int[][] t2 = {{7,10},{2,4}};
//        int[] t3 = {6,2,6,5,1,2};
//        System.out.println(t.getMaxMin(t3));
    }


    // time: o(n)  space: o(1)
    public void colourSort(int[] colors) {
        // input like 1,0,1,2,0,2
        //sort 0, 1, 2
        // modify input array
        int i = 0;
        int k = colors.length - 1;
        int j = 0;
        while(j <= k) {
            if(colors[j] == 0) {
                swap(colors, j, i);
                i++;
                j++;
            } else if(colors[j] == 2) {
                swap(colors, j, k);
                k--;
            } else {
                j++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    //time o(nlogn), space o(n)
    public boolean checkIfCanAttend(int[][] nums) {
    //Given an array of meeting time intervals where intervals[i] =
    //[starti, endi], determine if a person could attend all meetings.
    //[[0,30],[5,10],[15,20]]
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i][0] < nums[i-1][1]) {
                return false;
            }
        }
        return true;
    }

    //time o(nlogn) spce : o(n) for sort o(1) for sum
    public int getMaxMin(int[] nums){
        //Question 3: Given an integer array nums of 2n integers, group these
        //integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai,
        //bi) for all i is maximized. Return the maximized sum.
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    //time : o(nlogn) space:o(n)
    public int[] sqareSort(int[] nums) {
        //Question 4: Given an integer array nums sorted in non-decreasing order,
        //return an array of the squares of each number sorted in non-decreasing
        //order.
        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

    //time o(nlogn), space o(n) for sort o(1) for compare
    public boolean isAnagram(String s, String t) {
        //Question 5: Given two strings s and t, return true if t is an anagram of s,
        //and false otherwise.
        if(s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        for(int i = 0; i < c1.length; i++){
            if(c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    //time o(n), space o(1)
    public void sortEvenOdd(int[] nums) {
        //Question 6: Given an integer array nums, move all the even integers at the
        //beginning of the array followed by all the odd integers.
        //Return any array that satisfies this condition.
            int a = 0, b = nums.length - 1;

            while(a <= b) {
                if(isEven(nums[a]) ) {
                    a++;
                } else if(!isEven(nums[b])) {
                    b--;
                } else {
                    swap(nums, a, b);
                    a++;
                    b--;
                }
            }
    }

    private boolean isEven(int n) {
         return n % 2 == 0;
    }

}
