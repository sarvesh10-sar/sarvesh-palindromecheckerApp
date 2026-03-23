import java.util.Scanner;

public class Main {

    // Normalize string: remove spaces + symbols + convert to lowercase
    public static String normalize(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Check palindrome after normalization
    public static boolean isPalindromeUC10(String s) {
        String normalized = normalize(s);

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("UC10: Case-Insensitive & Space-Ignored Palindrome Checker");
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        if (isPalindromeUC10(text)) {
            System.out.println("Result: YES, it is a palindrome (ignoring spaces & case)");
        } else {
            System.out.println("Result: NO, it is NOT a palindrome");
        }
    }
}