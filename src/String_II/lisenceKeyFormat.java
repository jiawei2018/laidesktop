
package String_II;

public class lisenceKeyFormat {
    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        System.out.println(licenseKeyFormatting(s, 4));
    }

    public static String licenseKeyFormatting(String S, int K) {
        if(S == null || S.length() < 2){
            return S;
        }
        String[] strs = S.toUpperCase().split("-");
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        //  System.out.println(sb);
        StringBuilder res = new StringBuilder();
        int parts = S.length() / K;
        int rem = S.length() % K;
        int idx = 0;
        for(int i = 0; i < parts; i++){
            if(res.length() == 0 && rem != 0 ){
                res.append(sb.substring(0, rem));
                idx = rem + 1;
            }else {
                res.append(sb.substring(idx , idx + K)).append("-");
                idx += K;
            }
        }
        return res.toString();

    }
}
