// Task : File Encryptor/Decryptor
// Description: Create a program that encrypts or
// decrypts the contents of a text file using a simple
// encryption algorithm. Prompt the user to choose
// between encryption or decryption, and input the
// file name or path. Encrypt or decrypt the file
// accordingly and save the result to a new file.

// Skills: File handling, string manipulation, basic
// input/output operations.

import java.io.*;
import java.util.Scanner;

public class task3 {

    // Shift value for Caesar Cipher
    private static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== File Encryptor/Decryptor ===");
        System.out.print("Enter 'e' to Encrypt or 'd' to Decrypt: ");
        char choice = sc.next().toLowerCase().charAt(0);
        sc.nextLine(); // Consume newline

        if (choice != 'e' && choice != 'd') {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        System.out.print("Enter output file path: ");
        String outputPath = sc.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

            String line;
            while ((line = reader.readLine()) != null) {
                String resultLine = (choice == 'e') ? encrypt(line) : decrypt(line);
                writer.write(resultLine);
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Operation completed successfully!");

        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }

    // Encrypt using Caesar Cipher
    public static String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            result.append((char) (ch + SHIFT));
        }
        return result.toString();
    }

    // Decrypt using Caesar Cipher
    public static String decrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            result.append((char) (ch - SHIFT));
        }
        return result.toString();
    }
}
