class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // {effort, x, y}

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0], x = curr[1], y = curr[2];

            if (x == m - 1 && y == n - 1) return effort;

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int nextEffort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (nextEffort < dist[nx][ny]) {
                        dist[nx][ny] = nextEffort;
                        pq.offer(new int[]{nextEffort, nx, ny});
                    }
                }
            }
        }

        return 0;
    }
}