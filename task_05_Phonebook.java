import java.util.LinkedHashMap;
import java.util.Scanner;

public class task_05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("search")) {
            String[] params = line.split("-");
            String name = params[0];
            String number = params[1];
            phoneBook.put(name, number);
            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!line.equals("stop")) {
            String name = line;
            if (phoneBook.containsKey(name)) {
                System.out.println(name + " -> " + phoneBook.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }
            line = scanner.nextLine();
        }
    }
}