class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            }
            else if (c == '{')  stack.push(c);
            else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') return false;
                else stack.pop();
            }
            else if (c == '[')  stack.push(c);
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}