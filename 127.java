class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        int count = 1;
        queue.add(beginWord);
        boolean[] visit = new boolean[wordList.size()];
        while (queue.size() != 0) {
            count += 1;
            int n = queue.size();
            for (int j = 0; j < n; j ++) {
                String str = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (!visit[i] && trans(str, wordList.get(i))) {
                        if (wordList.get(i).equals(endWord)) return count;
                        visit[i] = true;
                        queue.add(wordList.get(i));
                    }
                }
            }
        }
        return 0;
    }

    private boolean trans(String str1, String str2) {
        int res = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) res += 1;
        }
        return res == 1;
    }
}