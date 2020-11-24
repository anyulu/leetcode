class Solution {
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (char c: chars) {
            count[c-'a']++;
        }
        StringBuilder res = new StringBuilder();
        while (res.length() != s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    res.append((char)(i+'a'));
                    count[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i] != 0) {
                    res.append((char)(i+'a'));
                    count[i]--;
                }
            }
        }
        return res.toString();
    }
}