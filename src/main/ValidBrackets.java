import java.util.Stack;

public class ValidBrackets {
    public static void main(String[] args) {
        String s = "(()";
        //String s = ")()())";
        //String s = ")(()())";
        //String s = ")(";
        checkBrackets(s);
    }
    public static void checkBrackets(final String s) {

        // Логика
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); ) {
            char element = sb.charAt(i);
            if (element == '(') {
                stack.push(i);
                i++;
            } else if (!stack.empty() && element == ')') {
                stack.pop();
                i++;
            } else {
                sb.deleteCharAt(i);
            }
        }
        if (!stack.empty()) {
            int stackSize = stack.size();
            for (int i = 0; i < stackSize; i++) {
                sb.deleteCharAt(stack.pop());
            }
        }

        // Вывод
        if (sb.length() == 0) {
            System.out.println("0");
        } else {
            System.out.println(sb.length() + " - " + sb.toString());
        }
    }
}
