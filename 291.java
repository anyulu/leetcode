class Solution {
    Map<Character, String> map = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String s) {
        if (pattern.length() == 0 && s.length() == 0) return true;
        if (pattern.length() == 0 || s.length() == 0) return false;
        char p = pattern.charAt(0);
        for (int i = 1; i <= s.length()-pattern.length()+1; i++) {
            String currS = s.substring(0, i);
            String currMap = map.get(p);
            if (currMap == null && map.containsValue(currS)) continue;
            if (currMap != null && !currS.equals(currMap)) continue;
            map.put(p, currS);
            if (wordPatternMatch(pattern.substring(1), s.substring(i))) return true;
            if (currMap == null) map.remove(p);
        }
        return false;
    }
}