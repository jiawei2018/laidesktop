package quip;

import java.util.*;

/*
(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)
(A,B) (A,C) (B,D) (D,C)
(A,B) (A,C) (B,D) (E,F) (F,G) (F,H)
(A,B) (B,D) (B,C) (C,A)  4

(A,B) (B,C) (A,B) (A,C)
(A,B) (A,C) (A,D) (B,E)   6

(Q,Z) (C,D) (B,P) (A,C) (Q,X) (B,Q) (A,B)
(A,B) (B,C) (A,B)    8

(A,C) (A,B) (B,Q) (B,P) (C,D) (Q,Z) (Q,X)
(A,B) (A,C) (B,P) (B,Q) (C,D) (Q,X) (Q,Z)   10


(A,B) (A,C) (B,E) (B,F)
(P,J) (X,T) (R,E) (P,C) (X,B) (R,X)    12

(Q,Z) (C,D) (B,P) (A,C) (Q,X) (A,C) (B,Q)
(X,Y) (R,D) (D,P) (R,A) (Y,R) (X,Z) (Z,T) (Z,B) (R,G)     14


(U,V) (V,W) (V,X) (U,Z) (V,Y)
(U,V) (V,W) (V,X) (U,Z)     16

(U,V) (U,W) (V,X) (V,Y) (W,Z)
(Y,V) (V,X) (Y,W) (W,A) (V,U) (W,Z)    18

(Y,V) (V,X) (W,A) (Y,W) (V,U) (W,Z)
(Y,V) (V,X) (W,A) (Y,W) (V,U) (W,Z) (V,X)    20


(D,N) (W,H) (G,I) (P,E) (B,P) (X,A) (Z,Y) (B,G) (P,Q) (G,F) (W,M) (Z,D) (X,Z) (A,W) (D,S) (A,B)
(A,C) (A,B) (B,Q) (B,P) (C,D) (A,B) (Q,X) (P,Z)
(P,Y) (G,B) (Y,G) (P,Z) (Y,H) (P,A)
(A,B) (A,C) (B,D) (B,E)
(P,B) (E,X) (P,D) (E,Y) (P,A)
* */


public class a002 {
    public static void main(String[] args) {
        //List<String> all = new ArrayList<>();
        //String t1 = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
        //String t2 = "(A,B) (A,C) (B,D) (D,C)";
        a002 t = new a002();
        //System.out.println(t.build(t2));
        List<String> all = alltest();
        for(int i = 0 ; i < all.size(); i++){
            System.out.println("case: " + Integer.valueOf(i + 1) + "  " + t.sExpression(all.get(i)));
        }

    }

    private static List<String> alltest(){
        List<String> all = new ArrayList<>();
        String a1 = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
        String a2 = "(A,B) (A,C) (B,D) (D,C)";
        String a3 = "(A,B) (A,C) (B,D) (E,F) (F,G) (F,H)";
        String a4 = "(A,B) (B,D) (B,C) (C,A)";
        String a5 = "(A,B) (B,C) (A,B) (A,C)";
        String a6 = "(A,B) (A,C) (A,D) (B,E)";
        String a7 = "(Q,Z) (C,D) (B,P) (A,C) (Q,X) (B,Q) (A,B)";
        String a8 = "(A,B) (B,C) (A,B)";
        String a9 = "(A,C) (A,B) (B,Q) (B,P) (C,D) (Q,Z) (Q,X)";
        String a10 = "(A,B) (A,C) (B,P) (B,Q) (C,D) (Q,X) (Q,Z)";
        String a11 = "(A,B) (A,C) (B,E) (B,F)";
        String a12 = "(P,J) (X,T) (R,E) (P,C) (X,B) (R,X)";
        String a13 = "(Q,Z) (C,D) (B,P) (A,C) (Q,X) (A,C) (B,Q)";
        String a14 = "(X,Y) (R,D) (D,P) (R,A) (Y,R) (X,Z) (Z,T) (Z,B) (R,G)";
        String a15 = "(U,V) (V,W) (V,X) (U,Z) (V,Y)";
        String a16 = "(U,V) (V,W) (V,X) (U,Z)";
        String a17 = "(U,V) (U,W) (V,X) (V,Y) (W,Z)";
        String a18 = "(Y,V) (V,X) (Y,W) (W,A) (V,U) (W,Z)";
        String a19 = "(Y,V) (V,X) (W,A) (Y,W) (V,U) (W,Z)";
        String a20 = "(Y,V) (V,X) (W,A) (Y,W) (V,U) (W,Z) (V,X)";
        String a21 = "(D,N) (W,H) (G,I) (P,E) (B,P) (X,A) (Z,Y) (B,G) (P,Q) (G,F) (W,M) (Z,D) (X,Z) (A,W) (D,S) (A,B)";
        String a22 = "(A,C) (A,B) (B,Q) (B,P) (C,D) (A,B) (Q,X) (P,Z)";
        String a23 = "(P,Y) (G,B) (Y,G) (P,Z) (Y,H) (P,A)";
        String a24 = "(A,B) (A,C) (B,D) (B,E)";
        String a25 = "(P,B) (E,X) (P,D) (E,Y) (P,A)";

        all.add(a1);
        all.add(a2);
        all.add(a3);
        all.add(a4);
        all.add(a5);
        all.add(a6);
        all.add(a7);
        all.add(a8);
        all.add(a9);
        all.add(a10);
        all.add(a11);
        all.add(a12);
        all.add(a13);
        all.add(a14);
        all.add(a15);
        all.add(a16);
        all.add(a17);
        all.add(a18);
        all.add(a19);
        all.add(a20);
        all.add(a21);
        all.add(a22);
        all.add(a23);
        all.add(a24);
        all.add(a25);
        return all;
    }


//        /*
//        * e1:more than 2 child
//        * e2:more than one identical edge
//        * e3:tree would contain a cycle
//        * e4:more than one root node
//        * e5:all other error(e.g. invalid input)
//        * */


