class Solution {
    public int calculate(String s) {
        int sign = 1;
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int curr = c-'0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    curr = curr*10+s.charAt(i+1)-'0';
                    i++;
                }
                res = res+sign*curr;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (c == ')') {
                res = stack.pop()*res+stack.pop();
            }
        }
        return res;
    }
}