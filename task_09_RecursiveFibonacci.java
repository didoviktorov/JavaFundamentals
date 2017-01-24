//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.Scanner;
//
//public class task_09_RecursiveFibonacci {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int number  = Integer.parseInt(scanner.nextLine());
//
//        System.out.println(getFibonacci(number + 1).pop());
//    }
//
//    private static Deque<Long> getFibonacci (int num) {
//        if (num == 1) {
//            Deque<Long> fibNumbers = new ArrayDeque<>();
//            fibNumbers.push(1l);
//            return fibNumbers;
//        } else {
//            Deque<Long> fibNumbers = getFibonacci(num - 1);
//            Long number = fibNumbers.poll();
//            Long previousNumber = fibNumbers.poll();
//            if (previousNumber == null) {
//                previousNumber = Long.valueOf(0);
//            }
//            Long nextValue = previousNumber + number;
//            fibNumbers.push(number);
//            fibNumbers.push(nextValue);
//
//            return fibNumbers;
//        }
//    }
//}


 ////Using memoization
import java.util.Scanner;

public class task_09_RecursiveFibonacci {

    public static long fibArray[]=new long[51];

    public static void main(String args[]){
        fibArray[0]=1;
        fibArray[1]=1;
        Scanner scanner = new Scanner(System.in);
        long fibNum = fibonacci(Long.parseLong(scanner.nextLine()) + 1L);
        System.out.println(fibNum);
    }

    public static long fibonacci(long n){
        long fibValue = 0;
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(fibArray[(int)n]!= 0){
            return fibArray[(int)n];
        } else {
            fibValue = fibonacci(n - 1) + fibonacci(n - 2);
            fibArray[(int)n] = fibValue;
            return fibValue;
        }
    }
}