package ood;

public class BigInt {
    char[] bigInt;
    int length;
    public BigInt(){

    }
    public BigInt(String str){//for example "98713645987136245987639847569387465"
        int len = str.length();
        bigInt = new char[len * 2];
    }

    public BigInt sumWith(BigInt big){

        return null;
    }

    public BigInt multipl(BigInt big){

        return null;
    }


    public static void main(String[] args) {
        String s = "1010111";
        BigInt t = new BigInt();
        t.getMax1(s, 1);
    }
    public int getMax1(String str, int k){
        if(str == null || str.length() == 0) {
            return 0;
        }
        int left = 0;
        int res = 0;
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            while(left <= i && count > k){
                if(str.charAt(left) == '0'){
                    count--;
                }
                left++;
            }
            if(str.charAt(i) == '0'){
                count++;
            }
            res = Math.max(i - left + 1, res);
        }
        System.out.println(res);
        return res;
    }


}
