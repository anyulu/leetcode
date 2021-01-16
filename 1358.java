class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] count = new int[3];
        int rec = 0;
        int n = s.length();
        int start = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (count[c-'a'] == 0) rec++;
            count[c-'a']++;
            if (rec < 3) continue;
            while (rec == 3) {
                res += n-i;
                if (count[s.charAt(start)-'a'] == 1) rec--;
                count[s.charAt(start)-'a']--;
                start++;
            }
        }
        return res;
    }
}