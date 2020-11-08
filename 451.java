class Solution {
    public String frequencySort(String str) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }
        String res = "";
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            int size = entry.getValue();
            while (size > 0) {
                size --;
                res += entry.getKey();
            }
        }
        return res;
    }
}