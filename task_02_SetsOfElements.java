import java.util.LinkedHashSet;
import java.util.Scanner;

public class task_02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split("\\s+");
        int firstLength = Integer.parseInt(params[0]);
        int secondLength = Integer.parseInt(params[1]);
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < firstLength + secondLength; i++) {
            if (i < firstLength) {
                firstSet.add(Integer.parseInt(scanner.nextLine()));
            } else {
                secondSet.add(Integer.parseInt(scanner.nextLine()));
            }
        }

        int maxLength = 0;
        for (int i = 0; i < params.length; i++) {
            String param = params[i];
            
        }
    }
}
