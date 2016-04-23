package algorithms;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Created by fjun on 4/23/16.
 */
public class P36ValidSudoku {
    public static void main(String[] args) {
    }

    public static boolean isValidSudoku(char[][] board) {
        final int rows = board.length;
        final int cols = board.length;
        // 横向
        for (int i = 0; i < rows; i ++) {
            if (!check(board, i, 0, i, cols - 1)) return false;
        }
        // 纵向
        for (int j = 0; j < cols; j ++) {
            if (!check(board, 0, j, rows - 1, j)) return false;
        }
        // 中心
        for (int i = 0; i < rows; i += 3) {
            for (int j = 0; j < rows; j += 3) {
                if (!check(board, i, j, i + 2, j + 2)) return false;
            }
        }
        return true;
    }

    private static boolean check(char[][] board, int fx, int fy, int tx, int ty) {
        int[] num = new int[10];
        for (int x = fx; x <= tx; x ++) {
            for (int y = fy; y <= ty; y ++) {
                int n = board[x][y] - '0';
                if (n < 1 || n > 9) continue;
                if (num[n] > 0) {
                    return false;
                }
                num[n] = 1;
            }
        }
        return true;
    }
}
