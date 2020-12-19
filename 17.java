class Solution {
    public List<String> letterCombinations(String digits) {
        Queue<String> queue = new LinkedList<>();
        for (char c: digits.toCharArray()) {
            if (queue.isEmpty()) {
                for (String s: getChar(c)) queue.offer(s);
                continue;
            }
            int n = queue.size();
            Set<String> set = getChar(c);
            while (n-- > 0) {
                String temp = queue.poll();
                for (String s: set) queue.offer(temp+s);
            }
        }
        return new ArrayList<>(queue);
    }

    private Set<String> getChar(char c) {
        switch(c)
        {
            case '2':
                return new HashSet<>(Arrays.asList("a", "b", "c"));
            case '3':
                return new HashSet<>(Arrays.asList("d", "e", "f"));
            case '4':
                return new HashSet<>(Arrays.asList("g", "h", "i"));
            case '5':
                return new HashSet<>(Arrays.asList("j", "k", "l"));
            case '6':
                return new HashSet<>(Arrays.asList("m", "n", "o"));
            case '7':
                return new HashSet<>(Arrays.asList("p", "q", "r", "s"));
            case '8':
                return new HashSet<>(Arrays.asList("t", "u", "v"));
            case '9':
                return new HashSet<>(Arrays.asList("w", "x", "y", "z"));
        }
        return null;
    }
}