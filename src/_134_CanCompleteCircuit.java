/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-22 10:02:35
 */
public class _134_CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int i = new _134_CanCompleteCircuit().canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    /**
     * 模拟 即直接找到每个站点 循环遍历 看起是否能够到达
     * 但是有一个可以优化的地方 当不可达站点时 则该站点的之前的站点也不可达(因为会经过此不可达的站点) 因此每次遍历的起点是不可达站点的下一个站点
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int total = 0;
            int sumCost = 0;
            int cnt = 0;  // 计数 看当前站点能往后走多少个站点
            while (cnt < n) {
                int j = (i + cnt) % n;  // 因为是环形的 当超过末尾时 应回到起始点
                total += gas[j];
                sumCost += cost[j];
                if (total < sumCost) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) { // 即能环绕一周 到达了5个站点
                return i;
            } else { // 不能环绕一周则从当前不能到达的站点的下一个站点开始
                i = i + cnt + 1;
            }
        }

        return -1;
    }
}
