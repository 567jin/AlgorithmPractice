/**
 * @author jzy
 * @since 2024-01-18 8:48:52
 */
public class _28_StrStr {
    public static void main(String[] args) {
        String haystack = "asadabbabsabadad";
        String needle = "abbabsab";
        int i = new _28_StrStr().strStr(haystack, needle);
        int j = new _28_StrStr().strStr2(haystack, needle);
        System.out.println(i);
        System.out.println(j);
    }

    /**
     * KMP算法，处理字符串匹配问题
     */
    public int strStr2(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int needleLength = needle.length();

        int[] next = new int[needle.length()];
        // 计算前缀表next
        for (int i = 1, j = 0; i < needleLength; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
//        System.out.println(Arrays.toString(next));
        int haystackLength = haystack.length();
        for (int i = 0, j = 0; i < haystackLength; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) { // 没匹配到 j回退到前缀表中对应的位置
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {  // 匹配到了 j+1 反之j根据前缀表进行回退 而不是直接回退到起点
                j++;
            }
            if (j == needleLength) {  // 匹配到了j个字符 等于needle的字符长度 可以返回了
                return i - j + 1;
            }
        }

        return -1;
    }

    /**
     * 简单暴力匹配
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int length = needle.length();
        int n = haystack.length() - length;
        for (int i = 0; i <= n; i++) {
            String substring = haystack.substring(i, i + length);
            if (substring.equals(needle)) {
                return i;
            }
        }
        return -1;
    }


}
