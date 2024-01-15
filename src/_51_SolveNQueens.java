import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jzy
 * @since 2024-01-15 14:25:34
 */
public class _51_SolveNQueens {
    public static void main(String[] args) {
        List<List<String>> lists = new _51_SolveNQueens().solveNQueens(5);
        System.out.println(lists);
    }

    private List<List<String>> res;
    private char[][] chessboard;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0 || n == 3) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        chessboard = new char[n][n];
        // 初始化棋盘
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }

        backTracking(n, 0);
        return res;
    }

    private void backTracking(int n, int row) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n)) {
                chessboard[row][col] = 'Q';
                backTracking(n, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
//        for (char[] chars : chessboard) {
//            list.add(String.valueOf(chars));
//        }
        // 使用流的方式将二维数组的每一行 转成字符串后 添加进一个List中
        Arrays.stream(chessboard).forEach(chess -> list.add(String.valueOf(chess)));

        return list;
    }


    /**
     * 检查棋盘摆放是否可行
     *
     * @param row 行
     * @param col 列
     */
    private boolean isValid(int row, int col, int n) {
        // 检查列
        for (int i = 0; i < row; i++) { // 这是一个剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查 45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testArray2List() {
        _51_SolveNQueens solveNQueens = new _51_SolveNQueens();

        char[][] chessboard1 = {
                {'R', 'B', 'N'},
                {'P', 'Q', 'K'}
        };
        List<String> result1 = solveNQueens.Array2List(chessboard1);
        System.out.println(result1);

    }
}
