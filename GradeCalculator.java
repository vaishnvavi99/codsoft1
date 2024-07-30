import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("Enter marks obtained in subject %d (out of 100): ", i + 1);
            marks[i] = scanner.nextInt();
        }

        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        String grade = calculateGrade(averagePercentage);

        System.out.printf("Total Marks: %d%n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.printf("Grade: %s%n", grade);

        scanner.close();
    }

    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
