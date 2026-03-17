import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String lower = str.toLowerCase();
        String rev = new StringBuilder(lower).reverse().toString();

        if(lower.equals(rev)) {
            System.out.println("Palindrome (case-insensitive)");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}