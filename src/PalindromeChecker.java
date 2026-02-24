import java.util.Scanner;
import java.util.Stack;

/**
 * PalindromeService handles the core logic for palindrome validation.
 * It uses a Stack data structure as per UC11 requirements.
 */
class PalindromeService {

    /**
     * UC11: Exposes checkPalindrome() method to validate input.
     * Uses a Stack to strengthen data structure concepts.
     */
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Normalization (Applying logic from UC10 for consistency)
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        // Pop from stack and compare with original string
        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the Service Object (Encapsulation)
        PalindromeService service = new PalindromeService();

        System.out.print("Input : ");
        String input = scanner.nextLine();

        // Call the exposed method
        boolean result = service.checkPalindrome(input);

        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }
}