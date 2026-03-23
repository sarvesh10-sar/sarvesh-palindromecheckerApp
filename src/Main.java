import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    // Convert string to linked list
    public static Node convertToLinkedList(String str) {
        Node head = null, tail = null;

        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Reverse linked list
    public static Node reverse(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Check palindrome using linked list
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using slow & fast pointer
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);

        // Step 3: Compare first and second halves
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("UC8 - Linked List Based Palindrome Checker");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        Node head = convertToLinkedList(input);

        if (isPalindrome(head)) {
            System.out.println(input + " is a Palindrome ✔");
        } else {
            System.out.println(input + " is NOT a Palindrome ❌");
        }

        sc.close();
    }
}