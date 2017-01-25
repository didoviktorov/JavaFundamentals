import java.util.Scanner;
import java.util.TreeSet;

public class task_03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();
        for (int i = 0; i < lines; i++) {
            String[] params = scanner.nextLine().split("\\s+");
            for (int j = 0; j < params.length; j++) {
                elements.add(params[j]);
            }
        }
        System.out.println(String.join(" ", elements));
    }
}