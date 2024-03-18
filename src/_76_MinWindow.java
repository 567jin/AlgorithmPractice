import com.sun.javaws.WinOperaSupport;

import java.security.PrivateKey;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-15 9:37:02
 */
public class _76_MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";   // BANC是最小覆盖
        String s1 = new _76_MinWindow().minWindow(s, t);
        System.out.println(s1);
    }

    public String minWindow(String s, String t) {  // t包含在s中
        int n1 = s.length();
        int n2 = t.length();
        if (n2 > n1) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE, valid = 0;
        while (right < n1) {
            char cur = s.charAt(right);
            right++;
            if (map.containsKey(cur)) {
                Integer total = window.getOrDefault(cur, 0);
                window.put(cur, total + 1);
                // window中需要有 valid个字符与map中相等
                if (window.get(cur).equals(map.get(cur))) {  // Integer之间比较实用equals
                    valid++;
                }
            }

            while (map.size() == valid) {  // 开始收缩左指针
                if (right - left < minLen) {  // 记录一下最小值
                    start = left;
                    minLen = right - left;
                }
                // d 是将移除窗口的字符串
                char d = s.charAt(left);
                // 左边移动窗口
                left++;
                // 进行窗口内数据等一系列更新
                if (window.containsKey(d)) {  // 去除左指针对应的字符(不一定包含在window中)
                    if (window.get(d).equals(map.get(d))) {  // window中的d元素数量与map中的一样 那么一旦去除了d元素将不满足覆盖条件
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