    //chk cycle
    private boolean chkE3(List<Edge> edges){
         int[] parent = new int[26];
         Arrays.fill(parent, -1);
         for(Edge e  : edges){
             if(union(e.st - 'A', e.ed - 'A', parent)){
                 return false;
             }
         }
         return true;
    }
    private boolean union(int a, int b, int[] parent){
        int roota = find(a, parent);
        int rootb = find(b, parent);
        if(roota == rootb){// two vertices of one edge  share the same ancenter
            return true;
        } else
            parent[roota] = rootb;
        return false;
    }
    private int find(int a, int[] parent) {
        if(parent[a] == -1){
            return a;
        }
        int root = find(parent[a], parent);
        parent[a] = root;
        return root;
    }

    public String sExpression(String nodes){
        if(nodes == null || nodes.length() == 0){
            return "E5";
        }
        //1.convert nodes into edge and put into map?
        String[] strs = nodes.split(" ");
        List<Edge> edges = new ArrayList<>();
        for(String s : strs){
            edges.add(convert(s));
        }

        //convert edge into graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Character> parent = new HashMap<>();// kid -> parent map
        int[] appear = new int[26];
        Arrays.fill(appear, -1);
        for(Edge e: edges){
            char st = e.st;
            char ed = e.ed;
            appear[st - 'A'] = 1;
            appear[ed - 'A'] = 1;
            if(!graph.containsKey(st)){
                graph.put(st, new HashSet<>());
            }
            if(!graph.get(st).add(ed)){//same pair
                return "E2";
            }
            if(graph.get(st).size() > 2){
                return "E1";
            }
            if(parent.containsKey(ed)){
                char tmp = parent.get(ed);
                if(tmp == st){//duplicate
                    return "E2";
                } else {//cycle
                    return "E3";
                }
            }
            parent.put(ed, st);
        }

        if(!chkE3(edges)){
            return "E3";
        }

        int count = 0;
        char root = ' ';
        for(char i = 'A'; i <= 'Z'; i++){
            if(appear[i - 'A'] != -1 && parent.get(i) == null){
                count++;
                root = i;
            }
        }
        if(count > 1){
            return "E4";
        }
        //System.out.println(graph);
        //build tree;
        TreeNode mytree = recur(graph, root);
        return getEx(mytree);
    }

    private TreeNode recur(Map<Character, Set<Character>> graph, char root){
        if(root == ' '){
            return null;
        }
        if(graph.get(root) == null){
            return new TreeNode(root);
        }
        Set<Character> cur = graph.get(root);
        List<Character> tmp = new ArrayList<>(cur);
        Collections.sort(tmp);
        TreeNode res = new TreeNode(root);
        char left = ' ';
        char right = ' ';
        if(tmp.size() == 0){
            return  res;
        } else if(tmp.size() >= 1){
            left = tmp.get(0);
        }
        if(tmp.size() == 2){
            right = tmp.get(1);
        }
        res.left = recur(graph, left);
        res.right = recur(graph, right);
        return res;
    }

    private String getEx(TreeNode root){
        if(root == null ){
            return "";//or null
        }
        String res = root.val + "";
        String left = "";
        left = getEx(root.left);
        String right = "";
        right = getEx(root.right);
        return "(" + res + left + right+ ")";
    }

    private Edge convert(String eg){
        //(Z,T)
        char st = ' ';
        char ed = ' ';
        for(int i = 0; i < eg.length(); i++){
            char cur = eg.charAt(i);
            if(cur > 'Z' || cur < 'A') continue;
            if(st == ' '){
                st = cur;
            } else {
                ed = cur;
            }
        }
        return new Edge(st, ed);
    }

    class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char v){
            val = v;
        }
    }

    class Edge{
        char st;
        char ed;
        public Edge(char s, char e){
            st = s;
            ed = e;
        }
    }
}
