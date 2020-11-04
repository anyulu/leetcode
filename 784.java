class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> permutations = new ArrayList<>();
        dfs(permutations, S, new String(), 0);
        return permutations;
    }

    private void dfs(List<String> permutations, String str, String s, int index) {
        if (s.length() == str.length()) {
            permutations.add(s);
            return;
        }
        char c = str.charAt(index);
        if (!Character.isLetter(c)) {
            s += c;
            dfs(permutations, str, s, index+1);
        } else {
            String s1 = s + Character.toUpperCase(c);
            String s2 = s + Character.toLowerCase(c);
            dfs(permutations, str, s1, index+1);
            dfs(permutations, str, s2, index+1);
        }
    }
}