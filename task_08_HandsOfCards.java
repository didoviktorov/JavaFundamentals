import java.util.*;

public class task_08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("JOKER")) {
            String[] params = line.split(": ");
            String player = params[0];
            List<String> cards = Arrays.asList(params[1].split(", "));
            if (!players.containsKey(player)) {
                players.put(player, new HashSet<>());
            }
            players.get(player).addAll(cards);
            line = scanner.nextLine();
        }

        for (String pl : players.keySet()) {
            int value = 0;
            for (String card : players.get(pl)) {
                value += calculateCard(card);
            }
            System.out.println(pl + ": " + value);
        }
    }

    private static int calculateCard(String c) {
        int result = 0;
        String type = c.substring(c.length() - 1);
        int multiplier = 0;
        switch (type) {
            case "S":
                multiplier = 4;
                break;
            case "H":
                multiplier = 3;
                break;
            case "D":
                multiplier = 2;
                break;
            case "C":
                multiplier = 1;
                break;
        }
        String power = c.substring(0, c.length() - 1);
        int powerMultiplier = 0;
        switch (power) {
            case "J":
                powerMultiplier = 11;
                break;
            case "Q":
                powerMultiplier = 12;
                break;
            case "K":
                powerMultiplier = 13;
                break;
            case "A":
                powerMultiplier = 14;
                break;
                default:
                    powerMultiplier = Integer.parseInt(power);
                    break;
        }
        result = powerMultiplier * multiplier;
        return result;
    }
}
