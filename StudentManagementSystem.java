import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int rollNo;
    String name;
    String grade;

    Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }
}

public class StudentManagementSystem {

    public static boolean isValidGrade(String grade) {
        return grade.equalsIgnoreCase("A") ||
               grade.equalsIgnoreCase("B") ||
               grade.equalsIgnoreCase("C") ||
               grade.equalsIgnoreCase("D") ||
               grade.equalsIgnoreCase("F");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    String grade;

                    while (true) {
                        System.out.print("Enter Grade (A/B/C/D/F): ");
                        grade = sc.nextLine();

                        if (isValidGrade(grade)) {
                            break;
                        } else {
                            System.out.println("Invalid grade. Please enter A, B, C, D, or F.");
                        }
                    }

                    students.add(new Student(roll, name, grade));

                    System.out.println("Student added successfully.");
                    break;

                case 2:

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            System.out.println("Roll: " + s.rollNo + " | Name: " + s.name + " | Grade: " + s.grade);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNo == searchRoll) {
                            System.out.println("Student Found:");
                            System.out.println("Name: " + s.name);
                            System.out.println("Grade: " + s.grade);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Roll Number to update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();

                    for (Student s : students) {

                        if (s.rollNo == updateRoll) {

                            System.out.print("Enter new name: ");
                            s.name = sc.nextLine();

                            String newGrade;

                            while (true) {
                                System.out.print("Enter new grade (A/B/C/D/F): ");
                                newGrade = sc.nextLine();

                                if (isValidGrade(newGrade)) {
                                    s.grade = newGrade;
                                    break;
                                } else {
                                    System.out.println("Invalid grade. Enter A, B, C, D, or F.");
                                }
                            }

                            System.out.println("Student updated successfully.");
                        }
                    }

                    break;

                case 5:

                    System.out.print("Enter Roll Number to remove: ");
                    int removeRoll = sc.nextInt();

                    students.removeIf(s -> s.rollNo == removeRoll);

                    System.out.println("Student removed if existed.");

                    break;

                case 6:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        } while (choice != 6);

        sc.close();
    }
}