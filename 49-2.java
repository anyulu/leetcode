class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            boolean exist = false;
            for (String key: map.keySet()) {
                if (isAnagram(str, key)) {
                    map.get(key).add(str);
                    exist = true;
                    break;
                }
            }
            if (!exist) map.computeIfAbsent(str, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int[] count = new int[26];
        for (char c: str1.toCharArray()) count[c-'a']++;
        for (char c: str2.toCharArray()) {
            count[c-'a']--;
            if (count[c-'a'] < 0) return false;
        }
        return true;
    }
}