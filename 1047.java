class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}