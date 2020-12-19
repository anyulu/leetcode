class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        int[] count = new int[26];
        boolean[] exist = new boolean[26];
        for (char c: s.toCharArray()) count[c-'a']++;
        for (char c: s.toCharArray()) {
            if (!exist[c-'a']) {
                while (res.length() > 0 && res.charAt(res.length()-1) > c) {
                    if (count[res.charAt(res.length()-1)-'a'] > 0) {
                        exist[res.charAt(res.length()-1)-'a'] = false;
                        res.deleteCharAt(res.length()-1);
                    } else break;
                }
                res.append(c);
                exist[c-'a'] = true;
            }
            count[c-'a']--;
        }
        return res.toString();
    }
}