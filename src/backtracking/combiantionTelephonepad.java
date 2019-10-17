package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations For Telephone Pad I
 * Description
 * Given a telephone keypad, and an int number,
 * print all words which are possible by pressing these numbers, the output strings should be sorted.
 * <p>
 * {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}
 * <p>
 * Assumptions:
 * <p>
 * The given number >= 0
 * Examples:
 * <p>
 * if input number is 231, possible words which can be formed are:
 * <p>
 * [ad, ae, af, bd, be, bf, cd, de, df]
 */
public class combiantionTelephonepad {
    public String[] combinations(int number) {
        // Write your solution here
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};//0 to 9
        String[] zero = {""};
        if (number < 2) {
            return zero;
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] nums = toCharArr(number).toCharArray();
        if (nums.length >= 1) {
            recur(res, sb, dict, nums, 0);
        } else {
            return zero;
        }

        return res.toArray(new String[res.size()]);
    }

    private void recur(List<String> res, StringBuilder sb, String[] dict, char[] nums, int idx) {
        if (idx == nums.length) {
            res.add(sb.toString());
            return;
        }
        for (char c : dict[nums[idx] - '0'].toCharArray()) {
            sb.append(c);
            recur(res, sb, dict, nums, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    private  String toCharArr(int number) {
        String str = String.valueOf(number);
        char[] tmp = str.toCharArray();
        String res = "";
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] - '0' > 1) {
                res += tmp[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        combiantionTelephonepad t = new combiantionTelephonepad();

        System.out.println(t.combinations(231));

    }
}
