package temp;

public class testStringCompareVeresion {
    public static void main(String[] args) {
      String s1 =   "1.10";
      String s2 =   "1.101";

        System.out.println(compareVersion(s1, s2));

    }

    public static int compareVersion(String version1, String version2) {
//not null and not empty;
        int i1 = 0;
        int i2 = 0;
        char[] carr1 = version1.toCharArray();
        char[] carr2 = version2.toCharArray();

        while(i1 < carr1.length || i2 < carr2.length){
            pair p1 = new pair();
            pair p2 = new pair();

            //int ran = i1;
            p1.start =  i1;
            while(carr1[i1] != '.'){
                i1++;
            }
            p1.end = i1;

            p2.start = i2;
            while(carr2[i2] != '.'){
                i2++;
            }
            p2.end = i2;

            int cur = strCom(carr1, p1, carr2, p2);
            if(cur != 0) return cur;
        }

        return 0;
    }

    private static int strCom(char[] s1, pair p1, char[] s2, pair p2){
        //1 deal with leading 0
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int i1 = p1.start;
        int i2 = p2.start;
        while (i1 < p1.end || i2 < p2.end) {
            if( i1 < p1.end){
                if (sb1.length() != 0  || s1[i1] != '0') {
                    sb1.append(s1[i1]);
                }
                i1++;
            }
            if(i2 < p2.end){
                if (sb2.length() != 0 || s2[i2 ] != '0') {
                    sb2.append(s2[i2]);
                }
                i2++;
            }

        }

        int res = 0;
        int len1 = 0;
        int len2 = 0;

        if(sb1.length() > sb2.length()){
            return 1;
        } else if(sb1.length() < sb2.length()){
            return -1;
        }
        while(len1 < sb1.length() || len2 < sb2.length()){//same length
            int a = 0;
            int b = 0;
            if(len1 < sb1.length()) a = sb1.charAt(len1++);
            if(len2 < sb2.length()) b = sb2.charAt(len2++);

            if( a > b){
                return 1;
            } else if (a < b){
                return -1;
            }
        }

        return 0;
    }



}
class pair{
    int start ;
    int end;
}