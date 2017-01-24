import java.util.ArrayDeque;
import java.util.Deque;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class task_13_EvaluateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String postfix = postfix(expression);
        double out = evaluate(postfix.split("\\s"));
        System.out.printf("%.2f\n", out);
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

    public static double evaluate (String[] expression) {
        double result = 0;
        final String ops  = "+-*/";

        Deque<Double> stack = new ArrayDeque<>();

        for (String token : expression) {
            if (!ops.contains(token)) {
                stack.push(Double.valueOf(token));
            } else {
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());
                int index = ops.indexOf(token);
                switch (index) {
                    case 0:
                        stack.push(a + b);
                        break;
                    case 1:
                        stack.push(b - a);
                        break;
                    case 2:
                        stack.push(a * b);
                        break;
                    case 3:
                        stack.push(b / a);
                        break;
                }
            }
        }

        result = stack.pop();

        return result;
    }
}
