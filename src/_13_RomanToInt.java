import java.util.HashMap;
import java.util.Map;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-05 13:32:06
 */
public class _13_RomanToInt {
    public static void main(String[] args) {
        String s = "III";
        s = "MCMXCIV";
        int i = new _13_RomanToInt().romanToInt(s);
        System.out.println(i);
        int j = new _13_RomanToInt().romanToInt2(s);
        System.out.println(j);
    }

    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer integer = map.get(ch);
            if (i + 1 < s.length() && map.get(ch) < map.get(s.charAt(i + 1))) {
                integer = map.get(s.charAt(i + 1)) - map.get(ch);
                i++;
            }
            res += integer;
        }
        return res;
    }

    public int romanToInt2(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int pre = map.get(s.charAt(0));  // 记录上一个值
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            int num = map.get(s.charAt(i));
            if (pre < num) {  // 上一个值小于当前值 说明是特殊规则 特殊规则简单说就是后面减前面 即上一个值是负数
                res -= pre;
            } else {
                res += pre;
            }
            pre = num;
        }
        res += pre;  // 加上最后一个值
        return res;
    }
}
