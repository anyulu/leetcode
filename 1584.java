class Edge {
    int point1;
    int point2;
    int len;

    public Edge(int point1, int point2, int len) {
        this.point1 = point1;
        this.point2 = point2;
        this.len = len;
    }
}

class Solution {
    int[] parent;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n < 2) return 0;
        Set<Integer> set = new HashSet<>();
        Queue<Edge> queue = new PriorityQueue<>((a,b) -> a.len-b.len);
        int res = 0;
        int count = n-1;
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dist = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                queue.offer(new Edge(i, j, dist));
            }
        }

        while (count > 0) {
            Edge curr = queue.poll();
            if (find(curr.point1) == find(curr.point2)) continue;
            res += curr.len;
            set.add(curr.point1);
            set.add(curr.point2);
            union(curr.point1, curr.point2);
            count--;
        }
        return res;
    }

    private int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[px] = py;
        }
    }
}