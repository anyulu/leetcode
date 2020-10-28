class Solution {
    public boolean isHappy(int num) {
        int fast = num, slow = num;
        do {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        } while (fast != slow);
        return fast == 1;
    }

    private static int getNext(int num) {
        int sum = 0;
        int i;
        while (num > 0) {
            i = num % 10;
            sum += i*i;
            num /= 10;
        }
        return sum;
    }
}