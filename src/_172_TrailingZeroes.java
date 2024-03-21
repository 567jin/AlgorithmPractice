import com.sun.corba.se.impl.oa.toa.TOA;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-21 15:31:28
 */
public class _172_TrailingZeroes {
    public static void main(String[] args) {
        int n = 3;
        n = 125;
        int i = new _172_TrailingZeroes().trailingZeroes(n);
        System.out.println(i);
    }

    /**
     * 尾随0 只有2*5这样的数 才会尾随零 因此 问题就转化成了 求n的2或5质因数的个数的最小值
     * 又由于5的质因数个数不会大于2的个数 因此 只需要求出5的质因数的个数即可
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            // 这样在统计时 5统计了 5^2还需要再统计 5^3一样的流程
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }

    /**
     * 上面的优化，
     * 5有一个5 25有5个5 125有25个5 因此每次在统计时统计5的幂的质因数的个数
     * 如 n=125  5有25个 25有5个 125有一个 总共31个5
     */
    public int trailingZeroes2(int n) {
        int zeros = 0;
        int interval = 5;
        while (n >= interval) {
            zeros += n / interval;
            interval *= 5;
        }
        return zeros;
    }


}
