class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (right > left) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }
}