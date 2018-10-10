package class_DFS_I;

import java.util.ArrayList;
import java.util.List;

/*
Description
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Assumptions

N >= 0
Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
N = 0, all valid permutations are [""]
 */
public class allKuoHao_I {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        recur(n, 0, 0, res, new StringBuilder());
        return res;
    }

    private void recur(int n,int countR, int countL, List<String> res, StringBuilder tmp){
        if(countL == n && countR == n){
            res.add(tmp.toString());
            return;
        }
        if(countL < n){
            tmp.append('(');
            recur(n,countR, countL + 1, res, tmp);
            tmp.deleteCharAt(tmp.length() - 1);//mistake must 吃一个吐一个
        }
        if(countR < countL){
            tmp.append(')');
            recur(n, countR + 1, countL, res, tmp);
            tmp.deleteCharAt(tmp.length() - 1);//mistake must 吃一个吐一个
        }
    }

    public static void main(String[] args) {
        allKuoHao_I t = new allKuoHao_I();
        System.out.println(t.validParentheses(3));
    }

}
