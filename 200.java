class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                count++;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    int x = point[0], y = point[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                        grid[x][y] = '0';
                        queue.add(new int[]{x-1, y});
                        queue.add(new int[]{x+1, y});
                        queue.add(new int[]{x, y-1});
                        queue.add(new int[]{x, y+1});
                    }
                }
            }
        }
        return count;
    }
}