import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class task_03_MaximumElement {
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxElements = new ArrayDeque<>();
        int lines = Integer.parseInt(reader.readLine());

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lines; i++) {
            String[] line = reader.readLine().split("\\s+");
            String command = line[0];
            switch (command) {
                case "1":
                    int num = Integer.parseInt(line[1]);
                    if (num > max) {
                        max = num;
                        maxElements.push(num);
                    }
                    stack.push(num);
                    break;
                case "2":
                    int currNum = stack.pop();
                    if (currNum == max) {
                        maxElements.pop();
                        if (!maxElements.isEmpty()) {
                            max = maxElements.peek();
                        } else {
                            max = Integer.MIN_VALUE;
                        }
                    }

                    break;
                case "3":
                    System.out.println(maxElements.peek());
                    break;
            }
        }
    }
}
