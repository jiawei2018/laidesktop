package jw2021.leet03.tpsort;

import java.util.*;

public class alienDict {

    public static void main(String[] args) {
        String[] st = {"abc", "ab"};
        alienDict t = new alienDict();
        System.out.println(t.alienOrder(st));

    }


    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int j = 0; j < cur.length(); j++) {
                char c1 = cur.charAt(j);
                if (indegree[c1 - 'a'] == -1) {
                    count++;
                    indegree[c1 - 'a'] = 0;
                }
            }
        }

        Map<Character, Set<Character>> map = new HashMap<>();
        buildMap(map, words, indegree);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        //System.out.println(queue.size());
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            char node = (char) (queue.poll() + 'a');
            res.append(node);
            Set<Character> curset = map.get(node);
            if (curset != null) {
                for (char c : curset) {
                    indegree[c - 'a']--;
                    if (indegree[c - 'a'] == 0) {
                        queue.offer(c - 'a');
                    }
                }
            }
        }
        if (res.length() != count) {
            return "";
        }
        return res.toString();
    }

//    出现两个bug,一是如果已经存在入度pair<a->b>当再次遇到这个时候就不能再对b的入度++了,
//    二是当每次找到了一个入度pair<a->b>时候就不应该再往后面找了,因为后面的顺序已经和这连个单词的排序无关了,


    private void buildMap(Map<Character, Set<Character>> map, String[] words, int[] indegree) {
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    // System.out.println(c1 + "  " + c2);
                    if (!map.containsKey(c1)) {
                        map.put(c1, new HashSet<>());
                    }
                    //notice here
                    boolean flag = map.get(c1).add(c2);//已经村的关系再次出现是不可以重复增加入度的;//mean means if there already have the relation before we cannot increase the indegree for this character
                    // System.out.println(c1 + "  " + c2 +"   " + flag);
                    indegree[c2 - 'a'] += flag ? 1 : 0;
                    //notice here !!!!!!!
                    break;//找到了就必须要break,否则后面的错误顺序就会加入结果
                }
            }
        }
    }

}
