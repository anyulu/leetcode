class Solution {
    public int[] sortedSquares(int[] arr) {
        int[] squares = new int[arr.length];
        if (arr.length == 0) return squares;
        int start = 0;
        int end = arr.length-1;
        int count = end;
        while (start <= end) {
            int s = arr[start] * arr[start];
            int e = arr[end] * arr[end];
            if (s >= e) {
                start++;
                squares[count--] = s;
            }
            else {
                squares[count--] = e;
                end--;
            }
        }
        return squares;
    }
}

