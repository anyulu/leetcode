class Edge {
    String start;
    String end;
    double val;

    public Edge(String start, String end, double val) {
        this.start = start;
        this.end = end;
        this.val = val;
    }
}

class Solution {
    Map<String, List<Edge>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < values.length; i++) {
            List<String> temp = equations.get(i);
            String start = temp.get(0);
            String end = temp.get(1);
            map.computeIfAbsent(start, k -> new ArrayList<>())
                .add(new Edge(start, end, values[i]));
            map.computeIfAbsent(end, k -> new ArrayList<>())
                .add(new Edge(end, start, 1/values[i]));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> temp = queries.get(i);
            res[i] = dfs(temp.get(0), temp.get(1), new ArrayList<>());
        }
        return res;
    }

    private double dfs(String start, String end, List<String> visit) {
        if (!map.containsKey(start)) return -1;
        if (start.equals(end)) return 1;

        visit.add(start);
        List<Edge> edges = map.get(start);
        for (Edge edge: edges) {
            if (visit.contains(edge.end)) continue;
            double temp = dfs(edge.end, end, visit);
            if (temp != -1) return edge.val*temp;
        }
        return -1;
    }
}