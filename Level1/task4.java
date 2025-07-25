// Task: Random Password Generator

// Description: Build a program that generates a
// random password for the user. Prompt the user to
// enter the desired length of the password and
// specify whether it should include numbers,
// lowercase letters, uppercase letters, and special
// characters. Generate the password accordingly
// and display it to the user.

// Skills: Random number generation, string
// manipulation, user input.

import java.util.Random;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numbers = "1234567890";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_+-={}:<>?";

        System.out.println("------ Random Password Generator ------");
        System.out.println("Enter the desired length of the password:");
        int length = sc.nextInt();
        sc.nextLine();

        System.out.println("Include Numbers? (y/n) : ");
        Boolean includeNumbers = sc.nextLine().equalsIgnoreCase("y");
        System.out.println("Include Lowercase Letters? (y/n) : ");
        Boolean includeLowerCase = sc.nextLine().equalsIgnoreCase("y");
        System.out.println("Include Uppercase Letters? (y/n) : ");
        Boolean includeUpperCase = sc.nextLine().equalsIgnoreCase("y");
        System.out.println("Include Special Characters? (y/n) : ");
        Boolean includeSpecialChars = sc.nextLine().equalsIgnoreCase("y");
        sc.nextLine();

        String SelectedChar = "";

        if (includeNumbers)
            SelectedChar += numbers;
        if (includeLowerCase)
            SelectedChar += lowerCase;
        if (includeUpperCase)
            SelectedChar += upperCase;
        if (includeSpecialChars)
            SelectedChar += specialChars;

        if (SelectedChar.isEmpty()) {
            System.out.println("Please Select atleast one Type...!!");
        }

        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(SelectedChar.length());
            password.append(SelectedChar.charAt(index));
        }
        System.out.println("Generated Password : " + password.toString());
    }
}
