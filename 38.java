class Solution {
    public String countAndSay(int n) {
        String res = "1";
        String tempRes = "";
        for (int i = 0; i < n-1; i++) {
            tempRes = "";
            int count = 0;
            char currChar = res.charAt(0);
            for (int j = 0; j < res.length(); j++) {
                if (currChar == res.charAt(j)) count += 1;
                else {
                    tempRes += count + "" + currChar;
                    currChar = res.charAt(j);
                    count = 1;
                }
            }
            tempRes += count + "" + currChar;
            res = tempRes;
        }
        return res;
    }
}