import java.util.LinkedHashSet;
import java.util.Scanner;

public class task_01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> names = new LinkedHashSet<>();
        for (int i = 0; i < lines; i++) {
            names.add(scanner.nextLine());
        }
        System.out.println(String.join("\n", names));
    }
}
