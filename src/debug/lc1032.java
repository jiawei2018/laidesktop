package debug;

import java.util.HashSet;
import java.util.Set;

public class lc1032 {

    public static void main(String[] args) {
        String[] strs = {"abaa","abaab","aabbb","bab","ab"};
        StreamChecker t = new StreamChecker(strs);
        t.query('a');
        t.query('a');
        t.query('b');
        t.query('b');
        t.query('b');
        t.query('a');
        t.query('a');
        t.query('b');
        t.query('b');
        t.query('j');
        t.query('k');
        t.query('l');


    }


    static class StreamChecker {
        Trie root;
        Set<Integer> lenSet;
        int maxlen;
        StringBuilder input;

        public StreamChecker(String[] words) {
            //init root;
            //build trie tree;
            root = new Trie();
            //build(words);
            lenSet = new HashSet<>();
            maxlen = 0;
            input = new StringBuilder();
            build(words);
        }

        private void build(String[] words) {
            for(String word : words) {
                insert(word);
            }
        }

        //we alsos need to mem length
        private void insert(String word) {
            Trie cur = root;
            int len = 0;
            for(int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if(cur.kids[idx] == null) {
                    cur.kids[idx] = new Trie();
                }
                cur = cur.kids[idx];
                len++;
            }
            lenSet.add(len);
            maxlen = Math.max(len, maxlen);
            cur.isword = true;
            cur.word = word;
        }


        public boolean query(char letter) {
            input.append(letter);
             boolean res = chk();
            System.out.println(letter + " <>  " + res);
            return res;
        }


        private boolean chk(){
            int curlen = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = input.length() - 1; i >= 0; i--) {
                sb.append(input.charAt(i));
                curlen++;
                if(curlen > maxlen) {
                    return false;
                }
                if(!lenSet.contains(curlen)){
                    continue;
                }

                if(chkInTrie(sb.reverse().toString())){
                    return true;
                }
            }
            return false;
        }

        private boolean chkInTrie(String str) {
            Trie cur = root;
            for(int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if(cur.kids[idx] == null) {
                    return false;
                }
                cur = cur.kids[idx];
            }
            return cur.isword;
        }



        class Trie {
            Trie[] kids;
            boolean isword;
            String word;
            public Trie(){
                kids = new Trie[26];
            }
        }
    }
}
