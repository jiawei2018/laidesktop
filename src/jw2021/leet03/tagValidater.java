package jw2021.leet03;

import java.util.Stack;

public class tagValidater {


    public static void main(String[] args) {

        tagValidater t = new tagValidater();
        String t1 = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        t.isValid(t1);
    }




    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;

        while(i < code.length()) {

            // </ -> end
            if(code.startsWith("<![CDATA[" , i)){
                int j = i + 9;
                int idx = code.indexOf("]]>", j);
                if(idx < 0) {
                    //can not find "]]>" not a valid cdata
                    return false;
                }
                i = idx + 3;
            } else if(code.startsWith("</", i)) {

                int j = i + 2;
                while(j < code.length() &&  code.charAt(j) != '>') {
                    j++;
                }
                if(j == code.length()) {
                    return false;
                }
                String tmp = code.substring(i + 2, j);
                if(stack.isEmpty() || !stack.peek().equals(tmp)){
                    return false;
                }
                stack.pop();
                i = j + 1;
            } else if(code.startsWith("<", i)) {

                int j = i + 1;

                while(j < code.length() && code.charAt(j) != '>') {
                    if(!Character.isUpperCase(code.charAt(j))) {
                        return false;
                    }
                    j++;
                }
                if(j == code.length()) {
                    return false;
                }
                String tmp = code.substring(i + 1, j);
                if(tmp.length() < 1 || tmp.length() > 9) {
                    return false;
                }
                stack.push(tmp);
                i = j;
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }

}
