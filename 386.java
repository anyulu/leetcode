class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        for (int i = 1; i <= 9; i++) {
            dfs(res, i, n);
        }
        return res;
    }

    private void dfs(List<Integer> res, int i, int n) {
        if (i > n) return;
        res.add(i);
        i *= 10;
        for (int j = 0; j <= 9; j++) {
            dfs(res, i+j, n);
        }
    }
}