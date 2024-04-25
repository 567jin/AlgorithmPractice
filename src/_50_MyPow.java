/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-04-24 19:14:51
 */
public class _50_MyPow {
    public static void main(String[] args) {
        System.out.println(new _50_MyPow().myPow(2.00000, 1000));
    }

    /**
     * 快速幂
     * 原理就是倍乘 以减少循环次数 如X^64需要循环64 而计算出x^2后 一次乘法就可以得出x^4=X^2*X^2 以此类推直到计算出X^64
     * <p>
     * 如果幂指数不是2的倍数 可以转换成2的倍数  如 5 = (101) = 1*2^2+0*2^1+1*2^0=5
     */
    public double myPow(double x, int n) {
        if (x == 0.0) {
            return 0.0;
        }
        long b = n;
        // 幂指数小于0 则取反 x取倒数
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b != 0) {
            // 得到b的位数为1的位置 res才成x  因为其他为0 所以不用计算
            if ((b & 1) == 1) {
                res *= x;
            }
            // 得到倍乘的结果
            x *= x;

            b >>= 1;
        }
        return res;
    }
}
