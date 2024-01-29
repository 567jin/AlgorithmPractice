import java.util.HashSet;
import java.util.Set;

/**
 * @author jzy
 * @since 2024-01-26 10:45:38
 */
public class _3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abccbb";
//        s = "    ";
        int i = new _3_LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        // 如果字符串为空或者长度为0，直接返回0
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int maxLength = 0; // 最大长度
        int left = 0; // 左边界
        Set<Character> set = new HashSet<>(); // 存储在当前窗口中已经出现的字符

        // 遍历字符串
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果当前字符不在集合中，则添加到集合，并更新最大长度
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {  // 出现了重复字符，这段代码的目的就是移动左边界到重复字符的位置，重新开始找子串
                // 当前字符已存在于集合中，需要移动左边界到重复字符的位置 因为是求子串
                while (left <= right && s.charAt(left) != currentChar) {
                    set.remove(s.charAt(left)); // 移除左边界字符
                    left++; // 移动左边界
                }
                // 移动左边界至重复字符的位置
                left++;
            }
        }

        // 返回最大长度
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        int[] cache = new int[128];   // set集合
        for (int start = 0, end = 0; end < s.length(); end++) {
            char right = s.charAt(end);
            cache[right]++;
            while (cache[right] > 1) { // 当前字符重复，需要移动左边界 直到重复字符只出现一次
                cache[s.charAt(start++)]--;  // 移动左边界
            }
            ans = Math.max(ans, end - start + 1);  // 更新最大长度
        }
        return ans;
    }


}
