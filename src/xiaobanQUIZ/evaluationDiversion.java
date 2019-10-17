package xiaobanQUIZ;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;

import java.util.*;

public class evaluationDiversion {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] str = equations[i];
            if (!map.containsKey(str[0])) {
                map.put(str[0], new ArrayList<>());
            }
            map.get(str[0]).add(new Pair(str[1], values[i]));

            if (!map.containsKey(str[1])) {
                map.put(str[1], new ArrayList<>());
            }
            map.get(str[1]).add(new Pair(str[0], 1 / values[i]));
        }

        double[] res = new double[queries.length];

        for (int i = 0; i < res.length; i++) {
            String[] cur = queries[i];
            String first = cur[0];
            String second = cur[1];
            res[i] = recur(first, second, 1.0, map, new HashSet<String>());
        }
        return res;
    }

    private double recur(String first, String second, double value, Map<String, List<Pair>> map, Set<String> used) {
        if (!map.containsKey(first) || used.contains(first)) {
            return -1.0;
        }
        if (first.equals(second)) {
            return value;
        }

        List<Pair> cur = map.get(first);

        for (Pair p : cur) {
            used.add(first);
            double curdiv = recur(p.second, second, value * p.value, map, used);
            if (curdiv != -1.0) {
                return curdiv;
            }
            used.remove(first);
        }

        return -1.0;
    }

    class Pair {
        String second;
        double value;

        public Pair(String second, double value) {
            this.second = second;
            this.value = value;
        }
    }

}
