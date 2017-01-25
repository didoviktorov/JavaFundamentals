import java.util.LinkedHashMap;
import java.util.Scanner;

public class task_07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            int domainIndex = email.lastIndexOf('.');
            String domain = email.toLowerCase().substring(domainIndex + 1);
            if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")) {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        for (String person : emails.keySet()) {
            System.out.println(person + " -> " + emails.get(person));
        }
    }
}
