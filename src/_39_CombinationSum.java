import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jzy
 * @since 2024-01-08 9:12:05
 */
public class _39_CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = new _39_CombinationSum().combinationSum(nums, target);

        lists.forEach((list) -> {
            list.forEach((num) -> {
                System.out.print(num + ",");
            });
            System.out.println();
        });

    }

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            path.addLast(candidate);
            backTracking(candidates, target - candidate, i);
            path.removeLast();
        }
    }

}
