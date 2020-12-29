class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new String(), 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String s, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            dfs(res, s+"(", left+1, right, n);
        }
        if (right < left) {
            dfs(res, s+")", left, right+1, n);
        }
    }
}