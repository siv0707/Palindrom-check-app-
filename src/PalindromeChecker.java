public class PalindromeChecker {


        public static void main(String[] args) {
            String input = "radar"; // As seen in your screenshot

            boolean result = isPalindrome(input);

            System.out.println("Input : " + input);
            System.out.println("Is Palindrome? : " + result);
        }

        public static boolean isPalindrome(String str) {
            if (str == null) return false;

            // Step 1: Convert string to char array
            char[] charArray = str.toCharArray();

            // Step 2: Initialize two pointers
            int left = 0;
            int right = charArray.length - 1;

            // Step 3: Compare characters moving inward
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false; // Mismatch found
                }
                left++;
                right--;
            }

            return true; // All characters matched
        }
}
