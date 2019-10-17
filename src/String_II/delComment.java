package String_II;

import java.util.ArrayList;
import java.util.List;

public class delComment
{


    public static void main(String[] args) {
        delComment t = new delComment();
        String[] r = {"a/*comment", "line", "more_comment*/b"};

        System.out.println(t.removeComments(r));
    }
    public List<String> removeComments(String[] source) {
        List<String> res  = new ArrayList<>();
        if(source == null || source.length == 0){
            return res;
        }
        boolean flag = false;
        // if(source[i].length() > 0) res.add(source[i]);
        StringBuilder tmp = new StringBuilder();//maybe two line join one so ,this must be out of loop!!!!!!!!!!!!!
        for(int i = 0; i < source.length; i++){
            //for each word ,find it
            String curline = source[i];
            for(int j = 0; j < curline.length(); j++){
                if(flag){//is a block comment
                    if(curline.charAt(j) == '*' && j < curline.length() - 1){
                        if( curline.charAt(j + 1) == '/'){
                            flag = false;
                            j++;//next time will jump to next char after '*/'
                        }
                    }
                } else {//not a block comment
                    if(j < curline.length() - 1  && curline.charAt(j) == '/' &&  curline.charAt(j + 1) == '/') {
                        break;//met // nad ignore rest
                    } else if(j < curline.length() - 1  && curline.charAt(j) == '/' &&  curline.charAt(j + 1) == '*'){
                        flag = true;
                        j++;//ne   xt time will jump to next char after '/*'
                    } else
                        //System.out.println(j + "  " + curline.charAt(j));
                        tmp.append(curline.charAt(j));
                }
            }//every line
            if(!flag && tmp.length() > 0){
                res.add(tmp.toString());
                tmp = new StringBuilder();//only when add the result
            }
        }
        return res;
    }
}
