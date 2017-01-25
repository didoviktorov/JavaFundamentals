import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task_10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Long> countries = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> citiesByCountry = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("report")) {
            String[] params = line.split("[|]");
            String city = params[0];
            String country = params[1];
            int population = Integer.parseInt(params[2]);
            if (!countries.containsKey(country)) {
                countries.put(country, 0L);
            }
            countries.put(country, countries.get(country) + population);

            if (!citiesByCountry.containsKey(country)) {
                citiesByCountry.put(country, new LinkedHashMap<>());
            }
            citiesByCountry.get(country).put(city, population);
            line = scanner.nextLine();
        }

        LinkedHashMap<String, Long> sortedCountries =
                countries.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        for (String country : sortedCountries.keySet()) {
            System.out.println(country + " (total population: " + sortedCountries.get(country) + ")");
            LinkedHashMap<String, Integer> sortedCities = citiesByCountry.get(country).entrySet()
                    .stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x, y) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new
                    ));
            for (String city : sortedCities.keySet()) {
                System.out.println("=>" + city + ": " + sortedCities.get(city));
            }
        }
        System.out.println();
    }
}
