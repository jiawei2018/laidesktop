package debug;

import java.util.*;

public class wordladder2 {
    private List<String> tolist(String[] strs) {
        List<String> res = new ArrayList<>();
        for(String s : strs) {
           res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        wordladder2 t = new wordladder2();
        String[] input = {"hot","dot","dog","lot","log","cog"};
        String bg = "hit";
        String ed = "cog";
        System.out.println(t.findLadders(bg, ed, t.tolist(input)));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>>  res = new ArrayList<>();
        if(wordList.size() == 0) {
            return res;
        }
        // build a parent map<kid, List<parent>>
        Map<String, List<String>> parent = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        Set<String> used = new HashSet<>();

        queue.offer(beginWord);
        boolean found = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] carr = cur.toCharArray();
                for(int j = 0; j < carr.length; j++) {
                    char tmp = carr[j];
                    for(char k = 'a'; k <= 'z'; k++) {
                        carr[j] = k;
                        String genstr = String.valueOf(carr);
                        if(!dict.contains(genstr)) continue;
                        if(used.add(genstr)) {
                            queue.offer(genstr);
                        }
                        if(!parent.containsKey(genstr)) {
                            parent.put(genstr, new ArrayList<>());
                        }
                        parent.get(genstr).add(cur);


                        if(genstr.equals(endWord)) {
                            // found the end!
                            found = true;
                        }

                    }//26 char for
                    carr[j] = tmp;//restore it
                }//every char in word
            }//level order
            if(found) {
                break;
            }
            dict.removeAll(used);//this is the bug ,use removeall(collection) NOT remove(obj)
            used.clear();

        }//while

        recur(res, parent, beginWord, endWord, new LinkedList<>());
        return res;
    }


    private void recur(List<List<String>>  res, Map<String, List<String>> parent,
                       String begin, String next, List<String> path) {//path use LinkedList
        if(next.equals(begin)) {
            path.add(0, next);
            res.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }
        List<String> list = parent.get(next);
        //System.out.println(list);
        path.add(0, next);
        if(list != null) {
            for(String str : list) {
                recur(res, parent, begin, str, path);
            }
        }
        path.remove(0);

    }
}
