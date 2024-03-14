import org.hamcrest.Condition;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-14 8:54:54
 */
public class _45_Jump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int jump = new _45_Jump().jump(nums);
        System.out.println(jump);
    }

    /**
     * 贪心：每次都选择最远的跳跃距离，则最终到达最后一个位置跳跃步数肯定最少
     */
    public int jump(int[] nums) {
        int n = nums.length - 1;  // 不用访问最后一个元素 在边界正好为最后一个位置的情况下，会增加一次不必要地跳跃次数(因为此时已经到达了 但是还未退出for循环)
        int end = 0;
        int mostRight = 0;  // 目前能到达的最远位置
        int step = 0;
        for (int i = 0; i < n; i++) {
            mostRight = Math.max(mostRight, i + nums[i]);  // 记录当前能到达的最远位置
            if (i == end) {  // 更新边界 边界一定会大于n(题目说的必定可达)
                end = mostRight;
                step++;  // 进入下一次跳跃
            }
        }
        return step;
    }

}
