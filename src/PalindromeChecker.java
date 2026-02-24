import java.util.Stack;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Console input as per instructions
        System.out.print("Input : ");
        String input = scanner.nextLine();

        // Data Structure: Stack used for validation
        boolean result = isPalindromeUsingStack(input);

        // Output result format based on your snapshots
        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }

    public static boolean isPalindromeUsingStack(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Initialize Stack linear data structure
        Stack<Character> charStack = new Stack<>();

        // Push Operation: Inserting characters into the stack
        for (int i = 0; i < str.length(); i++) {
            charStack.push(str.charAt(i));
        }

        // Pop Operation: Reversing order for comparison
        for (int i = 0; i < str.length(); i++) {
            char poppedChar = charStack.pop();
            if (str.charAt(i) != poppedChar) {
                return false; // Not a palindrome
            }
        }

        return true;
    }
}