class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length <= 2) return tree.length;
        int count = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < tree.length; end++) {
            count++;
            map.put(tree[end], map.getOrDefault(tree[end],0)+1);
            while (map.size() > 2) {
                map.put(tree[start], map.get(tree[start])-1);
                if (map.get(tree[start]) == 0) {
                    map.remove(tree[start]);
                }
                count--;
                start++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}