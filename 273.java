class Solution {
    String[] s1 = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] s2 = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
        "Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] s3 = {"Twenty","Thirty","Forty","Fifty",
        "Sixty","Seventy","Eighty","Ninety"};


    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int n1 = num % 1000;
        num /= 1000;
        int n2 = num % 1000;
        num /= 1000;
        int n3 = num % 1000;
        num /= 1000;
        int n4 = num;
        StringBuilder res = new StringBuilder();
        if (n4 != 0) {
            res.append(helper(n4) + " Billion");
            if (n3 == 0 && n2 == 0 && n1 == 0) return res.toString();
            else res.append(" ");
        }
        if (n3 != 0) {
            res.append(helper(n3) + " Million");
            if (n2 == 0 && n1 == 0) return res.toString();
            else res.append(" ");
        }
        if (n2 != 0) {
            res.append(helper(n2) + " Thousand");
            if (n1 == 0) return res.toString();
            else res.append(" ");
        }
        if (n1 != 0) res.append(helper(n1));
        return res.toString();
    }

    private String helper(int num) {
        int n1 = num % 10;
        num /= 10;
        int n2 = num % 10;
        num /= 10;
        int n3 = num;
        StringBuilder res = new StringBuilder();
        if (n3 != 0) {
            res.append(s1[n3-1] + " Hundred");
            if (n2 != 0 || n1 != 0) res.append(" ");
            else return res.toString();
        }
        if (n2 == 1) {
            res.append(s2[n1]);
            return res.toString();
        }
        if (n2 > 1) {
            res.append(s3[n2-2]);
            if (n1 != 0) res.append(" ");
        }
        if (n1 != 0) res.append(s1[n1-1]);
        return res.toString();
    }
}