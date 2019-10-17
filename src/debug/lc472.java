package debug;

import java.util.ArrayList;
import java.util.List;

public class lc472 {
    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        lc472 t= new lc472();
        t.findAllConcatenatedWordsInADict(words);
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) {
            return res;
        }
        root = new Node();
        buildTrie(words);
        for(String word : words) {
            if(recur(word, root, 0)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean recur(String word, Node cur, int idx) {//chk if a word can be formed by 2+ words
        //System.out.println(word + "  " + idx);
        if(cur == null) {
            return false;//cant find word in trie
        }
        if(idx == word.length()) {
            //last char;
            if(cur != null && cur.isword && !cur.word.equals(word)){//this means if cur.word = word, means this is a whole word
                return true;
            }
            return false;
        }
        if(cur.isword) {
            System.out.println(word + "  " + idx + "   " + (idx+ 1));
        }
        if(cur.isword) {// mistake why idx not idx+1?
            //System.out.println(word + "  " + idx);
            if(recur(word, root, idx)) {
                return true;
            }

        }
        //cur is not a word;
        //System.out.println(word + "  " + idx);
        int next = word.charAt(idx) - 'a';
        return recur(word, cur.kids[next], idx + 1);
    }

    Node root;

    private void buildTrie(String[] words) {
        for(String word : words) {
            build(word);
        }
    }

    private void build(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(cur.kids[idx] == null) {
                cur.kids[idx] = new Node();
            }
            cur = cur.kids[idx];
        }
        cur.isword = true;
        cur.word = word;
    }

    class Node{
        boolean isword;
        String word;
        Node[] kids = new Node[26];

    }
}
