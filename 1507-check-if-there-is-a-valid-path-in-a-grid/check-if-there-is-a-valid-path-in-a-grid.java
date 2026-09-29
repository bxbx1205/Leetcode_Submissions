class Solution {

    int[][] dir = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    int[][] streets = {
        {},
        {2, 3},
        {0, 1},
        {2, 1},
        {3, 1},
        {2, 0},
        {3, 0}
    };

    public boolean hasValidPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int d : streets[grid[r][c]]) {

                int nr = r + dir[d][0];
                int nc = c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                int opposite = d ^ 1;
                boolean connected = false;

                for (int nd : streets[grid[nr][nc]]) {
                    if (nd == opposite) {
                        connected = true;
                        break;
                    }
                }

                if (connected) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}