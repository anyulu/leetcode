class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(0, k-nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] temp = new int[k];
            int n = 0;
            int[] res1 = getStack(nums1, i);
            int[] res2 = getStack(nums2, k-i);
            int count = k, i1 = 0, i2 = 0;
            while (n < k) {
                if (i1 == i) while (i2 < k-i) temp[n++] = res2[i2++];
                else if (i2 == k-i) while (i1 < i) temp[n++] = res1[i1++];
                else if (res1[i1] > res2[i2]) temp[n++] = res1[i1++];
                else if (res1[i1] < res2[i2]) temp[n++] = res2[i2++];
                else {
                    int incre = 1;
                    while (true) {
                        if (i1+incre == i) {
                            temp[n++] = res2[i2++];
                            break;
                        }
                        if (i2+incre == k-i) {
                            temp[n++] = res1[i1++];
                            break;
                        }
                        if (res1[i1+incre] > res2[i2+incre]) {
                            temp[n++] = res1[i1++];
                            break;
                        }
                        if (res1[i1+incre] < res2[i2+incre]) {
                            temp[n++] = res2[i2++];
                            break;
                        }
                        incre++;
                    }
                }
            }
            for (int j = 0; j < k; j++) {
                if (res[j] < temp[j]) {
                    res = temp;
                    break;
                } else if (res[j] > temp[j]) break;
            }
        }
        return res;
    }

    private int[] getStack(int[] nums, int k) {
        if (k == 0) return new int[0];
        int[] res = new int[k];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i] &&
                stack.size()+nums.length-i > k) {
                stack.pop();
            }
            if (stack.size() < k) stack.push(nums[i]);
        }
        int i = k-1;
        while (i >= 0) {
            res[i--] = stack.pop();
        }
        return res;
    }
}