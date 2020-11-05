class Solution {
    public char nextGreatestLetter(char[] letters, char key) {
        if (letters[0] > key || letters[letters.length-1] < key || letters[letters.length-1] == key)
            return letters[0];
        int start = 0, end = letters.length, mid = 0;
        while (start <= end) {
            mid = (start+end)/2;
            if (letters[mid] > key) end = mid-1;
            else start = mid+1;
        }
        return letters[start];
    }
}