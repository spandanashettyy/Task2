import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        String input;
        System.out.println("Welcome to the Student Grades Manager!");

        // Input grades
        while (true) {
            System.out.print("Enter a grade (or type 'done' to finish): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                double grade = Double.parseDouble(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Please enter a grade between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value or 'done'.");
            }
        }

        // Calculate average
        if (grades.size() > 0) {
            double average = calculateAverage(grades);
            char letterGrade = getLetterGrade(average);
            double gpa = getGPA(letterGrade);

            System.out.println("\n--- Grade Summary ---");
            System.out.printf("Grades entered: %s%n", grades);
            System.out.printf("Average grade: %.2f%n", average);
            System.out.printf("Letter grade: %c%n", letterGrade);
            System.out.printf("GPA: %.2f%n", gpa);
        } else {
            System.out.println("No grades were entered.");
        }
    }

    // Method to calculate the average grade
    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Method to determine the letter grade
    private static char getLetterGrade(double average) {
        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 60) return 'D';
        return 'F';
    }

    // Method to calculate GPA based on the letter grade
    private static double getGPA(char letterGrade) {
        switch (letterGrade) {
            case 'A': return 4.0;
            case 'B': return 3.0;
            case 'C': return 2.0;
            case 'D': return 1.0;
            default: return 0.0;
        }
    }
}