class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = gas[i]-cost[i];
        }
        for (int i = 0; i < diff.length; i++) {
            int temp = diff[i];
            int start = i;
            while (temp >= 0) {
                start = (start+1) % diff.length;
                temp += diff[start];
                if (start == i) return i;
            }
        }
        return -1;
    }
}