class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n <= 0) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i-1) * numTrees(n-i);
        }
        map.put(n, sum);
        return sum;
    }
}