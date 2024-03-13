import sun.java2d.marlin.DPathConsumer2D;

import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-13 10:09:26
 */
public class _5_LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
//        s = "cbbd";
        s = "a";
        s = "ac";
        s = "aacabdkacaa";
        String s1 = new _5_LongestPalindrome().longestPalindrome0(s);
        System.out.println(s1);
    }

    public String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }


        return "";
    }


    /**
     * 我是想转换成 两个序列的最长子序列
     * 一个序列是原序列 另一个序列是原序列的倒序 但是不知道为啥不行(力扣就剩十几个用例过不了) 比如s = "aacabdkacaa"
     */
    public String longestPalindrome0(String s) {
        return "";
    }

}
