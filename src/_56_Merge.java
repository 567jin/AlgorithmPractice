import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-11 10:23:57
 */
public class _56_Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {15, 18}, {8, 10}};
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        System.out.println("-------------------");
        int[][] merge = new _56_Merge().merge(intervals);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public int[][] merge(int[][] intervals) {
        // 先对区间进行排序
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));  // 这种排序方法很慢
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] interval : intervals) {
            if (res.size() == 0) {
                res.add(new int[]{interval[0], interval[1]});
                continue;
            }
            int[] ints = res.getLast();
            // 需要区间时排好序的 要不然需要对区间先进行排序
            if (interval[0] <= ints[1] && interval[0] >= ints[0]) {
                ints[1] = Math.max(ints[1], interval[1]);
            } else {
                res.addLast(interval);
            }
        }
        return res.toArray(new int[][]{});
    }
}
