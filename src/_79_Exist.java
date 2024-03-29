

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-28 21:06:02
 */
public class _79_Exist {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean exist = new _79_Exist().exist(board, word);
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];  // 记录走过的路
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};  // 偏移量的技巧 标明方向
        boolean result = false;
        // 一个点查它的四方
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public boolean exist2(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (check2(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check2(char[][] board, String s, int i, int j, int num) {
        if (s.length() == num) { // 这里因为多调用一次 终止条件是s.length() 不是上面的s.length()-1
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != s.charAt(num)) {
            return false;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};  // 偏移量的技巧 标明方向
        char ch = board[i][j];
        board[i][j] = '#';  // 标记一下 说明已经走过了

        for (int[] direction : directions) {
            if (check2(board, s, i + direction[0], j + direction[1], num + 1)) {
                return true;
            }
        }
        
        // 回溯 重置状态
        board[i][j] = ch;
        return false;
    }


}
