import java.util.Scanner;

class Student {
    private String name;
    private double[] grades;

    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public double[] getGrades() {
        return grades;
    }

    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public char determineGrade() {
        double average = calculateAverage();
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        
        double[] grades = new double[numGrades];
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        Student student = new Student(name, grades);

        System.out.println("Student: " + student.getName());
        System.out.println("Average: " + student.calculateAverage());
        System.out.println("Final Grade: " + student.determineGrade());

        scanner.close();
    }
}
