import java.util.Arrays;
import java.util.SimpleTimeZone;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-21 15:20:41
 */
public class _66_PlusOne {
    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        digits = new int[]{9, 9, 9, 9};
        int[] ints = new _66_PlusOne().plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {  // 找到末尾最后一个不为9的数字 然后让其自增1 其后面的数字全为零即可
                digits[i]++;
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        // 全是9的情况 数组长度需要扩增
        int ans[] = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
