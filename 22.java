class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result, new String(), 0, 0, n);
        return result;
    }

    private void dfs(List<String> result, String s, int left, int right, int num) {
        if (left == num) {
            while (right++ < num) s += ")";
            result.add(s);
            return;
        }
        String s1 = s+"(";
        String s2 = s+")";
        if (left == right) dfs(result, s1, left+1, right, num);
        else {
            dfs(result, s1, left+1, right, num);
            dfs(result, s2, left, right+1, num);
        }
    }
}