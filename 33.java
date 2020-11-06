class Solution {
    public int search(int[] arr, int key) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0] == key ? 0 : -1;
        int start = 0, end = arr.length-1, mid = 0;
        while (start <= end) {
            mid = start+(end-start)/2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) {
                if (arr[mid] < arr[0] && key >= arr[0]) end = mid-1;
                else start = mid+1;
            } else {
                if (arr[mid] >= arr[0] && key < arr[0]) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }
}