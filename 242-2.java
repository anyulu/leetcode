class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c: t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            if (map.get(c) == 1) map.remove(c);
            else map.put(c, map.get(c)-1);
        }
        if (map.isEmpty()) return true;
        return false;
    }
}