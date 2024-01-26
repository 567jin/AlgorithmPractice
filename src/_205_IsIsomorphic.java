import java.util.HashMap;
import java.util.Map;

/**
 * @author jzy
 * @since 2024-01-26 8:46:13
 */
public class _205_IsIsomorphic {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        s = "bbbaaaba";
        t = "aaabbbba";  //为 false  映射是对的 但是位置不对 即a映射为b b映射为a 那么最后的ba应该映射为ab才对
        boolean isomorphic = new _205_IsIsomorphic().isIsomorphic(s, t);
        System.out.println(isomorphic);

        boolean isomorphic2 = new _205_IsIsomorphic().isIsomorphic2(s, t);
        System.out.println(isomorphic2);
    }

    /**
     * 直接按照题目意思做  s映射为t t映射为s  一旦规则被打破则返回false
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>();  // s到t的映射
        Map<Character, Character> t2s = new HashMap<>();  // t到s的映射
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);  // 当映射不对应时 就是false
            if ((s2t.containsKey(chS) && s2t.get(chS) != chT) || (t2s.containsKey(chT) && t2s.get(chT) != chS)) {
                return false;
            }
            s2t.put(chS, chT);
            t2s.put(chT, chS);
        }

        return true;
    }

    /**
     * s和t是ASCII码组成，因此数组需要128位 将这两个数组都映射为另外一个数组进行比较 而不是直接相互映射
     * <p>
     * 比如 egg 和 foo
     * e映射为 1
     * f映射为 1
     * <p>
     * g映射为 2
     * o映射为 2
     * <p>
     * g映射为2
     * o映射为2
     * <p>
     * 综上 egg<->foo
     * <p>
     * 对于aaabbbba和bbbaaaba来说
     * s中a映射为1 b映射为2
     * t中b映射为1 a映射为2
     * 在最后 s中的a映射为1 t中的b映射a，那么他们两个不相等。
     */
    public boolean isIsomorphic2(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //数组中是否已经保存了值，保存了就不需要再处理了
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }


}
