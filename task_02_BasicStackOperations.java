import java.util.*;

public class task_02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] operations = scanner.nextLine().split("\\s+");
        int pushTimes = Integer.parseInt(operations[0]);
        int popTimes = Integer.parseInt(operations[1]);
        int numberToCheck = Integer.parseInt(operations[2]);

        String[] nums = scanner.nextLine().split("\\s+");
        for (int i = 0; i < pushTimes; i++) {
            stack.push(Integer.parseInt(nums[i]));
        }
        for (int i = 0; i < popTimes; i++) {
            stack.pop();
        }
        if (stack.contains(numberToCheck)) {
            System.out.println(true);
        } else {
            System.out.println(getMinNumber(stack));
        }

    }

    private static Integer getMinNumber (ArrayDeque<Integer> st) {
        int min = Integer.MAX_VALUE;
        for (Integer number : st) {
            if (number < min) {
                min = number;
            }
        }
        if (st.isEmpty()) {
            min = 0;
        }
        return min;
    }
}
