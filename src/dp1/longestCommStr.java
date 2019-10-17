package dp1;

public class longestCommStr {
    public String longestCommon(String source, String target) {
        // Write your solution here
        if(source.length() < target.length()){
            return longestCommon(target, source);
        }

        int[][] res = new int[source.length()][target.length()];
        int left = 0;
        int right = 0;
        int maxlen = 0;
        for(int i = 0 ; i < source.length(); i++){

            for(int j = 0; j < target.length(); j++){
                if(source.charAt(i) == target.charAt(j)){
                    if(i == 0 || j == 0){
                        res[i][j] = 1;//?
                    } else {
                        res[i][j] = res[i - 1][j - 1] + 1;
                        if(res[i][j] > maxlen){
                            maxlen = res[i][j];
                            left = i - maxlen + 1;
                            //right = i;
                        }
                    }
                }
            }
        }
        String out = source.substring(left, left + maxlen);
        System.out.println(out);
        return out;
    }

    public static void main(String[] args) {
        String s1 = "ewr132q";
        String s2 = "sfertrwr99";
        longestCommStr t = new longestCommStr();
        t.longestCommon(s1, s2);
    }
}
