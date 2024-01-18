/**
 * @author jzy
 * @since 2024-01-18 15:02:55
 */
public class _125_IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = "race a car";
        s = "0P";
        boolean palindrome = new _125_IsPalindrome().isPalindrome(s);
        System.out.println(palindrome);
    }

    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 双指针验证回文串
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {  // 找左边第一个为数字字母的字符
                left++;
            }
            char leftChar = s.charAt(left);

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {  // 找右边第一个为数字字母的字符
                right--;
            }
            char rightChar = s.charAt(right);

            if (left < right) {  // 比较找到的数字字母字符是否相等 但其实还是用到了内置的函数 不用的话也可以 如果是字母判断一下大小写之间差32
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }


    /**
     * 双指针判断
     */
    public boolean isPalindrome(String s) {
        String str = getString(s);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
//        for (; left < str.length() / 2; left++, right--) {
//            if (str.charAt(left) != str.charAt(right)) {
//                return false;
//            }
//        }

        return true;
    }

    /**
     * 得到只有数字字母的字符串 其实可以不用多一步去除操作 可以直接判断
     */
    private String getString(String s) {  // 去掉所有非字母数字字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }

}
