import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\nStudent Management System");
            System.out.println("1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();

                    students.add(new Student(name, marks));
                    System.out.println("Student added successfully");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found");
                    } else {
                        for (Student s : students) {
                            System.out.println("Name: " + s.name + " | Marks: " + s.marks);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
