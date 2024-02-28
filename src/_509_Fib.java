/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-28 19:20:25
 */
public class _509_Fib {
    public static void main(String[] args) {
        int n = 10;
        int fib = new _509_Fib().fib(n);
        System.out.println(fib);
        int fib2 = new _509_Fib().fib2(n);
        System.out.println(fib2);
        int fib3 = new _509_Fib().fib3(n);
        System.out.println(fib3);
    }

    /**
     * 动态规划的降维处理 一维降成0维 即只用几个变量来记录中间值即可
     */
    public int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 1, r = 1;  // p第一个值 q表示第二个值
        for (int i = 2; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
//        return r;
        return q;  // 返回r和q均可
    }

    /**
     * 动态规划的方法 保存中间值
     */
    public int fib2(int n) {
        int[] dp = new int[n + 1];  // 缓存中间值
        if (n == 0) {
            dp[0] = 0;
            return 0;
        }
        if (n == 1) {
            dp[1] = 1;
            return 1;
        }
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {  // 自底向上计算
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 直接将推导式转化成递归程序  这样会导致很多没必要的中间计算  耗时很长
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


}
