class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (pattern.length() != ss.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                for (String temp: map.values()) {
                    if (temp.equals(ss[i])) return false;
                }
                map.put(c, ss[i]);
            }
            else if (!map.get(c).equals(ss[i])) return false;
        }
        return true;
    }
}