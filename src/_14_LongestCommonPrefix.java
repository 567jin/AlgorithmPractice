/**
 * @author jzy
 * @since 2024-01-24 9:18:31
 */
public class _14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        strs = new String[]{"ab", "a"};
        String s = new _14_LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);

        String s2 = new _14_LongestCommonPrefix().longestCommonPrefix2(strs);
        System.out.println(s2);
        
    }

    /**
     * 横向扫描 以第一个为基准两两比较 两两比较后更新prefix
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String prefix = strs[0]; // 第一个字符串
        for (String str : strs) {
            prefix = longestCommonPrefix(prefix, str);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int i = 0;
        for (; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return str1.substring(0, i);
    }

    /**
     * 纵向扫描  遍历每个字符的第一个字符 一旦不等就直接返回
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || str.charAt(i) != ch) {  // 也可直接截取的方式 而不是采用sb拼接的方式
                    return sb.toString();
                }
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}
