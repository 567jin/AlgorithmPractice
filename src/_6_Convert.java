/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-06 10:43:55
 */
public class _6_Convert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = new _6_Convert().convert(s, numRows);
        System.out.println(convert);
        String convert2 = new _6_Convert().convert2(s, numRows);
        System.out.println(convert2);
        String convert3 = new _6_Convert().convert3(s, numRows);
        System.out.println(convert3);
    }

    /**
     * 用二维数组模拟这个过程
     */
    public String convert(String s, int numRows) {
        int n = s.length(), row = numRows;
        if (row == 1 || row >= n) {
            return s;
        }
        int t = row * 2 - 2;  // 一个半z的个数 即一个周期 一个周期会占用row-1列  会消耗t个字符 当i % t < row - 1时 向下移动；反之向上移动
        int col = (n + t - 1) / t * (row - 1);
        char[][] chars = new char[row][col];
        for (int i = 0, x = 0, y = 0; i < s.length(); i++) {
            chars[x][y] = s.charAt(i);
            if (i % t < row - 1) {  // 向下移动
                x++;
            } else {  // 向右上移动
                x--;
                y++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chars[i][j] != 0) {
                    sb.append(chars[i][j]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 压缩矩阵大小  每次添加元素都会添加到 该行上一个元素的右侧 因此每一行初始化为一个StingBuilder即可
     */
    public String convert2(String s, int numRows) {
        int n = s.length(), row = numRows;
        if (row == 1 || row >= n) {
            return s;
        }
        StringBuilder[] record = new StringBuilder[row];
        for (int i = 0; i < row; i++) {
            record[i] = new StringBuilder();
        }
        int t = row * 2 - 2;  // 一个周期内消耗的字符数
        for (int i = 0, x = 0; i < n; i++) {
            record[x].append(s.charAt(i));
            if (i % t < row - 1) {
                x++;
            } else {
                x--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : record) {
            sb.append(stringBuilder.toString());
        }
        return sb.toString();
    }

    public String convert3(String s, int numRows) {
        int n = s.length(), row = numRows;
        if (row == 1 || row >= n) {
            return s;
        }
        StringBuilder[] record = new StringBuilder[row];
        for (int i = 0; i < row; i++) {
            record[i] = new StringBuilder();
        }
        int i = 0, flag = -1;
        for (char ch : s.toCharArray()) {
            record[i].append(ch);
            if (i == 0 || i == row - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : record) {
            sb.append(stringBuilder.toString());
        }
        return sb.toString();
    }

}
