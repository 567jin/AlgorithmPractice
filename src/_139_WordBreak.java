import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-18 9:35:06
 */
public class _139_WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = new _139_WordBreak().wordBreak(s, wordDict);
        System.out.println(b);
        String string = "";
        HashSet<Object> objects = new HashSet<>();

    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        // dp[i]=true 表示可以在wordDict中找到
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // 初始值 表示0个字符为true
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) { // 以i为起始点 自增j并截取 ij范围内的字符串 看看是否在set中
                if (dp[i] && set.contains(s.substring(i, j))) {
                    dp[j] = true;
//                    break;  // 不能breaks s ="aaaaaaa" wordDict=["aaaa","aaa"] 就过不了 因为当查到3个a时候就break了 这个是以i为起点 与下面以i为终点不同
                }
            }
        }

        return dp[n];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);  // 将字典列表转换成集合 便于查找
        int n = s.length();
        boolean[] dp = new boolean[n + 1];  // 记录第几个位置为true
        dp[0] = true;  // 初始为0个字符 为true
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
