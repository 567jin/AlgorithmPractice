import java.util.*;

/**
 * @author jzy
 * @since 2024-01-09 11:11:30
 */
public class _90_SubsetsWithDup {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = new _90_SubsetsWithDup().subsetsWithDup(nums);
        System.out.println(lists);
    }

    private List<List<Integer>> res;
    private LinkedList<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTracking(nums, 0);
        HashSet<List<Integer>> lists = new HashSet<>();
        lists.addAll(res);

        return new ArrayList<>(lists);
    }

    private void backTracking(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 回溯到最深度，再添加值
        backTracking(nums, index + 1);
        path.addLast(nums[index]);
        backTracking(nums, index + 1);
        path.removeLast();
    }
}
