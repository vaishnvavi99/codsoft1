import java.util.Scanner;

public class StudentResults {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSubjects;

        System.out.print("Enter the number of subjects: ");
        totalSubjects = scanner.nextInt();

        int[] marks = new int[totalSubjects];
        int totalMarks = 0;

        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / totalSubjects;
        char grade = calculateGrade(averagePercentage);

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
