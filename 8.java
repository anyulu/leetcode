class Solution {
    public int myAtoi(String s) {
        double i = 0;
        boolean pos = true;
        boolean sign = false;
        for (char cha: s.toCharArray()) {
            if (cha == ' ' && !sign) continue;
            if (cha == '-' && !sign) {
                pos = false;
                sign = true;
                continue;
            } else if ( cha == '+' && !sign) {
                sign = true;
                continue;
            }
            if (cha >= '0' && cha <= '9') {
                i = i*10 + cha - '0';
                sign = true;
            } else break;
        }
        if (!pos) return (int)-i;
        return (int)i;
    }
}