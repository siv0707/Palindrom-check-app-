import java.util.*;

/**
 * UC12: Strategy Pattern for Palindrome Algorithms
 * This version uses unique class names to avoid conflicts with previous UCs.
 */

// 1. The Strategy Interface must be defined for the Context to find it
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// 2. Stack-based implementation
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) stack.push(c);

        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// 3. Deque-based implementation
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : cleaned.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

/**
 * 4. The Context Class (Renamed from PalindromeChecker to avoid UC11 conflict)
 * This class "has-a" strategy and uses it to perform the check.
 */
class PalindromeStrategyContext {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.isPalindrome(input);
    }
}

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Use the renamed Context class
        PalindromeStrategyContext context = new PalindromeStrategyContext();

        System.out.print("Input : ");
        String input = scanner.nextLine();

        // Dynamically choose a strategy at runtime
        context.setStrategy(new DequeStrategy());
        boolean result = context.check(input);

        System.out.println("Is Palindrome? : " + result);
        scanner.close();
    }
}