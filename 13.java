class Solution {
    public int romanToInt(String s) {
        char prev = ' ';
        int res = 0;
        for (char c: s.toCharArray()) {
            if (c == 'I') {
                res++;
            } else if (c == 'V') {
                res += 5;
                if (prev == 'I') res -=2;
            } else if (c == 'X') {
                res += 10;
                if (prev == 'I') res -=2;
            } else if (c == 'L') {
                res += 50;
                if (prev == 'X') res -= 20;
            } else if (c == 'C') {
                res += 100;
                if (prev == 'X') res -= 20;
            } else if (c == 'D') {
                res += 500;
                if (prev == 'C') res -= 200;
            } else {
                res += 1000;
                if (prev == 'C') res -= 200;
            }
            prev = c;
        }
        return res;
    }
}