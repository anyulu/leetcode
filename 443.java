class Solution {
    public int compress(char[] chars) {
        char currChar = chars[0];
        int count = 1;
        int currWrite = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != currChar) {
                currChar = chars[i];
                if (count != 1) {
                    String temp = Integer.toString(count);
                    for (int j = 0; j < temp.length(); j++) {
                        chars[currWrite+j] = temp.charAt(j);
                    }
                    currWrite += temp.length();
                    count = 1;
                }
                chars[currWrite++] = currChar;
                continue;
            } else count++;
            if (i == chars.length-1) {
                String temp = Integer.toString(count);
                for (int j = 0; j < temp.length(); j++) {
                    chars[currWrite+j] = temp.charAt(j);
                }
                currWrite += temp.length();
            }
        }
        return currWrite;
    }
}