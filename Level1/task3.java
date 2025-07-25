// Task: Student Grade Calculator

// Description: create a program that
// calculates and displays the average grade of
// a student. Prompt the user to enter the
// number of grades to be entered, and then
// input each grade. Calculate the average and
// display it to the user.

// Skills: Loops, arrays, basic arithmetic
// operations.

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Number of Grades : ");
        int num = sc.nextInt();
        double[] grades = new double[num];
        double sum = 0;
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Grade " + (i + 1) + ": ");
            grades[i] = sc.nextDouble();
            sum += grades[i];
        }
        double average = sum / num;
        System.out.println("Average Grade: " + average);
    }
}
