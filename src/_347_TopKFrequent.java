import java.util.*;

/**
 * @author jzy
 * @since 2024-01-16 9:55:42
 */
public class _347_TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ints = new _347_TopKFrequent().topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {

        // map统计元素出现的次数，key表示元素相应的value表示出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 久
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        int[] res = new int[k];
//        final int[] index = {0};
//        minHeap.forEach(e-> res[index[0]++] = e.getKey());  // 在 Java 中，Lambda 表达式中引用的外部局部变量必须是 final 或 effectively final（一旦赋值后不再修改）。直接使用基本数据类型的 int 变量在 Lambda 表达式中是不允许的，因为该变量无法被修改，而 Lambda 表达式可能会尝试修改该变量的值，这违反了 effectively final 的规则
        // 可以使用 AtomicInteger
        //        AtomicInteger index = new AtomicInteger(0);
//        minHeap.forEach(e -> res[index.getAndIncrement()] = e.getKey());

        int index = 0;
        while (!minHeap.isEmpty()) {
            res[index++] = minHeap.poll().getKey();
        }


        return res;

    }
}
