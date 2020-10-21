class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean ifPalin[][] = new boolean[n][n];
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                ifPalin[i][j] = s.charAt(i) == s.charAt(j) &&
                    (i-j < 3 || ifPalin[i-1][j+1]);
                if (ifPalin[i][j] && i-j+1 > res.length()) {
                    res = s.substring(j,i+1);
                }
            }
        }
        return res;
    }
}