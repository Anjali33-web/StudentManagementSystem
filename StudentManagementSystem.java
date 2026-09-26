import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            try {

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        System.out.println("Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");

                }

            } catch (Exception e) {

                System.out.println("Invalid input. Please enter a number.");

                sc.nextLine();
            }
        }
    }

    // Add Student
    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        // Check duplicate ID
        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("Student ID already exists.");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student student = new Student(id, name, age, course);

        students.add(student);

        System.out.println("Student added successfully.");
    }

    // View Students
    static void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students available.");
            return;
        }

        System.out.println("\n===== Student List =====");

        for (Student student : students) {

            student.displayStudent();
        }
    }

    // Search Student
    static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("Student found:");
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update Student
    static void updateStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {

                sc.nextLine();

                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                System.out.print("Enter new age: ");
                int age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter new course: ");
                String course = sc.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setCourse(course);

                System.out.println("Student updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}