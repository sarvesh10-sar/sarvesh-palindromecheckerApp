import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    // Interface for palindrome methods
    interface PalindromeStrategy {
        boolean checkPalindrome(String text);
        String getName(); // for display
    }

    // 1️⃣ Stack method
    static class StackStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String text) {
            Stack<Character> stack = new Stack<>();
            for (char c : text.toCharArray()) stack.push(c);
            for (char c : text.toCharArray())
                if (stack.pop() != c) return false;
            return true;
        }
        public String getName() { return "Stack Method"; }
    }

    // 2️⃣ Deque method
    static class DequeStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String text) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : text.toCharArray()) deque.addLast(c);
            while (deque.size() > 1)
                if (!deque.removeFirst().equals(deque.removeLast())) return false;
            return true;
        }
        public String getName() { return "Deque Method"; }
    }

    // 3️⃣ Simple loop method
    static class SimpleLoopStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String text) {
            int n = text.length();
            for (int i = 0; i < n/2; i++)
                if (text.charAt(i) != text.charAt(n-1-i)) return false;
            return true;
        }
        public String getName() { return "Simple Loop Method"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to test:");
        String input = sc.nextLine();

        // Create strategy objects
        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new SimpleLoopStrategy()
        };

        // Run each strategy and measure time
        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean result = strategy.checkPalindrome(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println(strategy.getName() + ": " +
                    (result ? "Palindrome" : "Not Palindrome") +
                    " | Time: " + duration + " ns");
        }
    }
}