import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class PalindromeChecker { // START OF CLASS

    public static void main(String[] args) { // START OF METHOD
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();

        // This is inside a method, so it is allowed
        boolean result = isPalindromeUsingDeque(input);
        System.out.println("Is Palindrome? : " + result);
        scanner.close();
    } // END OF METHOD

    public static boolean isPalindromeUsingDeque(String str) { // START OF METHOD
        Deque<Character> deque = new ArrayDeque<>(); // Correct

        for (char ch : str.toCharArray()) {
            deque.addLast(ch); // Correct: inside a loop inside a method
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    } // END OF METHOD

} // END OF CLASS