class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        int left = 0;
        int right = s.length()-1;
        while (right > left) {
            int i = check(s.charAt(left));
            int j = check(s.charAt(right));
            if (i == -11) {
                left++;
            } else if (j == -11) {
                right--;
            } else if (i != j) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private int check(char c) {
        if (c >= 'a' && c <= 'z') return c-'a';
        if (c >= 'A' && c <= 'Z') return c-'A';
        if (c >= '0' && c <= '9') return '0'-c-1;
        return -11;
    }
}