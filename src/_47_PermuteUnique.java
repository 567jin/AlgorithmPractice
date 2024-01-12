import java.util.*;

/**
 * @author jzy
 * @since 2024-01-09 14:42:09
 */
public class _47_PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new _47_PermuteUnique().permuteUnique(nums);
        System.out.println(lists);
    }

    private List<List<Integer>> res;
    Stack<Integer> path;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        res = new ArrayList<>();
        path = new Stack<Integer>();
        backTracking(nums, new boolean[nums.length]);
        return res;
    }

    private void backTracking(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // visited[i - 1] 只取1b 1a只有当visit nums[i]之后我们才去visit nums[i-1] 即visited[i - 1]访问过(因为要先访问后者1b) 直接continue
            // !visited[i - 1] 这个只取1a 1b只有当visit nums[i-1]之后我们才去visit nums[i] 即visited[i - 1]没被访问过(因为要先访问前者) 直接continue
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                backTracking(nums, visited);
                path.pop();
                visited[i] = false;
            }
        }
    }

}
