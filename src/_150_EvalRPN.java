import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-18 9:54:48
 */
public class _150_EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int i = new _150_EvalRPN().evalRPN(tokens);
        System.out.println(i);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":  // 注意计算顺序即可 先被弹出来的充当减数 在后面
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":  // 注意计算顺序即可 先被弹出来的充当除数 在后面
                    Integer pop = stack.pop();
                    stack.push(stack.pop() / pop);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }

        }

        return stack.pop();
    }
}

