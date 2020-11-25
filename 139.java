class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i+1))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (wordDict.contains(s.substring(j+1, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}