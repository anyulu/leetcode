class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        while (numRows-- > 0) {
            if (prev.size() < 2) {
                prev.add(1);
                res.add(new ArrayList<>(prev));
                continue;
            }
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int i = 1; i < prev.size(); i++) {
                curr.add(prev.get(i)+prev.get(i-1));
            }
            curr.add(1);
            res.add(new ArrayList<>(curr));
            prev = curr;
        }
        return res;
    }
}