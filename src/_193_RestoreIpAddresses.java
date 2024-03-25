import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-25 14:15:49
 */
public class _193_RestoreIpAddresses {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> strings = new _193_RestoreIpAddresses().restoreIpAddresses(s);
        System.out.println(strings);

        List<String> strings2 = new _193_RestoreIpAddresses().restoreIpAddresses2(s);
        System.out.println(strings2);
    }

    /**
     * 回溯
     */
    private List<String> res;
    private LinkedList<String> path;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTracking(s, 0, 4);  // 这里的k表示有四段
        return res;
    }

    private void backTracking(String s, int index, int k) {
        if (k == 0) {
            if (index == s.length()) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = index; i < s.length() && i < index + 3; i++) {
            String str = s.substring(index, i + 1);
            int num = Integer.parseInt(str);
            if (num >= 0 && num <= 255) {
                path.add(str);
                backTracking(s, i + 1, k - 1);
                path.removeLast();
            }
            if (num == 0) {  // 有一个0了 直接跳出循环，开启下一段的寻找
                break;  // 遇到0后面的数字不再尝试，直接跳出循环
            }
        }
    }

    public List<String> restoreIpAddresses2(String s) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        dfs(s, 0, 4);   // 4表示需要有4段
        return res;
    }

    public void dfs(String s, int i, int k) {
        if (k == 0) {
            if (i == s.length()) res.add(String.join(".", path));
            return;
        }
        for (int j = i; j < s.length() && j < i + 3; ++j) {
            if (s.charAt(i) == '0' && j > i) return;    // 不能是前导0 即最多只有一个0
            int v = Integer.parseInt(s.substring(i, j + 1));
            if (v >= 0 && v <= 255) {
                path.add(s.substring(i, j + 1));
                dfs(s, j + 1, k - 1);
                path.removeLast();
            }
        }
    }
}
