import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-04-15 17:18:43
 */
public class _9999_RandomN {
    public static void main(String[] args) {

        Object o = new Object();
        o.notify();
        System.out.println(random7());
    }

    // 借助1-5之间的随机数的方法(可以生成1-25之间的随机数) 生成1-N之间的随机数
    // randomN = (5*rand5()-1)+rand5();
    private static int random7() {
        // 生成1-n之间的随机数
        int x = Integer.MAX_VALUE;
        while (x > 21) {
            x = 5 * (random5() - 1) + random5();
        }

        return x % 7 + 1;
    }

    private static int random5() {
        // 生成1-5之间的随机数
        return (int) (Math.random() * 5 + 1);
    }

    ArrayList<String> res;
    ArrayList<String> path;

    @Test
    public void tt() {
        int n = 3;
        ArrayList<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        res = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(0, 0, n);
        return res;
    }

    private void backTracking(int left, int right, int n) {
        if (path.size() == 2 * n) {
            res.add(String.join("", path));
            return;
        }

        if (left < n) {
            path.add("(");
            backTracking(left + 1, right, n);
            path.remove(path.size() - 1);
        }

        if (right < n && right < left) {
            path.add(")");
            backTracking(left, right + 1, n);
            path.remove(path.size() - 1);
        }
    }

}


