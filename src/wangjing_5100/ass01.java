package wangjing_5100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ass01 {

    public static void main(String[] args) {
        ass01 t = new ass01();
        //q1
        int[] num1 = {1, 2, 3, 2};
        int[] num2 = {1, 1, 1, 1, 1};
        int[] num3 = {1, 2, 3, 4, 5};
        System.out.println(t.getUniqueSum(num1));
        System.out.println(t.getUniqueSum(num2));
        System.out.println(t.getUniqueSum(num3));
        System.out.println("===================================");

        //q2
        int[] q2n1 = {-4, -1, 0, 3, 10};
        int[] q2n2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(t.arraySquare(q2n1)));
        System.out.println(Arrays.toString(t.arraySquare(q2n2)));
        System.out.println("===================================");

        //q3
        int[] q3t1 = {2, 3, 4, 2, 2, 3, 5, 7};
        int[] q3t2 = {0, 0, 1, 1};
        System.out.println(t.getFirstUnique(q3t1));
        System.out.println(t.getFirstUnique(q3t2));
        System.out.println("===================================");

        //q4
        String q4s1 = "a";
        String q4s11 = "b";
        String q4s2 = "aa";
        String q4s21 = "ab";
        String q4s3 = "aabb";
        String q4s31 = "cbavvbnba";
        System.out.println(t.canConstruct(q4s1, q4s11));
        System.out.println(t.canConstruct(q4s2, q4s21));
        System.out.println(t.canConstruct(q4s3, q4s31));
        System.out.println("===================================");

        //q5
        String q5t1 = "1A3d4s5t";
        String q5t2 = "A2bb2d4";
        System.out.println(t.isDigiCharSeq(q5t1));
        System.out.println(t.isDigiCharSeq(q5t2));


    }

    //Question 1:
    //You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
    //Return the sum of all the unique elements of nums.
    //Example 1:
    //Input: nums = [1,2,3,2]
    //Output: 4
    //Explanation: The unique elements are [1,3], and the sum is 4.
    //Example 2:
    //Input: nums = [1,1,1,1,1]
    //Output: 0
    //Explanation: There are no unique elements, and the sum is 0.
    //Example 3:
    //Input: nums = [1,2,3,4,5]
    //Output: 15
    //Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.

    //time o(nlogn) space o(n)
    public int getUniqueSum(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int sum = 0;
        while (i < nums.length) {
            int tmp = nums[i];
            int j = i;
            while (j < nums.length && nums[j] == tmp) {
                j++;
            }

            if (j == i + 1) {
                sum += tmp;
            }
            i = j;
        }
        return sum;
    }


    //Question 2:
    //Given an integer array nums sorted in non-decreasing order, return an array of the squares of each  number sorted in non-decreasing order.
    //Example 1:
    //Input: nums = [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]
    //Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes [0,1,9,16,100].
    //Example 2:
    //Input: nums = [-7,-3,2,3,11]
    //Output: [4,9,9,49,121]

    //time o(nlogn)   space o(n)
    public int[] arraySquare(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }


    //Question 3:
    //Find first non repeated integer in an array.
    //Example: int[] arr = {2,3,4,2,2,3,5,7}
    //Output : 4

    public int getFirstUnique(int[] nums) {
        int[] copyArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArr);

        int i = 0;
        Set<Integer> set = new HashSet<>();
        while (i < copyArr.length) {
            int tmp = copyArr[i];
            int j = i;
            while (j < copyArr.length && copyArr[j] == tmp) {
                j++;
            }

            if (j == i + 1) {
                set.add(copyArr[i]);
            }
            i = j;
        }

        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            }
        }

        return -1;
    }


    //Question 4:
    //Given two stings ransomNote and magazine, return true if ransomNote can be constructed  from magazine and false otherwise.
    //Each letter in magazine can only be used once in ransomNote.
    //Example 1:
    //Input: ransomNote = "a", magazine = "b"
    //Output: false
    //Example 2:
    //Input: ransomNote = "aa", magazine = "ab"
    //Output: false
    //Example 3:
    //Input: ransomNote = "aa", magazine = "aab"
    //Output: true

    //time o(nlogn), space o(n)
    public boolean canConstruct(String ran, String maz) {
        //freq map........ better way? sort? if sort and then two pointer?
        char[] ranArr = ran.toCharArray();
        char[] mazArr = maz.toCharArray();
        Arrays.sort(ranArr);
        Arrays.sort(mazArr);

        int i = 0, j = 0;
        while (i < ranArr.length && j < mazArr.length) {
            if (ranArr[i] == mazArr[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == ranArr.length;
    }


    //Question 5:
    //Letter followed by Digit: Given a string str write a function which will check if the string no  letter followed by another letter, and no digit followed by another digit.
    //For example: 1A3d4s5t
    //Result : True
    //Input: A2bb2d4
    //Result : False
    //time o(n) space o(1)
    public boolean isDigiCharSeq(String str) {
        if (str.length() <= 1) {
            return true;
        }

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (isDig(c)) {
                if (!isChar(prev)) {
                    return false;
                }
            } else {
                if (!isDig(prev)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isDig(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

}
