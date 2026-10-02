class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        dist[0][0] = grid.get(0).get(0);
        queue.offer(new int[] { 0, 0 });
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for (int[] dirs : dir) {
                int newRow = currentRow + dirs[0];
                int newCol = currentCol + dirs[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newDist = dist[currentRow][currentCol] + grid.get(newRow).get(newCol);
                    if (newDist < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newDist;
                        queue.offer(new int[] { newRow, newCol });
                    }
                }
            }
        }

        return dist[n - 1][m - 1] < health;

    }

}