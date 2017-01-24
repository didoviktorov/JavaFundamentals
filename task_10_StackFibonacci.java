import java.util.*;

public class task_10_StackFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);
        int index = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index - 1; i++) {
            long number = stack.pop();
            long previousNumber = stack.peek();
            long nextValue = previousNumber + number;
            stack.push(number);
            stack.push(nextValue);
        }
        System.out.println(stack.peek());
    }
}
