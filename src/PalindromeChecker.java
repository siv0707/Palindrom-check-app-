import java.util.Stack;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input handling based on provided snapshots
        System.out.print("Input : ");
        String input = scanner.nextLine();

        boolean result = isPalindromeUsingStack(input);

        // Output formatting to match your console goal
        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }

    public static boolean isPalindromeUsingStack(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        // 1. Initialize the Stack
        Stack<Character> stack = new Stack<>();

        // 2. Push characters into stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // 3. Pop and compare with the original characters
        for (int i = 0; i < str.length(); i++) {
            char poppedChar = stack.pop();
            if (str.charAt(i) != poppedChar) {
                return false; // Not a palindrome
            }
        }

        return true; // Match found
    }
}