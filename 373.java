class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        k = Math.min(k, nums1.length*nums2.length);
        if (k == 0) return result;
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{i,0});
        }
        while (k > 0) {
            int[] index = queue.poll();
            result.add(new ArrayList<>(Arrays.asList(nums1[index[0]], nums2[index[1]])));
            k--;
            if (index[1]+1 < nums2.length) queue.add(new int[]{index[0], index[1]+1});
        }
        return result;
    }
}