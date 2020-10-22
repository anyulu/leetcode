class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            boolean temp = false;
            for (String t: map.keySet()) {
                if (ifAnagram(s,t)) {
                    temp = true;
                    map.get(t).add(s);
                    break;
                }
            }
            if (!temp) map.put(s, new ArrayList<String>(Arrays.asList(s)));
        }
        return new ArrayList<>(map.values());
    }

    public boolean ifAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }
}