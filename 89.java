class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                res.add(res.get(size-1-j)+(1<<i));
            }
        }
        return res;
    }
}