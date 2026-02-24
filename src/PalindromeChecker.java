import java.util.Scanner;

class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; }
}

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();

        Node head = buildList(input);
        boolean result = isPalindrome(head);

        System.out.println("Is Palindrome? : " + result);
        scanner.close();
    }

    private static Node buildList(String str) {
        if (str.isEmpty()) return null;
        Node head = new Node(str.charAt(0));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using Fast & Slow pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        Node prev = null, current = slow, nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 3: Compare halves
        Node left = head, right = prev;
        while (right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}