import java.util.*;

public class task_01_ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] nums = scanner.nextLine().split("\\s+");
        for (String num : nums) {
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
