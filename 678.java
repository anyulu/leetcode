class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deque1.addLast(i);
            } else if (c == '*') {
                deque2.addLast(i);
            } else {
                if (!deque1.isEmpty()) {
                    deque1.pollLast();
                    continue;
                }
                if (!deque2.isEmpty()) {
                    deque2.pollLast();
                    continue;
                }
                return false;
            }
        }
        if (deque1.size() > deque2.size()) return false;
        while (!deque1.isEmpty()) {
            if (deque1.peekLast() > deque2.peekLast()) return false;
            deque1.pollLast();
            deque2.pollLast();
        }
        return true;
    }
}