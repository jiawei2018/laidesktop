package test001;

import java.util.*;

public class cc extends father {


    public static void main(String[] args) {
        //List<Integer>  a= new ArrayList<>();
        System.out.println(13 % 0);

           // int   c = 109;
//String h  = String.valueOf(c);
           // String.valueOf(999);
     //Integer.parseInt();
       // System.out.println(h.toCharArray());
       // StringBuilder sb = new StringBuilder();
        //String.valueOf(1);
        //String s = new String();
        //sb.deleteCharAt()
        //System.out.println(Math.pow(3, 2));;
//        sb = new StringBuilder();
//        sb.setLength(0);
//        System.out.println();
//        super.setname(name);
        //System.out.println(1/3);


//Set<Integer> l = new HashSet<>();


        //cc t = new cc();
       // t.getHint("1122", "1222");
        //Map<Character, Integer> map = new HashMap<>();
        //map.values();

    }
  class test implements Iterator<test>{

      @Override
      public boolean hasNext() {
          return false;
      }

      @Override
      public test next() {
          return null;
      }
  }





    public String getHint(String secret, String guess) {
        //   wrong  wrong  wrong!!!!!!!!!!
//        if(secret == null || secret.length() == 0){
//            return "";
//        }
//        Map<Character, Set<Integer>> map = new HashMap<>();
//
//        char[] s = secret.toCharArray();
//        char[] g = guess.toCharArray();
//
//        for(int i = 0; i < s.length; i++){
//            if(!map.containsKey(s[i])){
//                map.put(s[i], new HashSet<>());
//            }
//
//            map.get(s[i]).add(i);
//        }
//        int as = 0;
//        int bs = 0;
//        for(int i = 0; i < g.length; i++){
//            Set<Integer> c = map.get(g[i]);
//            // System.out.println(c.size());
//            if(c != null && c.contains(i)){
//                as++;
//                map.get(g[i]).remove(i);
//            }
//        }
//
//        for(int i = 0; i < g.length; i++){
//            Set<Integer> c = map.get(g[i]);
//            if(c != null && !c.contains(i) && c.size() > 0 ){
//                bs++;
//            }
//        }


       // String res = as+ "A" + bs + "B";

        return "";
    }

}
