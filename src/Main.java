import java.util.Scanner;

// UC11 - Object-Oriented Palindrome Service
class PalindromeChecker {

    // Encapsulated checkPalindrome() method
    public boolean checkPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase(); // normalization

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

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("=== UC11: OOPS-Based Palindrome Checker ===");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Using the PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Palindrome!");
        } else {
            System.out.println("Not a Palindrome.");
        }
    }
}