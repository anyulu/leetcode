class Solution {
    public int findUnsortedSubarray(int[] arr) {
        if (arr.length <= 1) return 0;
        int end = -1;
        int start = 0;
        int min = arr[0], max = arr[arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) end = i;
            else min = arr[i];
            if (arr[arr.length-1-i] > max) start = arr.length-1-i;
            else max = arr[arr.length-1-i];
        }

        return end-start+1;
    }
}