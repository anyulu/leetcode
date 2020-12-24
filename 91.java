class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (i == 0) return 0;
                if (prev == '1' || prev == '2') {
                    dp[i+1] = dp[i-1];
                    prev = c;
                    continue;
                } else {
                    return 0;
                }
            }
            if (prev == '1') {
                dp[i+1] = dp[i]+dp[i-1];
            } else if (prev == '2') {
                dp[i+1] = c <= '6' ? dp[i]+dp[i-1] : dp[i];
            } else {
                dp[i+1] = dp[i];
            }
            prev = c;
        }
        return dp[s.length()];
    }
}