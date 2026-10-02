class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][]safeDist = new int[n][m];

        for (int[] arr : safeDist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid.get(i).get(j) == 1) {
                    safeDist[i][j] = 0;
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] dir : dirs) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        safeDist[nr][nc] == Integer.MAX_VALUE) {

                    safeDist[nr][nc] = safeDist[row][col] + 1;

                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[2], a[2]));

        int[][] best = new int[n][m];

        for (int[] arr : best) {
            Arrays.fill(arr, -1);
        }

        best[0][0] = safeDist[0][0];

        pq.offer(new int[] { 0, 0, best[0][0] });

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int row = curr[0];
            int col = curr[1];
            int safety = curr[2];

            if (row == n - 1 && col == m - 1) {
                return safety;
            }

            if (safety < best[row][col]) {
                continue;
            }

            for (int[] dir : dirs) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m) {

                    int newSafety = Math.min(
                            safety,
                            safeDist[nr][nc]);

                    if (newSafety > best[nr][nc]) {

                        best[nr][nc] = newSafety;

                        pq.offer(new int[] { nr, nc, newSafety });
                    }
                }
            }
        }

        return 0;
    }
}