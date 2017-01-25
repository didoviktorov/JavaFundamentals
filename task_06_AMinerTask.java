import java.util.LinkedHashMap;
import java.util.Scanner;

public class task_06_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Long> materials = new LinkedHashMap<>();

        String param = scanner.nextLine();
        while (!param.equals("stop")) {
            Long quantity = Long.parseLong(scanner.nextLine());
            if (!materials.containsKey(param)) {
                materials.put(param, 0L);
            }
            materials.put(param, materials.get(param) + quantity);
            param = scanner.nextLine();
        }
        for (String material : materials.keySet()) {
            System.out.println(material + " -> " + materials.get(material));
        }
    }
}
