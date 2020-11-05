class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = new ArrayList<>(diffWaysToCompute(input.substring(0,i)));
                List<Integer> right = new ArrayList<>(diffWaysToCompute(input.substring(i+1)));
                for (int l: left) {
                    for (int r: right) {
                        switch (c) {
                            case '+':
                                result.add(l+r);
                                break;
                            case '-':
                                result.add(l-r);
                                break;
                            case '*':
                                result.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        return result;
    }
}