class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) return addStrings(num2, num1);
        boolean flag = false;
        Deque<Character> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        for (int i = 0; i < m; i++) {
            char c1 = num1.charAt(m-1-i);
            char c2 = num2.charAt(n-1-i);
            int temp = flag ? c1-'0'+c2-'0'+1 : c1-'0'+c2-'0';
            flag = false;
            if (temp >= 10) {
                temp -= 10;
                flag = true;
            }
            stack.push((char) (temp+'0'));
        }
        for (int i = n-m-1; i >= 0; i--) {
            int temp = flag ? num2.charAt(i)-'0'+1 : num2.charAt(i)-'0';
            flag = false;
            if (temp >= 10) {
                temp -= 10;
                flag = true;
            }
            stack.push((char) (temp+'0'));
        }
        if (flag) stack.push('1');
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }
}