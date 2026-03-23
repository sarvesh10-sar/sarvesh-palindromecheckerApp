import java.util.Scanner;

public class Main {

    // Recursive function
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("UC9 - Recursive Palindrome Checker");
        System.out.print("Enter a string: ");

        String str = sc.nextLine();

        // Call recursive function
        if (isPalindromeRecursive(str, 0, str.length() - 1)) {
            System.out.println(str + " is a Palindrome ✅");
        } else {
            System.out.println(str + " is NOT a Palindrome ❌");
        }

        sc.close();
    }
}