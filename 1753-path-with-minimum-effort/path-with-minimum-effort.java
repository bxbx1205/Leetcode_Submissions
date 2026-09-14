class Solution {
    public int minimumEffortPath(int[][] heights) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int n = heights.length;
        int m = heights[0].length;

        int max = Integer.MAX_VALUE;
        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = max;
            }
        }

        pq.offer(new int[]{0, 0, 0});
        distance[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentDist = current[0];
            int row = current[1];
            int col = current[2];

            if (row == n - 1 && col == m - 1) {
                return currentDist;
            }

            for (int i = 0; i < 4; i++) {

                int newr = row + dr[i];
                int newc = col + dc[i];

                if (newr >= 0 && newr < n &&
                    newc >= 0 && newc < m) {

                    int difference = Math.abs(
                        heights[row][col] - heights[newr][newc]
                    );

                    int newEffort = Math.max(
                        currentDist,
                        difference
                    );

                    if (newEffort < distance[newr][newc]) {

                        distance[newr][newc] = newEffort;

                        pq.offer(new int[]{
                            newEffort,
                            newr,
                            newc
                        });
                    }
                }
            }
        }

        return 0;
    }
}