import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class task_13_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> srabsko = new LinkedHashMap<>();
        String pattern = "^([A-Za-z ]+?)\\s@([A-Za-z ]+?)\\s([0-9]{1,2}|1[0-9]{1,2}|200)\\s([0-9]{1,5}|100000)$";
        Pattern p = Pattern.compile(pattern);

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            Matcher m = p.matcher(line);
            if (m.find()) {
                String singer = m.group(1).trim();
                String revenue = m.group(2).trim();
                long ticketPrice = Long.parseLong(m.group(3));
                long count = Long.parseLong(m.group(4));
                if (!srabsko.containsKey(revenue)) {
                    srabsko.put(revenue, new LinkedHashMap<>());
                }
                if (!srabsko.get(revenue).containsKey(singer)) {
                    srabsko.get(revenue).put(singer, 0L);
                }
                srabsko.get(revenue).put(singer, srabsko.get(revenue).get(singer) + (ticketPrice * count));
            }


            line = scanner.nextLine();
        }

        for (String rev : srabsko.keySet()) {
            System.out.println(rev);
            LinkedHashMap<String, Long> sortedSinger =
                    srabsko.get(rev).entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (x, y) -> {
                                        throw new AssertionError();
                                    },
                                    LinkedHashMap::new
                            ));
            for (String singer : sortedSinger.keySet()) {
                System.out.println("#  " + singer + " -> " + sortedSinger.get(singer));
            }
        }
    }
}
