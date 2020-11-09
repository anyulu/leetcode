class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        StringBuilder res = new StringBuilder();
        queue.addAll(map.entrySet());
        Map.Entry<Character, Integer> prev = null;
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> curr = queue.poll();
            if (prev != null && prev.getValue() > 0) queue.add(prev);
            res.append(curr.getKey());
            curr.setValue(curr.getValue()-1);
            prev = curr;
        }
        if (res.length() != S.length()) return "";
        return res.toString();
    }
}