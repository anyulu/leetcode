class Solution {
    public boolean search(int[] arr, int key) {
        if (arr.length == 0) return false;
        if (arr.length == 1) return arr[0] == key;
        int start = 0, end = arr.length-1, mid = 0;
        while (start <= end) {
            mid = start+(end-start)/2;
            if (arr[mid] == key) return true;
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                start++;
                end--;
                continue;
            }
            if (arr[mid] < key) {
                if (arr[mid] < arr[start] && key >= arr[start]) end = mid-1;
                else start = mid+1;
            } else {
                if (arr[mid] >= arr[start] && key < arr[start]) start = mid+1;
                else end = mid-1;
            }
        }
        return false;
    }
}