package test001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class stringstest
{

    public static void main(String[] args) {
        stringstest t = new stringstest();
        String[] s = {"abc","bcd","acef","xyz","az","ba","a","z"};
        //System.out.println(t.groupStrings(s)) ;
        bittest();
    }

    private static void bittest(){
        int u = 1;
        for(int i = 0 ;i < 34; i++){
            u = u << 1;
            System.out.println(u);
            /*
            2
4
8
16
32
64
128
256
512
1024
2048
4096
8192
16384
32768
65536
131072
262144
524288
1048576
2097152
4194304
8388608
16777216
33554432
67108864
134217728
268435456
536870912
1073741824
-2147483648
0
0
0
             */
        }
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if(strings == null || strings.length == 0){
            return res;
        }
        boolean[] used = new boolean[strings.length];
        //int count = 0;
        //List<String> tmp = toList(strings);
        for(int i = 0; i < strings.length; i++){
            if(used[i]){
                continue;
            }
            String cur = strings[i];
            Set<String> set = genSet(cur);
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < strings.length; j++  ){
                if(used[j]){
                    continue;
                }
                if(set.contains(strings[j])){
                    temp.add(strings[j]);
                    used[j] = true;
                }
            }
            //System.out.println(temp);
            res.add(new ArrayList<>(temp));
        }
        // genSet("aaa");
        return res;
    }

    private Set<String> genSet(String str){
        Set<String> set = new HashSet<>();
        //set.add(str);
        while(set.add(str)){// can add i think max will be 26 of them
            char[] carr = str.toCharArray();
            for(int i = 0; i < carr.length; i++){
                carr[i] = (char)((carr[i] - 'a' + 1) % 26 + 'a');
            }
            str = String.valueOf(carr);
            //System.out.println(str);
        }
        return set;
    }


    private List<String> toList(String[] strings){
        List<String> res = new ArrayList<>();
        for(String s: strings){
            res.add(s);
        }
        return res;
    }
}
