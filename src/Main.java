// File: PalindromeChecker.java
import java.util.Stack;

public class PalindromeChecker {

    private String text; // Encapsulated property

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check palindrome using Stack
    public boolean checkPalindrome() {
        Stack<Character> stack = new Stack<>();
        int n = text.length();

        // Push all characters into the stack
        for (int i = 0; i < n; i++) {
            stack.push(text.charAt(i));
        }

        // Pop characters and compare with original
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) != stack.pop()) {
                return false; // Not a palindrome
            }
        }
        return true; // Palindrome
    }

    // Optional setter/getter
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}