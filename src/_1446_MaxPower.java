/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-07 14:01:58
 */
public class _1446_MaxPower {
    public static void main(String[] args) {
        String s = "leetcode";
        int i = new _1446_MaxPower().maxPower(s);
        System.out.println(i);
    }

    public int maxPower(String s) {
        int res = Integer.MIN_VALUE;
        int n = s.length();
        for (int i = 0; i < n; ) {  // 改成while循环更好
            int left = i;
            char ch = s.charAt(left);
            while (i < n && ch == s.charAt(i)) {
                i++;
            }
            if (i - left > res) {
                res = i - left;
            }
        }
        return res;
    }

    public int maxPower2(String s) {
        int res = Integer.MIN_VALUE;
        int n = s.length();
        int i = 0;
        while (i < n) {
            int left = i;
            char ch = s.charAt(left);
            while (i < n && ch == s.charAt(i)) {
                i++;
            }
            if (i - left > res) {
                res = i - left;
            }
        }


        return res;
    }
}
