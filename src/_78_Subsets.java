import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jzy
 * @since 2024-01-09 9:28:07
 */
public class _78_Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new _78_Subsets().subsets(nums);
        System.out.println(subsets);
        System.out.println("---------------------------------------------");
        List<List<Integer>> subsets2 = new _78_Subsets().subsets2(nums);
        System.out.println(subsets2);
        System.out.println("---------------------------------------------");
        List<List<Integer>> subsets3 = new _78_Subsets().subsets3(nums);
        System.out.println(subsets3);

    }

    private List<List<Integer>> subsets3(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        subsetsHelper(nums, 0);
        return res;
    }

    private void subsetsHelper(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length) { //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }

    /**
     * 动态规划的思想
     * 首先添加一个空集合 然后逐个向这个空集合中添加新元素即成为一个新的子集
     * <p>
     * 遍历到1时 添加1 此时集合变成[[],[1]]
     * <p>
     * 遍历到2时 添加2 此时集合变成 [[],[1],[2],[1,2]]
     * <p>
     * 遍历到3时 添加3 此时集合变成[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());  // 首先向子集中添加一个空集合的子集
        for (int i = 0; i < nums.length; i++) {
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(lists.get(j));
                list.add(nums[i]);
                lists.add(new ArrayList<>(list));
            }
        }
        return lists;
    }

    private List<List<Integer>> res;
    private LinkedList<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTracking(nums, 0);
        return res;
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
