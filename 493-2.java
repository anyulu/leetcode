class Bit {
    double[] res;
    int n;

    public Bit(int n) {
        this.n = n;
        this.res = new double[n+1];
    }

    public int lowbit(int i) {
        return i&(-i);
    }

    public void update(int i) {
        while (i <= n) {
            res[i]++;
            i += lowbit(i);
        }
    }

    public int sum(int i) {
        int temp = 0;
        while (i > 0) {
            temp += res[i];
            i -= lowbit(i);
        }
        return temp;
    }
}

class Solution {
    public int reversePairs(int[] nums) {
        Set<Double> set = new TreeSet<>();
        for (int i: nums) {
            set.add((double)i);
            set.add((double)2*i);
        }
        Map<Double, Integer> map = new HashMap<>();
        int index = 1;
        for (double i: set) map.put(i, index++);

        int res = 0;
        int n = map.size();
        Bit bit = new Bit(n);
        for (int i = 0; i < nums.length; i++) {
            index = map.get((double) nums[i]*2);
            res += bit.sum(n)-bit.sum(index);
            bit.update(map.get((double) nums[i]));
        }
        return res;
    }
}