class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int max = 0;
        int prev = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.size() > 1) {
                    int temp = stack.pop();
                    max = Math.max(max, i-stack.peek());
                } else {
                    stack.pop();
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        return max;
    }
}