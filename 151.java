class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        boolean space = true;
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                if (!space) {
                    space = true;
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
            } else {
                space = false;
                sb.append(c);
            }
        }
        stack.push(sb.toString());
        while (!stack.isEmpty()) {
            if (stack.peek().length() == 0) {
                stack.pop();
                continue;
            }
            res.append(stack.pop());
            res.append(' ');
        }
        res.setLength(res.length()-1);
        return res.toString();
    }
}