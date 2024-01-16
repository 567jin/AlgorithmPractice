import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-16 9:27:41
 */
public class _20_IsValid {
    public static void main(String[] args) {
        String s = "()[]{}";
        s = "((";
        s = "))";
        boolean valid = new _20_IsValid().isValid(s);
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        // 检查字符串是否为空，或者长度为0，或者长度为奇数（即不是有效的括号对）
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }

        // 使用栈来存储未匹配的右括号
        Stack<Character> stack = new Stack<>();

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    // 当前字符是右括号，检查是否与栈顶的左括号匹配  栈为空说明右括号太多了 没有压栈的元素
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
            }
        }

        // 检查栈是否为空，如果栈中还有未匹配的右括号，则返回false
        return stack.isEmpty();
    }


}
