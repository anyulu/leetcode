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
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        Set<Integer> set = new TreeSet<>();
        for (int i: nums) {
            set.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i: set) {
            map.put(i, index++);
        }
        BIT bit = new BIT(set.size());
        int res = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            int j = map.get(nums[i]);
            bit.update(j);
            res += bit.get(j-1);
        }
        return res;
    }
}