class Solution {
    public int calculate(String s) {
        int res = 0;
        int temp = 0;
        char op = '+';
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                temp = c-'0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    i++;
                    temp = temp*10+s.charAt(i)-'0';
                }
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
                if (op == '+') stack.push(temp);
                else if (op == '-') stack.push(-temp);
                else if (op == '*') stack.push(stack.pop()*temp);
                else if (op == '/') stack.push(stack.pop()/temp);
                temp = 0;
                op = c;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}