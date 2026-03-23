import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    // Interface (promise)
    interface PalindromeStrategy {
        boolean checkPalindrome(String text);
    }

    // Stack method
    static class StackStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String text) {
            Stack<Character> stack = new Stack<>();
            for (char c : text.toCharArray()) stack.push(c);
            for (char c : text.toCharArray())
                if (stack.pop() != c) return false;
            return true;
        }
    }

    // Deque method
    static class DequeStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String text) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : text.toCharArray()) deque.addLast(c);
            while (deque.size() > 1)
                if (!deque.removeFirst().equals(deque.removeLast())) return false;
            return true;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word:");
        String input = sc.nextLine();

        System.out.println("Choose method: 1 = Stack, 2 = Deque");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) strategy = new StackStrategy();
        else strategy = new DequeStrategy();

        if (strategy.checkPalindrome(input))
            System.out.println(input + " is a palindrome!");
        else
            System.out.println(input + " is NOT a palindrome!");
    }
}