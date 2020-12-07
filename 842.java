class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(res, S, 0, 0, 0);
        return res;
    }

    private boolean dfs(List<Integer> res, String s, int index, int sum, int prev) {
        if (index == s.length()) return res.size() >= 3;
        if (s.charAt(index) == '0') {
            if (res.size() >= 2 && sum != 0) return false;
            res.add(0);
            if (dfs(res, s, index+1, prev, 0)) return true;
            res.remove(res.size()-1);
            return false;
        }

        int curr = 0;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            curr = curr*10+c-'0';
            if (res.size() >= 2) {
                if (curr > sum) return false;
                else if (curr < sum) continue;
            }
            res.add(curr);
            if (dfs(res, s, i+1, curr+prev, curr)) return true;
            res.remove(res.size()-1);
        }
        return false;
    }
}