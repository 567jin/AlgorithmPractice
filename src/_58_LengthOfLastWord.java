/**
 * @author jzy
 * @since 2024-01-17 16:34:20
 */
public class _58_LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        s = "   fly me   to   the moon  ";
        int i = new _58_LengthOfLastWord().lengthOfLastWord(s);
        System.out.println(i);
    }

    /**
     * 正则方式 使用正则表达式匹配空格分隔字符串 得到一个数组 数组最后一个元素的长度就是最后一个单词的长度
     */
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                while (i >= 0 && s.charAt(i--) != ' ') {
                    count++;
                }
                break;
            }
        }
        return count;
    }

}
