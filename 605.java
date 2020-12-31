class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if (n > m/2+1) return false;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) &&
                (i == m-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}