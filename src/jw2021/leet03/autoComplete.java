package jw2021.leet03;

import java.util.*;

public class autoComplete {
    Node root;
    List<Character> prefix;
//    public AutocompleteSystem(String[] sentences, int[] times) {
//        root = new Node();
//        prefix = new ArrayList<>();
//        for(int i = 0; i <sentences.length; i++ ) {
//            insert(sentences[i], times[i]);
//        }
//    }

    public List<String> input(char c) {
        if(c == '#') {
            update();
            prefix.clear();
            return new ArrayList<>();
        }
        prefix.add(c);
        //System.out.println(prefix);
        return getTop(getAll());
    }
    private void update(){
        //intert or update the trie, based on prefix;
        String word =  getPrefix();
        insert(word, 1);
    }

    private String getPrefix(){
        StringBuilder sb = new StringBuilder();
        for(char c: prefix){
            sb.append(c);
        }
        return sb.toString();
    }

    private List<String> getTop(List<Pair> all){
        Collections.sort(all, (a, b)-> {
            if(a.freq == b.freq) {
                return a.str.compareTo(b.str);
            }
            return b.freq - a. freq;
        });
        List<String> res = new ArrayList<>();
        for(int i = 0; i < all.size() && i < 3; i++){
            res.add(all.get(i).str);
        }
        return res;
    }

    private List<Pair> getAll() {
        //get all of the sentences that match the prefix;
        Node cur = root;
        for(int i = 0; i < prefix.size(); i++){
            char c = prefix.get(i);
            if(!cur.kids.containsKey(c)){
                return new ArrayList<>();
            }
            cur = cur.kids.get(c);
        }
        List<Pair> res = new ArrayList<>();
        dfs(cur, res);
        return res;
    }

    private void dfs(Node root, List<Pair> res) {
        if(root == null) {
            return;
        }
        if(root.isWord) {
            res.add(new Pair(root.sens, root.freq));
            //dfs(entry.getValue());
        }
        for(Map.Entry<Character, Node> entry : root.kids.entrySet()) {
            dfs(entry.getValue(), res);
        }
    }



    private void insert(String str, int freq) {
        Node cur = root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(!cur.kids.containsKey(c)){
                cur.kids.put(c, new Node());
            }
            cur = cur.kids.get(c);
        }
        cur.sens = str;
        boolean added = false;
        if(cur.isWord){
            added = true;
        } else {
            cur.isWord = true;
        }
        if(added){
            cur.freq++;
        } else{
            cur.freq = freq;
        }

    }




    class Pair{
        String str;
        int freq;
        Pair(String s, int f){
            str = s;
            freq = f;
        }
    }

    class Node {
        char c;
        Map<Character, Node> kids;
        boolean isWord;
        int freq;
        String sens;
        Node(){
            kids = new HashMap<>();
            isWord = false;
        }
    }

}


class testme{
    public static void main(String[] args) {

    }
}
