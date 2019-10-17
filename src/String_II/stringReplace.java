package String_II;

import java.util.ArrayList;
import java.util.List;

/**
 *
 String Replace
 Description
 Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

 Assumptions

 input, S and T are not null, S is not empty string
 Examples

 input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 */
public class stringReplace {
    public String replace(String input, String source, String target) {
        // Write your solution here
        //notice t.length could > s.length
        char[] carr = input.toCharArray();
        if(source.length() >= target.length()){
            return shorter(carr, source, target);
        }else
            return longer(carr, source, target);
    }

    private String shorter(char[] carr, String source, String target) {
        //short in-place
        int slowidx = 0;
        int fastidx = 0;
        while(fastidx < carr.length){
            if(fastidx <= carr.length - source.length() && ifSubMatch(carr, fastidx, source)){
                copySubString(carr, slowidx, target);
                slowidx += target.length();//jump to another may-copy
                fastidx += source.length();//jump to another may-have
            }else // not found the sub match
                carr[slowidx++] = carr[fastidx++];
        }
        return String.valueOf(carr);
    }

    private String longer(char[] carr, String source, String target) {
        List<Integer> matchsIndices = getAllMatchs(carr, source);
        char[] res = new char[carr.length + matchsIndices.size() * (target.length() - source.length())];

        int fastidx = carr.length - 1;
        int slowidx = res.length - 1;
        int curidx = matchsIndices.size() - 1;

        while(fastidx >= 0){
            if(curidx >=0 && fastidx == matchsIndices.get(curidx)){
                copySubString(res, slowidx - target.length() + 1, target);//notice + 1
                //cpoysub from idx 0 to i,and length is last idx +1
                slowidx -= target.length();
                fastidx -= source.length();
                curidx--;
            }else{
                res[slowidx--] = carr[fastidx--];
            }
        }
        return new String(carr, 0, slowidx);
    }

    private boolean ifSubMatch(char[] carr, int staridx, String s){

        for(int i = 0; i < s.length(); i++){
            if(carr[staridx + i] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    private void copySubString(char[] carr, int staridx, String t){
        for(int i = 0; i < t.length(); i++){
            carr[staridx + i] = t.charAt(i);
        }
    }

    private List<Integer> getAllMatchs(char[] carr,  String source){
        //all matches of source end positions ? ou i know
        // we have to decide the new length
        //and we  do the replace from end to start!!!!!
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while(idx <= carr.length - source.length()){
            if(ifSubMatch(carr, idx, source)){
                res.add(idx + source.length() - 1);//notice this line d
                idx += source.length();
            }else
                idx++;
        }
        return res;
    }




    ////////////////IMPORTANT!!!!!!!!!!!!!
    public String replaceA(String input, String source, String target) {
        StringBuilder sb = new StringBuilder();
        // i have to kknow this !!!!
        int startidx = 0;
        int matchidx = input.indexOf(source, startidx);

        while(matchidx != -1){
            //sb append prev substring from end of last match to new match start
            sb.append(input, startidx, matchidx).append(target);

            startidx = matchidx + source.length();
            matchidx = input.indexOf(source, startidx);
        }
        sb.append(input, startidx, input.length());
        return sb.toString();
    }

}
