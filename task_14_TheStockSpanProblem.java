import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class task_14_TheStockSpanProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int priceLines = Integer.parseInt(scanner.nextLine());
        int[] spans = new int[priceLines];
        for (int i = 0; i < priceLines; i++) {
            spans[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(getSpans(spans));
    }

    private static String getSpans(int[] spanArr) {
        Deque<Integer> stocks = new ArrayDeque<>();
        stocks.push(0);

        StringBuilder builder = new StringBuilder();
        builder.append(1).append("\n");
        for (int i = 1; i < spanArr.length; i++) {
            while (!stocks.isEmpty() && spanArr[stocks.peek()] <= spanArr[i]) {
                stocks.pop();
            }
            if (!stocks.isEmpty()) {
                builder.append(i - stocks.peek()).append("\n");
            } else {
                builder.append(i + 1).append("\n");
            }
            stocks.push(i);
        }

        return builder.toString();
    }
}
