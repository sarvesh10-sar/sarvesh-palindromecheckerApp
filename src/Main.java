import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // UC5: Remove spaces + Case insensitive
        String processed = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();

        if (processed.equals(reversed)) {
            System.out.println("Palindrome (ignoring spaces & case)");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}