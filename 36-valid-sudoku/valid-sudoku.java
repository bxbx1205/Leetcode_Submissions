class Solution {
    public boolean check(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        int n = board.length;

        for (int i = 0; i < n; i++) {
            if (board[row][i] == '.')
                continue;
            if (set.contains(board[row][i])) {
                return false;
            }

            set.add(board[row][i]);
        }

        set.clear();

        for (int i = 0; i < n; i++) {
            if (board[i][col] == '.')
                continue;
            if (set.contains(board[i][col])) {
                return false;
            }

            set.add(board[i][col]);
        }

        set.clear();

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startCol; i < startCol + 3; i++) {
            if (board[startRow][i] == '.')
                continue;

            if (set.contains(board[startRow][i])) {
                return false;
            }

            set.add(board[startRow][i]);
        }

        for (int i = startCol; i < startCol + 3; i++) {
            if (board[startRow + 1][i] == '.')
                continue;

            if (set.contains(board[startRow + 1][i])) {
                return false;
            }

            set.add(board[startRow + 1][i]);
        }

        for (int i = startCol; i < startCol + 3; i++) {
            if (board[startRow + 2][i] == '.')
                continue;

            if (set.contains(board[startRow + 2][i])) {
                return false;
            }

            set.add(board[startRow + 2][i]);
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '.') {
                    boolean checker = check(board, i, j);
                    if (!checker)
                        return false;
                }
            }
        }

        return true;
    }
}