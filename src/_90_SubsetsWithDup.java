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
        Arrays.sort(nums);
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int index) {
        res.add(new ArrayList<>(path));  // 遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合。
        if (index >= nums.length) {  // 终止条件可不加
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
