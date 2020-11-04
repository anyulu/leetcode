class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        dfs(result, word, 0, new String(), 0);
        return result;
    }

    private static void dfs(List<String> result, String word, int index, String s, int num) {
        if (index == word.length()) {
            result.add(s);
            return;
        }
        if (num != 0) {
            int temp = s.length()-1;
            while (temp >= 0 && Character.isDigit(s.charAt(temp))) temp--;
            dfs(result, word, index+1, s.substring(0,temp+1)+(num+1), num+1);
            dfs(result, word, index+1, s+word.charAt(index), 0);
        } else {
            dfs(result, word, index+1, s+word.charAt(index), 0);
            dfs(result, word, index+1, s+"1", 1);
        }
    }
}