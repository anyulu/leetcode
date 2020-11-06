class Solution {
    public int findMin(int[] arr) {
        int start = 0, end = arr.length-1;
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (arr[mid] < arr[0]) end = mid-1;
            else start = mid+1;
        }
        return arr[(end+1) % arr.length];
    }
}