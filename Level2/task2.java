// Task: Password Strength Checker

// Description: Create a program that checks the
// strength of a password. Prompt the user to input a
// password and analyze its strength based on
// certain criteria, such as length, presence of
// uppercase letters, lowercase letters, numbers,
// and special characters. Provide feedback on the
// password strength.

// Skills: String manipulation, conditional
// statements.

import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Password Strength Checker ===");
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int score = 0;

        // Criteria checks
        if (password.length() >= 8) {
            score++;
        }
        if (password.matches(".*[a-z].*")) {
            score++;
        }
        if (password.matches(".*[A-Z].*")) {
            score++;
        }
        if (password.matches(".*[0-9].*")) {
            score++;
        }
        if (password.matches(".*[!@#$%^&*()_+\\-={}|\\[\\]:\";'<>?,./`~].*")) {
            score++;
        }

        // Feedback based on score
        String strength;
        switch (score) {
            case 5:
                strength = "Very Strong";
                break;
            case 4:
                strength = "Strong";
                break;
            case 3:
                strength = "Moderate";
                break;
            case 2:
                strength = "Weak";
                break;
            default:
                strength = "Very Weak";
        }

        System.out.println("Password Strength: " + strength);
    }
}
