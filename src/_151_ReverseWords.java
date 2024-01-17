/**
 * @author jzy
 * @since 2024-01-17 16:51:32
 */
public class _151_ReverseWords {
    public static void main(String[] args) {
        String s = " the sky is   blue ";
        System.out.println(s);
        String s1 = new _151_ReverseWords().reverseWords(s);
        System.out.println(s1);

        s = " the sky is   blue ";
        System.out.println(s);
        String s2 = new _151_ReverseWords().reverseWords2(s);
        System.out.println(s2);
    }

    /**
     * 双指针确定字母的索引 两指针之间的距离就是单词长度
     */
    public String reverseWords2(String s) {
        StringBuilder res = new StringBuilder();
        int right = s.length() - 1;
        // 去除尾部空格
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }

        int left = right;  // left-right 就是一个字母的长度
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) != ' ') {
                right--;
            }

            // right+1 为单词的第一个' '的字符  截取长度为 left-right 因此end=right+1+(left-right)=left+1
            res.append(s, right + 1, left + 1).append(" "); // 获取单词并加上空格

            while (right >= 0 && s.charAt(right) == ' ') {  // 去除新的字符串 尾部空格
                right--;
            }
            left = right;
        }

        return res.substring(0, res.length() - 1);
    }

    /**
     * 倒序遍历结合reverse()函数
     */
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            if (s.charAt(i) != ' ') {
                while (i >= 0 && s.charAt(i) != ' ') {
                    sb.append(s.charAt(i));
                    i--;
                }
                res.append(sb.reverse().toString()).append(' ');
            }


        }

        return res.substring(0, res.length() - 1);  // 忽略最后一个空格
    }
}
