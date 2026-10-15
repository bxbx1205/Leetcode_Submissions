class Solution {
    public void updateBoard(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
        return;
    }

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        // main maal
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        for (int i = 0; i < n; i++) {
            

            for (int j = 0; j < m; j++) {
                int neighBourCnt = 0;
                int row = i;
                int col = j;
                for (int[] dir : dirs) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    if (newRow >= 0 && newRow < n &&
                            newCol >= 0 && newCol < m && Math.abs(board[newRow][newCol]) == 1) {
                        neighBourCnt++;
                    }
                }

                if (board[i][j] == 1) {

                    if (neighBourCnt < 2 || neighBourCnt > 3) {
                        board[i][j] = -1;
                    }
                }

                else if (board[i][j] == 0) {

                    if (neighBourCnt == 3) {
                        board[i][j] = 2;
                    }
                }

            }
        }

        updateBoard(board);

        return;
    }
}