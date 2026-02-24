import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Console output matches the provided snapshots (radar, noon, civic, etc.)
        System.out.print("Input : ");
        String input = scanner.nextLine();

        boolean result = isPalindromeRecursive(input);

        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }

    /**
     * Recursive method to check if a string is a palindrome.
     * Uses the Call Stack as the primary memory structure.
     */
    public static boolean isPalindromeRecursive(String str) {
        // Base Condition: Strings of length 0 or 1 are palindromes
        if (str == null || str.length() <= 1) {
            return true;
        }

        // Compare start and end characters
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            // Recursive call with a smaller subproblem (the middle substring)
            return isPalindromeRecursive(str.substring(1, str.length() - 1));
        }

        // If characters don't match, it's not a palindrome
        return false;
    }
}