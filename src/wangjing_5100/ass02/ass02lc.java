package wangjing_5100.ass02;

import java.util.*;

public class ass02lc {

    public static void main(String[] args) {

    }

    //1) Transpose Matrix : https://leetcode.com/problems/transpose-matrix/
    //Given a 2D integer array matrix, return the transpose of matrix.
    //The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and  column indices.
    //Example 1:
    //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //Output: [[1,4,7],[2,5,8],[3,6,9]]
    //Example 2:
    //Input: matrix = [[1,2,3],[4,5,6]]
    //Output: [[1,4],[2,5],[3,6]]
    //Constraints:
    //• m == matrix.length
    //• n == matrix[i].length
    //• 1 <= m, n <= 1000
    //• 1 <= m * n <= 105
    //• -109 <= matrix[i][j] <= 109
    public int[][] transpose(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < m; i++) {
            for(int j =0;j < n; j++) {
                res[j][i] = grid[i][j];

            }
        }
        return res;
    }



    //2) Shortest Word Distance : https://leetcode.com/problems/sign-of-the-product-of-an-array/
    //Given an array of strings wordsDict and two different strings that already exist in the  array word1 and word2,
    // return the shortest distance between these two words in the list.
    //Example 1:
    //Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 =  "coding", word2 = "practice"
    //Output: 3
    //Example 2:
    //Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 =  "makes", word2 = "coding"
    //Output: 1
    //Constraints:
    //• 1 <= wordsDict.length <= 3 * 104
    //• 1 <= wordsDict[i].length <= 10
    //• wordsDict[i] consists of lowercase English letters.
    //• word1 and word2 are in wordsDict.
    //• word1 != word2
    public int shortestDistance(String[] dict, String word1, String word2) {
        if(dict.length == 1) {
            return 0;
        }

        int p1 = -1;
        int p2 = -1;
        int res = dict.length;
        for(int i = 0; i < dict.length; i++) {
            if(dict[i].equals(word1)) {
                p1 = i;
            }

            if(dict[i].equals(word2)) {
                p2 = i;
            }

            if(p1 >= 0 && p2 >= 0) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }

        return res;
    }




    //3) Move Zeroes : https://leetcode.com/problems/move-zeroes/
    //Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the  non-zero elements.
    //Note that you must do this in-place without making a copy of the array.
    //Example 1:
    //Input: nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    //Example 2:
    //Input: nums = [0]
    //Output: [0]
    //Constraints:
    //• 1 <= nums.length <= 104
    //• -231 <= nums[i] <= 231 - 1

    public void moveZeroes(int[] nums) {
        int[] prevZ = new int[nums.length];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            prevZ[i] = count;
            if(nums[i] == 0){
                count++;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i - prevZ[i], i);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }



    //4) Rotate Image - https://leetcode.com/problems/rotate-image/
    //You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees  (clockwise).
    //You have to rotate the image in-place, which means you have to modify the input 2D matrix  directly. DO NOT allocate another 2D matrix and do the rotation.
    //Example 1:
    //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //Output: [[7,4,1],[8,5,2],[9,6,3]]
    //Example 2:
    //Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    //Example 3:
    //Input: matrix = [[1]]
    //Output: [[1]]
    //Example 4:
    //Input: matrix = [[1,2],[3,4]]
    //Output: [[3,1],[4,2]]
    //Constraints:
    //• matrix.length == n
    //• matrix[i].length == n
    //• 1 <= n <= 20
    //• -1000 <= matrix[i][j] <= 1000


    public void rotate(int[][] grid) {
        int n = grid.length;

        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right= n - 1;

        while(left < right) {
            for(int i = 0; i < right - left; i++) {
                int tmp = grid[top][left + i];
                grid[top][left + i] = grid[bottom - i][left];
                grid[bottom - i][left] = grid[bottom][right - i];
                grid[bottom][right - i] = grid[top + i][right];
                grid[top + i][right] = tmp;
            }
            top++; bottom--;
            left++; right--;
        }
    }




    //5) Spiral Matrix - https://leetcode.com/problems/spiral-matrix/
    //Given an m x n matrix, return all elements of the matrix in spiral order.
    //Example 1:
    //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //Output: [1,2,3,6,9,8,7,4,5]
    //Example 2:
    //Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    //Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    //Constraints:
    //• m == matrix.length
    //• n == matrix[i].length
    //• 1 <= m, n <= 10
    //• -100 <= matrix[i][j] <= 100
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;
        while(top <= bottom && left <= right){
            int curleft = left;
            while(curleft <= right){
                res.add(matrix[top][curleft++]);
            }
            top++;

            int curtop = top;
            while(curtop <= bottom){
                res.add(matrix[curtop++][right]);
            }
            right--;

            int curright = right;
            if(top <= bottom){
                while(curright >= left  ){
                    res.add(matrix[bottom][curright--]);
                }
                bottom--;
            }

            int curbottom = bottom;
            if(left <= right){
                while(curbottom >= top ){
                    res.add(matrix[curbottom--][left]);
                }
                left++;
            }
        }

        return res;

    }






    //6) Isomorphic Strings - https://leetcode.com/problems/isomorphic-strings/ Given two strings s and t, determine if they are isomorphic.
    //Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    //All occurrences of a character must be replaced with another character while preserving the order of  characters. No two characters may map to the same character, but a character may map to itself.
    //Example 1:
    //Input: s = "egg", t = "add"
    //Output: true
    //Example 2:
    //Input: s = "foo", t = "bar"
    //Output: false
    //Example 3:
    //Input: s = "paper", t = "title"
    //Output: true
    //Constraints:
    //• 1 <= s.length <= 5 * 104
    //• t.length == s.length
    //• s and t consist of any valid ascii character.
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            //mapping  is s -> t
            char tc = t.charAt(i);
            char sc = s.charAt(i);
            if(map.containsKey(sc)) {
                if(tc != map.get(sc)) {
                    return false;
                }
            } else {
                if(used.contains(tc)) {
                    return false;
                } else {
                    map.put(sc, tc);
                    used.add(tc);
                }
            }
        }
        return true;
    }






    //7) Add Strings - https://leetcode.com/problems/add-strings/
    //Given two non-negative integers, num1 and num2 represented as string, return the sum  of num1 and num2 as a string.
    //You must solve the problem without using any built-in library for handling large integers (such  as BigInteger). You must also not convert the inputs to integers directly.
    //Example 1:
    //Input: num1 = "11", num2 = "123"
    //Output: "134"
    //Example 2:
    //Input: num1 = "456", num2 = "77"
    //Output: "533"
    //Example 3:
    //Input: num1 = "0", num2 = "0"
    //Output: "0"
    //Constraints:
    //• 1 <= num1.length, num2.length <= 104
    //• num1 and num2 consist of only digits.
    //• num1 and num2 don't have any leading zeros except for the zero itself.
    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int a = 0, b = 0;
            if(i >= 0) {
                a = num1.charAt(i) - '0';
                i--;
            }
            if(j >= 0) {
                b = num2.charAt(j) - '0';
                j--;
            }

            int cur = a + b + carry;
            if(cur > 9) {
                cur = cur - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(cur);
        }

        if(carry > 0) {
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }





    //8) Valid Palindrome - https://leetcode.com/problems/valid-palindrome/
    //Given a string s, determine if it is a palindrome, considering only alphanumeric characters and  ignoring cases.
    //Example 1:
    //Input: s = "A man, a plan, a canal: Panama"
    //Output: true
    //Explanation: "amanaplanacanalpanama" is a palindrome.
    //Example 2:
    //Input: s = "race a car"
    //Output: false
    //Explanation: "raceacar" is not a palindrome.
    //Constraints:
    //• 1 <= s.length <= 2 * 105
    //• s consists only of printable ASCII characters.
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;

        while(i < j) {
            if(!isCharOrDig(s.charAt(i))) {
                i++;
                continue;
            }
            if(!isCharOrDig(s.charAt(j)))  {
                j--;
                continue;
            }

            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isCharOrDig(char c) {
        return (c >= 'a' && c <= 'z' )||(c >= 'A' && c <= 'Z' ) || (c >= '0' && c <= '9');
    }






    //9) Reverse words in a String - https://leetcode.com/problems/reverse-words-in-a-string/ Given an input string s, reverse the order of the words.
    //A word is defined as a sequence of non-space characters. The words in s will be separated by at  least one space.
    //Return a string of the words in reverse order concatenated by a single space.
    //Note that s may contain leading or trailing spaces or multiple spaces between two words.
    // The  returned string should only have a single space separating the words. Do not include any extra  spaces.
    //Example 1:
    //Input: s = "the sky is blue"
    //Output: "blue is sky the"
    //Example 2:
    //Input: s = " hello world "
    //Output: "world hello"
    //Explanation: Your reversed string should not contain leading or trailing spaces.
    //Example 3:
    //Input: s = "a good example"
    //Output: "example good a"
    //Explanation: You need to reduce multiple spaces between two words to a single space  in the reversed string.
    //Example 4:
    //Input: s = " Bob Loves Alice "
    //Output: "Alice Loves Bob"
    //Example 5:
    //Input: s = "Alice does not even like bob"
    //Output: "bob like even not does Alice"
    //Constraints:
    //• 1 <= s.length <= 104
    //• s contains English letters (upper-case and lower-case), digits, and spaces ' '. • There is at least one word in s.
    public String reverseWords(String s) {
        if(s == null || s.length() < 1){
            return s;
        }

        char[] carr = s.trim().toCharArray();
        removeSpace(carr);
        reverse(carr, 0, carr.length -1);

        int i = 0;
        while(i < carr.length){
            if(carr[i] == ' '){
                i++;
                continue;
            }
            int start = i;
            while(i < carr.length && carr[i] != ' '){
                i++;
            }
            reverse(carr, start, i - 1);
        }

        String str = String.valueOf(carr);
        return str.trim();
    }

    private void removeSpace(char[] carr){
        int slow = 0;

        for(int i = 0; i < carr.length; i++){
            if(carr[i] == ' ' &&  carr[i - 1] == ' '){
                continue;
            }else
                carr[slow++] = carr[i];
        }

        for(;slow < carr.length; slow++){
            carr[slow] = ' ';
        }
    }

    private void reverse(char[] s, int start, int end) {
        if(s == null || s.length < 2){
            return;
        }
        int left = start;
        int right = end;
        while( left < right){
            swap(s, left++, right--);
        }
    }

    private void swap(char[] s, int a, int b){
        char t = s[a];
        s[a] = s[b];
        s[b] = t;
    }






    //10) String Compression - https://leetcode.com/problems/string-compression/ Given an array of characters chars, compress it using the following algorithm: Begin with an empty string s. For each group of consecutive repeating characters in chars:
    //• If the group's length is 1, append the character to s.
    //• Otherwise, append the character followed by the group's length.
    //The compressed string s should not be returned separately, but instead, be stored in the input  character array chars. Note that group lengths that are 10 or longer will be split into multiple  characters in chars.
    //After you are done modifying the input array, return the new length of the array. You must write an algorithm that uses only constant extra space.
    //Example 1:
    //Input: chars = ["a","a","b","b","c","c","c"]
    //Output: Return 6, and the first 6 characters of the input array should be:  ["a","2","b","2","c","3"]
    //Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3". Example 2:
    //Input: chars = ["a"]
    //Output: Return 1, and the first character of the input array should be: ["a"]
    //Explanation: The only group is "a", which remains uncompressed since it's a single  character.
    //Example 3:
    //Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    //Output: Return 4, and the first 4 characters of the input array should be:  ["a","b","1","2"].
    //Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12". Example 4:
    //Input: chars = ["a","a","a","b","b","a","a"]
    //Output: Return 6, and the first 6 characters of the input array should be:  ["a","3","b","2","a","2"].
    //Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note  that each group is independent even if two groups have the same character.
    //Constraints:
    //• 1 <= chars.length <= 2000
    //• chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.


    public int compress(char[] chars) {

        if(chars.length < 2) {
            return chars.length;
        }
        int i = 0;
        int count = 0;
        int last = 0;
        while(i < chars.length) {
            int st = i;
            while(i < chars.length && chars[i] == chars[st]) {
                i++;
            }
            int length = i - st;
            //head char
            chars[last++] = chars[st];

            if(length >= 2) {
                // int to string
                char[] carr = String.valueOf(length).toCharArray();

                for(char c : carr) {
                    chars[last++] = c;
                }
            }
        }

        return last;
    }





}
