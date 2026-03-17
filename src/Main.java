import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // UC6: Remove spaces + special characters + case insensitive
        String processed = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();

        if (processed.equals(reversed)) {
            System.out.println("Palindrome (ignoring spaces, case, symbols)");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}