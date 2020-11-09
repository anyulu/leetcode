class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        queue.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> kQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> curr = queue.poll();
            res.append(curr.getKey());
            curr.setValue(curr.getValue()-1);
            kQueue.add(curr);
            if (kQueue.size() == k) {
                Map.Entry<Character, Integer> temp = kQueue.poll();
                if (temp.getValue() > 0) queue.add(temp);
            }
        }
        if (res.length() != s.length()) return "";
        return res.toString();
    }
}