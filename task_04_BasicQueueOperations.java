import java.util.*;

public class task_04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queue = new ArrayDeque<>();

        String[] operations = scanner.nextLine().split("\\s+");
        int pushTimes = Integer.parseInt(operations[0]);
        int popTimes = Integer.parseInt(operations[1]);
        int numberToCheck = Integer.parseInt(operations[2]);

        String[]numbers = scanner.nextLine().split("\\s+");
        for (int i = 0; i < pushTimes; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < popTimes; i++) {
            queue.poll();
        }

        if (queue.contains(numberToCheck)) {
            System.out.println(true);
        } else {
            getMinNumber(queue);
        }
    }

    private static void getMinNumber (Deque<Integer> q) {
        Deque<Integer> tempQueue = q;
        if (!tempQueue.isEmpty()) {
            int minNumber = Integer.MAX_VALUE;
            while (!tempQueue.isEmpty()) {
                int currNum = tempQueue.poll();
                if (currNum < minNumber) {
                    minNumber = currNum;
                }
            }
            System.out.println(minNumber);
        } else {
            System.out.println(tempQueue.size());
        }
    }
}
