package quip;

import java.sql.SQLOutput;

public class a001 {
    //给一个string，返回每个字母出现的次数(List<Integer>(26))
    //
    //a ~ i => 1 ~ 9
    //j ~ z => 10# ~ 26#
    //exmple: 1226#(3)
    //output: 一个长度为26的arraylist，叫做result，result.get(0) = 1, result.get(1) = 1, result.get(25) = 3, 其他都是0
    //
    //注意，output是index 0~25 代表a~z，但是input是1~26代表a~z

    public static void main(String[] args) {
        a001 t = new a001();
        System.out.println(t.decode(""));
    }

    public String decode(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(i == 0 || str.charAt(i) == str.charAt(i - 1)){
                count++;
                continue;
            } else {
                if(count == 1){
                    sb.append(fmt(str.charAt(i - 1)));
                 } else {
                    sb.append(fmt(str.charAt(i - 1))).append("(" + count +")");
                 }
                count = 1;
            }
        }
        String last = "";
        if(count == 1){
            last = fmt(str.charAt(str.length() - 1));
        } else {
            last = fmt(str.charAt(str.length() - 1))+("(" + count +")");
        }
        sb.append(last);//last char

        //System.out.println(sb);
        return sb.toString();
    }


    private String fmt(char c){
        String res = "";
        if(c - 'a' + 1 < 10){
            res = String.valueOf(c - 'a' + 1);
            //System.out.println(res);
            //return res;
        } else {
            res = String.valueOf(c - 'a' + 1 + "#");
            //System.out.println(res);
            //return res;
        }
        return res;
    }
}
