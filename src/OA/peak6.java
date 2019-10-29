package OA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class peak6
{


    private int getMinGates(int maxWaitTime, int initialPlane, List<Integer> landingTime, List<Integer> takeoffTime){
        int diff = landingTime.size() - takeoffTime.size();
        int gates = 0;
        int i = 0, j = 0;

        while(i < landingTime.size() && j < takeoffTime.size()){
            //always i ++ ot get gates
            if(landingTime.get(i) < takeoffTime.get(j)){
                if(takeoffTime.get(j) - landingTime.get(i) > maxWaitTime){
                    gates++;
                }
            } else {
                j++;
            }
            i++;
        }

        return gates + initialPlane + diff;
    }















    public int getScore(List<String> words, List<String> syto, List<String> anto){
        Map<String, Integer> smap = getMap(syto, false);
        Map<String, Integer> amap = getMap(anto, true);

        int res = 0;
        for(String word : words){
            if(smap.containsKey(word)){
                res += smap.get(word);
            } else if(amap.containsKey(word)){
                res += amap.get(word);
            }
        }

        return res;
    }

    private Map<String, Integer> getMap(List<String> list, boolean isAn){
        Map<String ,Integer> map = new HashMap<>();
        for(String str : list){
            Pair cur = getVal(str, isAn);
            if(cur == null){
                continue;
            }
            map.put(cur.head, cur.val);
        }
        return map;
    }

    class Pair{
        int val;
        String head;
        public Pair(int v, String s){
            val = v;
            head = s;
        }
    }

    private Pair getVal(String str, boolean flag) {
        int idx = str.indexOf(":");
        if(idx < 0){
            return null;
        }
        String head = str.substring(0, idx);
        String tail  = str.substring(idx + 1);
        String[] neis = tail.split(",");

        int val = flag ? -1 : 1;
        int res = 0;
        for(String s : neis){
            if(isSq(head, s)){
                res += val;
            }
        }
        return new Pair(res, head);
    }


    public static void main(String[] args) {
        String s1 =  "aoodocoojod";
        String t1 = "acd";
        String t2 = "oooooo";
        peak6 t = new peak6();
        System.out.println(t.isSq(s1, t2));

    }

    private boolean isSq(String head, String cur){//need test
        if(cur.length() > head.length()){
            return false;
        }
        int idx = 0;
        for(int i = 0; i < head.length(); i++){
            if(head.charAt(i) == cur.charAt(idx)){
                idx++;
            }
            if(idx == cur.length()){
                return true;
            }
        }
        return false;
    }





}
