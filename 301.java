class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int n1 = 0;
        int n2 = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') n1++;
            else if (c == ')') {
                if (n1 > 0) n1--;
                else n2++;
            }
        }
        dfs(res, s, 0, new String(), n1, n2, 0);
        HashSet<String> set = new HashSet<>();
        set.addAll(res);
        return new ArrayList<>(set);
    }

    private void dfs(List<String> res, String s, int index, String temp, int left, int right, int count) {
        if (index == s.length()) {
            if (count == 0 && left == 0 && right == 0) res.add(temp);
            return;
        }

        if (s.charAt(index) == '(') {
            if (left > 0) dfs(res, s, index+1, temp, left-1, right, count);
            dfs(res, s, index+1, temp+"(", left, right, count+1);
        }
        else if (s.charAt(index) == ')') {
            if (right > 0) dfs(res, s, index+1, temp, left, right-1, count);
            if (count >= 1) dfs(res, s, index+1, temp+")", left, right, count-1);
        } else dfs(res, s, index+1, temp+s.charAt(index), left, right, count);
    }
}