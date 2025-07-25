// Task: Palindrome Checker

// Description: Implement a program that checks
// whether a given word or phrase is a palindrome. A
// palindrome is a word or phrase that reads the
// same forwards and backward, ignoring spaces and
// punctuation.

// Skills: String manipulation, loops, conditional
// statements.
import java.util.*;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word or phrase: ");
        String input = sc.nextLine();
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanInput).reverse().toString();
        if (cleanInput.equals(reversed)) {
            System.out.println("The word or phrase is a palindrome.");
        } else {
            System.out.println("The word or phrase is not a palindrome.");
        }
    }
}
