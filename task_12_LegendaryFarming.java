import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class task_12_LegendaryFarming {
    public static void main(String[] args) {
        final int neededQuantity = 250;
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> legendaryItems = new TreeMap<>();
        legendaryItems.put("shards", 0);
        legendaryItems.put("fragments", 0);
        legendaryItems.put("motes", 0);
        TreeMap<String, Integer> junkItems = new TreeMap<>();

        String line = scanner.nextLine();
        while (!line.equals("")) {
            boolean isObtained = false;
            String[] params = line.split("\\s+");
            for (int i = 0; i < params.length; i += 2) {
                String material = params[i + 1].toLowerCase();
                int quantity = Integer.parseInt(params[i]);
                if (!material.equals("shards") && !material.equals("fragments") && !material.equals("motes")) {
                    if (!junkItems.containsKey(material)) {
                        junkItems.put(material, 0);
                    }
                    junkItems.put(material, junkItems.get(material) + quantity);
                } else {
                    legendaryItems.put(material, legendaryItems.get(material) + quantity);
                    if (legendaryItems.get(material) >= neededQuantity) {
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        isObtained = true;
                        legendaryItems.put(material, legendaryItems.get(material) - neededQuantity);
                        break;
                    }
                }

            }
            if (isObtained) {
                break;
            } else {
                line = scanner.nextLine();
            }
        }

        LinkedHashMap<String, Integer> sortedLegendary =
            legendaryItems.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x, y) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new
                    ));
        for (String item : sortedLegendary.keySet()) {
            System.out.println(item + ": " + sortedLegendary.get(item));
        }
        for (String junk : junkItems.keySet()) {
            System.out.println(junk + ": " + junkItems.get(junk));
        }
    }
}
