import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class task_11_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Deque<StringBuilder> beforeText = new ArrayDeque<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] params = scanner.nextLine().split("\\s");
            String command = params[0];
            switch (command) {
                case "1":
                    beforeText.push(new StringBuilder(text));
                    text.append(params[1]);
                    break;
                case "2":
                    int startIndex = text.length() - Integer.parseInt(params[1]);
                    beforeText.push(new StringBuilder(text));
                    text.delete(startIndex, text.length());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(params[1]) - 1));
                    break;
                case "4":
                    text = new StringBuilder(beforeText.pop());
                    break;
            }

        }
    }
}
