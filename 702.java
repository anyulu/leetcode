/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int key) {
        int start = 0, end = 1;
        while (reader.get(end) < key) end *= 2;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (reader.get(mid) == key) return mid;
            else if (reader.get(mid) < key) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}