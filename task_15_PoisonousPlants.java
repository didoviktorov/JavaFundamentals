import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class task_15_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        int[] plants = new int[numberOfPlants];
        for (int i = 0; i < numberOfPlants; i++) {
            plants[i] = scanner.nextInt();
        }
        int[] days = new int[numberOfPlants];
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);
        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;
            while (indexes.size() > 0 && plants[indexes.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[indexes.pop()]);
            }

            if (indexes.size() > 0) {
                days[i] = maxDays + 1;
            }
            indexes.push(i);
        }
        Arrays.sort(days);
        System.out.println(days[days.length - 1]);
    }
}
