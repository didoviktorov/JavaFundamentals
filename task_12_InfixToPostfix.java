import java.util.*;

public class task_12_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(postfix(expression));
    }

    public static String postfix(String infix) {
        final String ops  = "-+/*";
        StringBuilder sb = new StringBuilder();
        Deque<Integer> s = new ArrayDeque<>();

        for (String token : infix.split("\\s")) {
            if (token.isEmpty()) {
                continue;
            }

            char c = token.charAt(0);
            int idx = ops.indexOf(c);

            // check for operator
            if (idx != -1) {
                if (s.isEmpty()) {
                    s.push(idx);
                } else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || prec1 == prec2) {
                            sb.append(ops.charAt(s.pop())).append(' ');
                        } else {
                            break;
                        }
                    }
                    s.push(idx);
                }
            } else if (c == '(') {
                s.push(-2); // -2 stands for '('
            } else if (c == ')') {
                // until '(' on stack, pop operators.
                while (s.peek() != -2) {
                    sb.append(ops.charAt(s.pop())).append(' ');
                }
                s.pop();
            } else {
                sb.append(token).append(' ');
            }
        }

        while (!s.isEmpty()) {
            sb.append(ops.charAt(s.pop())).append(' ');
        }

        return sb.toString();
    }
}
