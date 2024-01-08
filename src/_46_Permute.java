import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-08 9:47:07
 */
public class _46_Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new _46_Permute().permute(nums);
        lists.forEach((list) -> {
            list.forEach((num) -> {
                System.out.print(num + ",");
            });
            System.out.println();
        });

    }

    private List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> path = new Stack<Integer>();

    public List<List<Integer>> permute(int[] nums) {

        backTracking(nums, new boolean[nums.length]);
        return res;
    }

    private void backTracking(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
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
