class Solution {
    public int dayOfYear(String date) {
        String[] dates = date.split("-");
        int year = parse(dates[0]);
        int month = parse(dates[1]);
        int day = parse(dates[2]);
        int res = day;
        for (int i = 1; i < month; i++) {
            res += calculate(year, i);
        }
        return res;
    }

    private int parse(String s) {
        int res = 0;
        for (char c: s.toCharArray())
            res = res*10+c-'0';
        return res;
    }

    private int calculate(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) return 31;
        else if (month == 2) {
            if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) return 29;
            else return 28;
        }
        return 30;
    }
}