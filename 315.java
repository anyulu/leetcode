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
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        BIT bit = new BIT(n);
        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int num: nums) {
            set.add(num);
        }
        for (int num: set) {
            map.put(num, index++);
        }

        for (int i = n-1; i >= 0; i--) {
            index = map.get(nums[i]);
            bit.update(index);
            stack.push(bit.get(index-1));
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}