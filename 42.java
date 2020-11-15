class Solution {
    public int trap(int[] height) {
        int right = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curr = stack.pop();
                if (stack.isEmpty()) break;
                int l = i-stack.peek()-1;
                int h = Math.min(height[i], height[stack.peek()]) - height[curr];
                res += l*h;
            }
            stack.push(i);
        }
        return res;
    }
}