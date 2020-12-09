class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] bill = new int[3];
        for (int n: bills) {
            if (n == 5) bill[0]++;
            else if (n == 10) {
                if (bill[0] == 0) return false;
                bill[0]--;
                bill[1]++;
            }
            else if (n == 20) {
                if (bill[0] == 0) return false;
                if (bill[1] == 0) {
                    if (bill[0] >= 3) bill[0] -= 3;
                    else return false;
                }
                else {
                    bill[1]--;
                    bill[0]--;
                }
                bill[2]++;
            }
        }
        return true;
    }
}