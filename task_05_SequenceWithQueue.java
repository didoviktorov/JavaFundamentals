import java.util.*;

public class task_05_SequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Long> queue = new ArrayDeque<>();
        long number = Long.parseLong(scanner.nextLine());

        queue.offer(number);
        for (int i = 0; i < 50; i++) {
            long s1 = queue.poll();
            long s2 = s1 + 1;
            long s3 = 2 * s1 + 1;
            long s4 = s1 + 2;
            System.out.print(s1 + " ");
            queue.offer(s2);
            queue.offer(s3);
            queue.offer(s4);
        }
    }
}
