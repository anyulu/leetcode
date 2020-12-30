class BIT {
    int[] res;
    int n;

    public BIT(int n) {
        this.n = n;
        this.res = new int[n+1];
    }

    public int lowbit(int k) {
        return k&(-k);
    }

    public void update(int k) {
        while (k <= n) {
            res[k]++;
            k += lowbit(k);
        }
    }

    public int get(int k) {
        int count = 0;
        while (k > 0) {
            count += res[k];
            k -= lowbit(k);
        }
        return count;
    }
}

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int res = 0;
        long sum = 0;
        long[] preSum = new long[n];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        Set<Long> set = new TreeSet<>();
        set.add((long) 0);
        Map<Long, Integer> map = new HashMap<>();
        int index = 1;
        for (long i: preSum) {
            set.add(i);
            set.add(i-lower);
            set.add(i-upper);
        }
        for (long i: set) {
            map.put(i, index++);
        }

        BIT bit = new BIT(map.size());
        bit.update(map.get((long) 0));
        for (int i = 0; i < n; i++) {
            int l = map.get(preSum[i]-upper);
            int r = map.get(preSum[i]-lower);
            res += bit.get(r)-bit.get(l-1);
            bit.update(map.get(preSum[i]));
        }
        return res;
    }
}