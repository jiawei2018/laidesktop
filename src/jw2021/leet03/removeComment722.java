package jw2021.leet03;

import java.util.ArrayList;
import java.util.List;

public class removeComment722 {


    public static void main(String[] args) {
        String[] source = {"/*Test program */",
                "int main()", "{ ",
                "  // variable declaration ",
                "int a, b, c;", "/* This is a test", "   multiline  ",
                "   comment for ", "   testing */", "a = b + c;", "}"};

        String[] s2 =
                {"a/*comment", "line", "more_comment*/b"};

        removeComment722 tt = new removeComment722();

        System.out.println(tt.removeComments(s2));

    }
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if(source == null || source.length == 0) {
            return res;
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(String str : source) {

            char[] line = str.toCharArray();
            //if current is in a comment section
            for(int i = 0; i < line.length; i++ ) {
                if(flag) {
                    // looking for '*/'
                    if(i < line.length -1 && line[i] == '*' && line[i + 1] == '/') {
                        flag = false;
                        i++;//by pass the '/'
                    }
                } else {
                    if(i < line.length -1 && line[i] == '/' && line[i + 1] == '*') {
                        flag = true;
                        i++;
                        continue;
                    } else if(i < line.length -1 && line[i] == '/' && line[i + 1] == '/') {
                        break;
                    } else {
                        sb.append(line[i]);
                    }

                }
            }

            if(!flag && sb.length() > 0) {
                res.add(sb.toString());
            }
        }




        return res;
    }


}
