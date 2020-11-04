class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Queue<Integer> minCapital = new PriorityQueue<>((i,j) -> Capital[i]-Capital[j]);
        Queue<Integer> maxProfit = new PriorityQueue<>((i,j) -> Profits[j]-Profits[i]);
        int curr = W;
        for (int i = 0; i < Profits.length; ++i) {
            minCapital.add(i);
        }
        for (int i = 0; i < k; ++i) {
            while (!minCapital.isEmpty() && Capital[minCapital.peek()] <= curr) {
                maxProfit.add(minCapital.poll());
            }
            if (maxProfit.isEmpty()) break;
            curr += Profits[maxProfit.poll()];
        }
        return curr;
    }
}