package fate;

import java.security.InvalidParameterException;

public class calsigiSum extends Throwable{


    private static final Object InvalidParameterException = "Input Invalid!";

    public static void main(String[] args) throws Throwable {
        String ins = "19801224";
        System.out.println(calToDigit("112091代理费v就好235362a 1"));
    }
    public static int calToDigit(String str) {
        int sum = 0;
        if(str == null || str.length() == 0 || str.length() > 3000000) {
            return -1;
        }
        for(char c : str.toCharArray()){
            if(c > '9' || c < '0'){
                System.out.println("Ignore at Character :'" + c + "'");
            } else {
                sum += c -'0';
            }
        }
        return  intSum(sum);
    }
    private static int intSum(int i){
        int res = 0;
        while(i > 9){
            res += i % 10;
            i /= 10;
        }
        if(res > 9){
            return intSum(res);
        }
         return res;
    }

}
