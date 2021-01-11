class Solution {
    public String minNumber(int[] nums) {
        String[] temp = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(temp, (a,b) -> (a+b).compareTo(b+a));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            res.append(temp[i]);
        }
        return res.toString();
    }
}