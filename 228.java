class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]+1) {
                end = nums[i];
            } else {
                addToRes(res, start, end);
                start = end = nums[i];
            }
        }
        addToRes(res, start, end);
        return res;
    }

    private void addToRes(List<String> res, int start, int end) {
        if (start == end) {
            res.add(String.valueOf(start));
        } else {
            res.add(start+"->"+end);
        }
    }
}