import java.util.*;

/**
 * @author jzy
 * @since 2024-01-15 9:22:15
 */
public class _49_GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new _49_GroupAnagrams().groupAnagrams(strs);
        System.out.println(lists);

        List<List<String>> lists2 = new _49_GroupAnagrams().groupAnagrams2(strs);
        System.out.println(lists2);
    }

    /**
     * 将字符串数组按照字母异位词分组 排序法 字母排序后 若顺序是一样的，那么它们就是一组字母异位词
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        // key是排序后的字符串，value是原字符串
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(String.valueOf(chars), new ArrayList<String>());
            list.add(str);
            map.put(String.valueOf(chars), list);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 计数法 即key为字母出现次数的数组，异位词得到的计数数组是一样的
     * <p>
     * 需要注意的是，在使用数组作为哈希表的键时，不同语言的支持程度不同，因此不同语言的实现方式也不同。C++可以使用数组当做键值
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        // key是排序后的字符串，value是原字符串
//        Map<Integer[], List<String>> map = new HashMap<>();
//        Map<String, List<String>> map = new HashMap<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
//            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < 26; i++) {
//                if (counts[i] != 0) {
//                    sb.append((char) ('a' + i));
//                    sb.append(counts[i]);
//                }
//            }
            // 将key转换为散列值当做key
            // 使用Arrays.hashCode() 方法来获取数组的散列值
            Integer hash = Arrays.hashCode(counts);

            List<String> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(str);
            map.put(hash, list);

//            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
//            list.add(str);
//            map.put(sb.toString(), list);
        }

        return new ArrayList<>(map.values());
    }

}
