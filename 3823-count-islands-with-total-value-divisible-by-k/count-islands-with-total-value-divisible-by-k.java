class Solution {
    public int countIslands(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;

        Stack<int[]> st = new Stack<>();

        int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] > 0) {

                    long sum = 0;

                    st.push(new int[]{i, j});

                    int firstValue = grid[i][j];
                    grid[i][j] = -1;

                    while (!st.isEmpty()) {

                        int[] curr = st.pop();

                        int r = curr[0];
                        int c = curr[1];

                        sum += (r == i && c == j) ? firstValue : 0;

                        for (int[] dir : dirs) {

                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if (nr >= 0 && nr < n &&
                                nc >= 0 && nc < m &&
                                grid[nr][nc] > 0) {

                                sum += grid[nr][nc];

                                st.push(new int[]{nr, nc});

                                grid[nr][nc] = -1;
                            }
                        }
                    }

                    if (sum % k == 0) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}