import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_09_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();
        String pattern = "IP=(.+)\\smessage=(.+)\\suser=(.+)";
        Pattern p = Pattern.compile(pattern);

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            Matcher m = p.matcher(line);
            if (m.find()) {
                String ip  = m.group(1);
                String message = m.group(2);
                String user = m.group(3);
                if (!logs.containsKey(user)) {
                    logs.put(user, new LinkedHashMap<>());
                }
                if (!logs.get(user).containsKey(ip)) {
                    logs.get(user).put(ip, 0);
                }
                logs.get(user).put(ip, logs.get(user).get(ip) + 1);
            }

            line = scanner.nextLine();
        }

        for (String entry : logs.keySet()) {
            System.out.println(entry + ": ");
            LinkedHashMap<String, Integer> ips = logs.get(entry);
            List<String> result = new ArrayList<>();
            for (String ip : ips.keySet()) {
                result.add(ip + " => " + ips.get(ip));
            }
            System.out.println(String.join(", ", result) + ".");
        }
    }
}
