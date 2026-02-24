public class PalindromeChecker {

        public static void main(String[] args) {

            // Hardcoded input string
            String input = "madam";

            // Reverse the string using the loop from last to first
            String reversed = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                reversed = reversed + input.charAt(i);
            }

            // Compare original and reversed strings
            boolean isPalindrome = input.equals(reversed);

            // Display results
            System.out.println("Input text: " + input);
            System.out.println("Reversed text: " + reversed);
            System.out.println("Is it a Palindrome? : " + isPalindrome);
        }
    }
