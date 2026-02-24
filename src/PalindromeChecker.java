import java.util.Scanner;

/**
 * UC10: Case-Insensitive & Space-Ignored Palindrome Checker
 * This application validates if a string is a palindrome by normalizing it first.
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get Input
        System.out.print("Input : ");
        String input = scanner.nextLine();

        // 2. Normalize string (String preprocessing)
        // [^a-zA-Z0-9] is a Regular Expression that matches everything except letters and numbers
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 3. Apply logic (Two-pointer approach)
        boolean isPalindrome = checkPalindrome(normalized);

        // 4. Output Result
        System.out.println("Is Palindrome? : " + isPalindrome);

        scanner.close();
    }

    /**
     * Helper method to check if a pre-processed string reads the same forward and backward.
     */
    private static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}