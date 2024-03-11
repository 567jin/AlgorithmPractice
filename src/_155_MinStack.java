import java.util.Stack;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-11 11:08:04
 */
public class _155_MinStack {
    public static void main(String[] args) {

    }

    /**
     * 保存差值和最小值的方法
     */
    public class MinStack2 {
        private Stack<Long> stack;
        private long minVal;

        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(0L);
                minVal = val;
            } else {
                stack.push(val - minVal);
                minVal = Math.min(val, minVal);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            } else {
                long pop = stack.pop();
                minVal = pop < 0 ? minVal - pop : minVal;  // 当pop小于0时 说明要更新最小值了
            }

        }

        public int top() {
            long top = stack.peek();
            if (top > 0) {
                return (int) (top + minVal);
            } else {   // 小于零时 就是更新最小值时 即最小值是其本身
                return (int) (minVal);
            }

        }

        public int getMin() {
            return (int) minVal;
        }
    }


    /**
     * 使用额外一个类(保存，值和最小值)
     */
    public class MinStack {
        private Stack<Pair> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Pair(val, val));
            } else {
                stack.push(new Pair(val, Math.min(val, stack.peek().getMinVal())));
            }

        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().getVal();
        }

        public int getMin() {
            return stack.peek().getMinVal();
        }
    }

    class Pair {
        private int val;
        private int minVal;

        public Pair() {
        }

        public Pair(int x, int y) {
            this.val = x;
            this.minVal = y;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getMinVal() {
            return minVal;
        }

        public void setMinVal(int minVal) {
            this.minVal = minVal;
        }
    }

}
