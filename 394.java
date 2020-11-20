class Solution {
    public String decodeString(String s) {
        Stack<Integer> queue = new Stack<>();
        Stack<String> queueS = new Stack<>();
        String res = "";
        int n = 0;
        for (char c: s.toCharArray()) {
            if (c >= '0' && c <= '9') n = n*10+c-'0';
            else if (c == '[') {
                queue.push(n);
                n = 0;
                queueS.push(res);
                res = "";
            }
            else if (c >= 'a' && c <= 'z') res += c;
            else if (c == ']') {
                int m = queue.pop();
                String temp = "";
                while (m > 0) {
                    m--;
                    temp += res;
                }
                res = queueS.pop() + temp;
            }
        }
        return res;
    }
}