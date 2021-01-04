class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() < 3) return new ArrayList<>();
        char prev = s.charAt(0);
        int count = 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (prev == s.charAt(i)) {
                count++;
            } else {
                if (count >= 3) {
                    res.add(new ArrayList<>(Arrays.asList(i-count, i-1)));
                }
                count = 1;
                prev = s.charAt(i);
            }
        }
        if (count >= 3) res.add(new ArrayList<>(Arrays.asList(s.length()-count, s.length()-1)));
        return res;
    }
}