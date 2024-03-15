import sun.awt.AWTAccessor;

import java.net.ContentHandler;
import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-15 8:55:32
 */
public class _274_HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        citations = new int[]{1, 3, 1};
        int i = new _274_HIndex().hIndex(citations);
        System.out.println(i);
    }

    /**
     * 0 1 3 5 6
     * 至少有h篇论文 引用指数大于h
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
