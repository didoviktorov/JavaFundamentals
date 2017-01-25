import java.util.Scanner;
import java.util.TreeMap;

public class task_04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] symbols = scanner.nextLine().toCharArray();
        TreeMap<Character, Integer> occurrences = new TreeMap<>();
        for (int i = 0; i < symbols.length; i++) {
            if (!occurrences.containsKey(symbols[i])) {
                occurrences.put(symbols[i], 1);
            } else {
                occurrences.put(symbols[i], occurrences.get(symbols[i]) + 1);
            }
        }

        for (Character c : occurrences.keySet()) {
            System.out.println(c + ": " + occurrences.get(c) + " time/s");
        }
    }
}