package other;

import java.util.ArrayList;
import java.util.List;

public class ipaddress093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        //char[] sa = s.toCharArray();

        recur(s, new StringBuilder(), res, 0, 0);
        return res;
    }

    private void recur(String s, StringBuilder sb, List<String> res, int part, int idx) {
        //System.out.println(sb.toString() + "          " + idx + " >>" + s.length());
        if (part == 4) {
            if (idx == s.length()) {
                res.add(sb.toString().substring(0, sb.length() - 1));
                return;
            }else
                return;
        }

        for (int i = idx; i <= s.length() && i - idx <= 3; i++) {
            String cur = s.substring(idx, i);
            //System.out.println(" cur -->" + cur);
            if (cur.length() > 0) {
                if (Integer.valueOf(cur) < 256 && Integer.valueOf(cur) >= 0) {
                    sb.append(cur).append(".");
                    recur(s, sb, res, part + 1, i);
                    for (int k = 0; k < cur.length() + 1; k++) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        ipaddress093 t = new ipaddress093();

        System.out.println(t.restoreIpAddresses(s));

    }

}
