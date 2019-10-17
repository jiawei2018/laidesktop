package String_II;

import myHelperUtil.MyPrintHelper;

public class shorestCompleteingWOrd {
    public static void main(String[] args) {
        shorestCompleteingWOrd t = new shorestCompleteingWOrd();

        String tt = "1s3 PSt";

        MyPrintHelper.printArray(t.getMap(t.format(tt)));

    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        //to lower case
        // if(word.length() < s.length()){
        //     return false;
        // }
        int[] plate = getMap(format(licensePlate));
        int min = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < words.length; i++){
            if(match(plate, words[i]) ){
                int len = words[i].length();
                if(len < min){
                    min = len;
                    res = i;
                }
            }
        }
        return res == -1 ? "" : words[res];
    }
    private String format(String s){
        //format to only lowercase string without number
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if((c >'9' || c < '0') && c != ' '){
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }

    private boolean match(int[] plate, String word){
        int[] map = getMap(word);
        for(int i = 0; i < 26; i++){
            if(map[i] >= plate[i] || plate[i] == -1){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    private int[] getMap(String s){
        int[] res = new int[26];
        for(int i = 0; i < s.length(); i++){
            res[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(res[i] == 0){
                res[i] = -1;
            }
        }
        return res;
    }
}
