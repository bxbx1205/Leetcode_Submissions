class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] distance = new int[n][n];
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = max;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{1, 0, 0});
        distance[0][0] = 1;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currentDistance = current[0];
            int currentRow = current[1];
            int currentCol = current[2];

            if (currentRow == n - 1 && currentCol == n - 1) {
                return currentDistance;
            }

            if (currentRow - 1 >= 0 && currentCol - 1 >= 0
                    && grid[currentRow - 1][currentCol - 1] == 0) {

                if (distance[currentRow - 1][currentCol - 1] > currentDistance + 1) {
                    distance[currentRow - 1][currentCol - 1] = currentDistance + 1;
                    pq.offer(new int[]{currentDistance + 1, currentRow - 1, currentCol - 1});
                }
            }

            if (currentRow - 1 >= 0
                    && grid[currentRow - 1][currentCol] == 0) {

                if (distance[currentRow - 1][currentCol] > currentDistance + 1) {
                    distance[currentRow - 1][currentCol] = currentDistance + 1;
                    pq.offer(new int[]{currentDistance + 1, currentRow - 1, currentCol});
                }
            }

            if (currentRow - 1 >= 0 && currentCol + 1 < n
                    && grid[currentRow - 1][currentCol + 1] == 0) {

                if (distance[currentRow - 1][currentCol + 1] > currentDistance + 1) {
                    distance[currentRow - 1][currentCol + 1] = currentDistance + 1;
                    pq.offer(new int[]{currentDistance + 1, currentRow - 1, currentCol + 1});
                }
            }

            if (currentCol - 1 >= 0
                    && grid[currentRow][currentCol - 1] == 0) {

                if (distance[currentRow][currentCol - 1] > currentDistance + 1) {
                    distance[currentRow][currentCol - 1] = currentDistance + 1;
                    pq.offer(new int[]{currentDistance + 1, currentRow, currentCol - 1});
                }
            }

            if (currentCol + 1 < n
                    && grid[currentRow][currentCol + 1] == 0) {

                if (distance[currentRow][currentCol + 1] > currentDistance + 1) {
                    distance[currentRow][currentCol + 1] = currentDistance + 1;
                    pq.offer(new int[]{currentDistance + 1, currentRow, currentCol + 1});
                }
            }

            if (currentRow + 1 < n && currentCol - 1 >= 0
                    && grid[currentRow + 1][currentCol - 1] == 0) {

                if (distance[currentRow + 1][currentCol - 1] > currentDistance + 1) {
                    distance[currentRow + 1][currentCol - 1] = currentDistance + 1;
                    pq.offer(new int[]{currentDistance + 1, currentRow + 1, currentCol - 1});
                }
            }

            if (currentRow + 1 < n
                    && grid[currentRow + 1][currentCol] == 0) {

                if (distance[currentRow + 1][currentCol] > currentDistance + 1) {
                    distance[currentRow + 1][currentCol] = currentDistance + 1;
                    pq.offer(new int[]{currentDistance + 1, currentRow + 1, currentCol});
                }
            }

            if (currentRow + 1 < n && currentCol + 1 < n
                    && grid[currentRow + 1][currentCol + 1] == 0) {

                if (distance[currentRow + 1][currentCol + 1] > currentDistance + 1) {
                    distance[currentRow + 1][currentCol + 1] = currentDistance + 1;
                    pq.offer(new int[]{currentDistance + 1, currentRow + 1, currentCol + 1});
                }
            }
        }

        return -1;
    }
}