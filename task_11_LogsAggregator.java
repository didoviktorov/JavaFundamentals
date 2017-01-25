import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class task_11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> userDuration = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userIps = new TreeMap<>();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String line = scanner.nextLine();

            String[] params = line.split("\\s+");
            String name = params[1];
            String ip = params[0];
            int duration = Integer.parseInt(params[2]);
            if (!userDuration.containsKey(name)) {
                userDuration.put(name, 0);
            }
            userDuration.put(name, userDuration.get(name) + duration);

            if (!userIps.containsKey(name)) {
                userIps.put(name, new TreeSet<>());
            }
            userIps.get(name).add(ip);
        }

        for (String key : userIps.keySet()) {
            int dur = userDuration.get(key);
            String ips = userIps.get(key) + "";
            System.out.println(key + ": " + dur + " " + ips);
        }
    }
}
