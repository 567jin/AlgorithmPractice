import java.util.*;

/**
 * @author jzy
 * @since 2024-01-09 8:58:03
 */
public class _17_LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = new _17_LetterCombinations().letterCombinations(digits);
        strings.forEach((string) -> System.out.print(string + ","));
    }

    private List<String> res;
    private StringBuilder path;
    private Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        res = new ArrayList<String>();
        path = new StringBuilder();
        backTracking(digits, 0);
        return res;
    }

    /**
     * @param digits 输入的字符串
     * @param index  字符串索引
     */
    private void backTracking(String digits, int index) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String str = map.get(digit);
        // 每个索引选一个值 值的选择取决于str 即map对应字符串的长度
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backTracking(digits, index + 1);
            path.deleteCharAt(index);
        }
    }
}
