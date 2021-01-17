class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        Map<Character, Queue<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<>());
        }

        for (String word: words) {
            map.get(word.charAt(0)).offer(word);
        }

        for (char c: S.toCharArray()) {
            Queue<String> queue = map.get(c);
            int n = queue.size();
            while (n-- > 0) {
                String s = queue.poll();
                if (s.length() == 1) res++;
                else map.get(s.charAt(1)).offer(s.substring(1));
            }
        }
        return res;
    }
}