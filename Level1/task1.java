// Task: Temperature Converter

// Description: Create a program that converts
// temperatures between Celsius and
// Fahrenheit. Prompt the user to enter a
// temperature value and the unit of
// measurement, and then perform the
// conversion. Display the converted
// temperature.

// Skills: Basic input/output operations,
// arithmetic operations.

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float celsius, fahrenheit;
        boolean restart = true;
        while (restart) {
            System.out.println("Main Menu : ");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius : ");
                    celsius = sc.nextFloat();
                    fahrenheit = (float) (celsius * 9 / 5) + 32;
                    System.out.println(celsius + "°C is equal to " + fahrenheit + "°");
                    break;
                case 2:
                    System.out.print("Enter temperature in Fahrenheit : ");
                    fahrenheit = sc.nextFloat();
                    celsius = (float) (fahrenheit - 32) * 5 / 9;
                    System.out.println(fahrenheit + "°F is equal to " + celsius + "°");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    restart = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}