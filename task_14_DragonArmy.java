import java.util.*;

public class task_14_DragonArmy {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        final String defaultHealth = "250";
        final String defaultDamage = "45";
        final String defaultArmor = "10";

        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, List<String>>> typeDragons = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
             String[] params = scanner.nextLine().split("\\s+");
             String type = params[0];
             String dragon = params[1];
             String damage = params[2];
             String health = params[3];
             String armor = params[4];

            if (damage.equals("null")) {
                damage = defaultDamage;
            }
            if (health.equals("null")) {
                health = defaultHealth;
            }
            if (armor.equals("null")) {
                armor = defaultArmor;
            }

            if (!typeDragons.containsKey(type)) {
                typeDragons.put(type, new TreeMap<>());
            }
            typeDragons.get(type).put(dragon, new ArrayList<>());
            typeDragons.get(type).get(dragon).add(damage);
            typeDragons.get(type).get(dragon).add(health);
            typeDragons.get(type).get(dragon).add(armor);
        }

        for (Map.Entry<String, TreeMap<String, List<String>>> dragonEntry : typeDragons.entrySet()) {
            int count = 0;
            double damage = 0;
            double health = 0;
            double armor = 0;
            StringBuilder outLine = new StringBuilder();
            TreeMap<String, List<String>> dragons = typeDragons.get(dragonEntry.getKey());
            for (String dragon : dragons.keySet()) {
                damage += Double.parseDouble(dragons.get(dragon).get(0));
                health += Double.parseDouble(dragons.get(dragon).get(1));
                armor += Double.parseDouble(dragons.get(dragon).get(2));
                outLine
                        .append("-" + dragon + " -> " +
                                "damage: " + dragons.get(dragon).get(0) + ", " +
                                "health: " + dragons.get(dragon).get(1) + ", " +
                                "armor: " + dragons.get(dragon).get(2))
                        .append("\n");
                count++;
            }
            String firstLine = String.format(
                    "%s::(%.2f/%.2f/%.2f)", dragonEntry.getKey(), damage / count, health / count, armor / count);
            System.out.println(firstLine);
            System.out.printf("%s", outLine.toString());
        }
    }
}
