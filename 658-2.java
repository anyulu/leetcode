class Solution {
    public List<Integer> findClosestElements(int[] arr, int K, int X) {
        List<Integer> result = new ArrayList<>();
        // TODO: Write your code here
        if (arr.length <= K) return Arrays.stream(arr).boxed().collect(Collectors.toList());
        Queue<Integer> queue = new PriorityQueue<>((a,b)-> Math.abs(b-X)-Math.abs(a-X));
        for (int i = 0; i < K; i++) {
            queue.add(arr[i]);
        }
        for (int i = K; i < arr.length; i++) {
            if (Math.abs(arr[i]-X) < Math.abs(queue.peek()-X)) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        Queue<Integer> order = new PriorityQueue<>();
        while (!queue.isEmpty()) order.add(queue.poll());
        while (!order.isEmpty()) result.add(order.poll());
        return result;
    }
}