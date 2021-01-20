class UnionFind {
    int[] parent;
    int count;

    public UnionFind(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i <  n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        parent[py] = px;
        count--;
        return true;
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        List<List<Integer>> res = new ArrayList<>();
        int value = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, (a,b) -> a[2]-b[2]);
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        UnionFind actual = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            if (actual.union(newEdges[i][0], newEdges[i][1])) {
                value += newEdges[i][2];
            }
        }

        for (int i = 0; i < m; i++) {
            UnionFind curr = new UnionFind(n);
            int currValue = 0;
            for (int j = 0; j < m; j++) {
                if (j != i && curr.union(newEdges[j][0], newEdges[j][1])) {
                    currValue += newEdges[j][2];
                }
            }
            if (curr.count != 1 || currValue > value) {
                res.get(0).add(newEdges[i][3]);
                continue;
            }

            curr = new UnionFind(n);
            curr.union(newEdges[i][0], newEdges[i][1]);
            currValue = newEdges[i][2];
            for (int j = 0; j < m; ++j) {
                if (i != j && curr.union(newEdges[j][0], newEdges[j][1])) {
                    currValue += newEdges[j][2];
                }
            }
            if (currValue == value) {
                res.get(1).add(newEdges[i][3]);
            }
        }
        return res;
    }
}