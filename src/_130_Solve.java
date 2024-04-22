import javax.sound.sampled.Line;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-29 9:24:05
 */
public class _130_Solve {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (char[] chars : board) {
            System.out.println(chars);
        }
        System.out.println("----------------------");
        new _130_Solve().solve(board);
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }

    private List<int[]> path;

    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }


    }

    /**
     * 深度优先搜索 标记在边界上的O为 ‘#’ 这样的话 最后没被标记为'#'的O就是被X包围的
     */
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        // 四个方向  看当前的’O‘(边界上的) 与哪些'O'相连 相连的话 也是需要被标记为'#'
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    private void dfs2(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        // 使用 偏移量
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            dfs2(board, i, j);
        }

    }

    private void bfs(char[][] board, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
                continue;
            }
            board[i][j] = '#';
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i - 1, j});
            queue.add(new int[]{i, j + 1});
            queue.add(new int[]{i, j - 1});
        }
    }

}
