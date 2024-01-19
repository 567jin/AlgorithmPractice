/**
 * @author jzy
 * @since 2024-01-19 9:45:26
 */
public class _383_CanConstruct {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "aa";
        boolean b = new _383_CanConstruct().canConstruct(ransomNote, magazine);
        System.out.println(b);

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || "".equals(magazine)) {
            return false;
        }
        int[] record = new int[26];
//        magazine.chars().forEach(c -> record[c - 'a']++);  // 效率比较低

        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (record[c - 'a'] == 0) {
                return false;
            }
            record[c - 'a']--;
        }
        return true;
    }
}
