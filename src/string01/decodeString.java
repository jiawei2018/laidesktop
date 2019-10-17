package string01;

import java.util.ArrayDeque;
import java.util.Deque;

public class decodeString {

    public static void main(String[] args) {
        String s1 = "2[W]";
        //System.out.println(decodeStringA(s1));
    }

    public static String decodeString(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        Deque<Integer> digi = new ArrayDeque<>();//the first idx of the num before '['
        Deque<String> mid = new ArrayDeque<>();

        String res = "";
        int i = 0;
        while(i < s.length()){
            if( isnum(s.charAt(i)) ){
                int num = 0;
                while(isnum(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');//here
                    i++;
                }
                digi.push(num);
            } else if(s.charAt(i) == '['){
                mid.push(res);
                res = "";
                i++;
            } else if(s.charAt(i) == ']'){
                int k = digi.pop();
                res = mid.pop() + gen(k, res);
                i++;
            } else {
                res += s.charAt(i++);
            }
        }

        return res;
    }

    //     boolean flag = false;
    // for(int i = 0 ; i < s.length(); i++){
    //     if(s.charAt(i) == '['){
    //         left.push(i);
    //         flag = false;
    //     }else if(isnum(s.charAt(i)) && !flag){
    //         digi.push(i);
    //         flag = true;
    //     }else if(s.charAt(i) == ']'){
    //         right.push(i);
    //         //the main logic is here
    //        // int k = Integer.valueOf(s.substring(digi.peek(), left.peek() ));
    //        // res += gen(k , s.substring(left.peek() + 1, i) );//substring is [) method
    //        // left.pop();
    //         //digi.pop();
    //     }else{
    //        // res += s.charAt(i);
    //     }
    // }

//         String last = s.substring(right.peekLast(), s.length());// for the rest after last ]
//         while(!left.isEmpty()){
//             //3[xxx2[ggg]mmm]ppp
//             int leftidx = left.pop();
//             int digiidx = digi.pop();
//             int rightidx = right.pollFirst();//use as a queue
//             int curk = Integer.valueOf(s.substring(digiidx, leftidx));
//             String beforepart = s.substring(left.peek + 1, digiidx);
//             String restpart = s.substring(rightidx + 1, right.peekFirst());
//             String tmp = beforepart + gen(k , s.substring(left.peek() + 1, rightidx) ) + restpart;
//             mid.push(tmp);

    //         }
    private static  String gen(int k, String str){// maybe
        StringBuilder sb = new StringBuilder();
        while(k > 0){
            sb.append(str);
            k--;
        }
        return sb.toString();
    }

    private static boolean isnum(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }else
            return false;
    }
}
