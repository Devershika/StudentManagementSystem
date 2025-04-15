import java.util.*;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentOperations operations = new StudentOperations();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Search Student by Branch");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scan.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter PRN: ");
                        int prn = Integer.parseInt(scan.nextLine());
                        System.out.print("Enter Branch: ");
                        String branch = scan.nextLine();
                        System.out.print("Enter Batch: ");
                        String batch = scan.nextLine();
                        System.out.print("Enter CGPA: ");
                        float cgpa = Float.parseFloat(scan.nextLine());

                        operations.addStudent(new Student(name, prn, branch, batch, cgpa));
                        break;

                    case 2:
                        operations.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter PRN to search: ");
                        prn = Integer.parseInt(scan.nextLine());
                        operations.searchStudentByPRN(prn).display();
                        break;

                    case 4:
                        System.out.print("Enter Name to search: ");
                        name = scan.nextLine();
                        List<Student> nameResults = operations.searchStudentByName(name);
                        if (nameResults.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            nameResults.forEach(Student::display);
                        }
                        break;

                    case 5:
                        System.out.print("Enter Branch to search: ");
                        branch = scan.nextLine();
                        List<Student> branchResults = operations.searchStudentByBranch(branch);
                        if (branchResults.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            branchResults.forEach(Student::display);
                        }
                        break;

                    case 6:
                        System.out.print("Enter PRN to update: ");
                        prn = Integer.parseInt(scan.nextLine());
                        System.out.print("Enter New Name: ");
                        name = scan.nextLine();
                        System.out.print("Enter New Branch: ");
                        branch = scan.nextLine();
                        System.out.print("Enter New Batch: ");
                        batch = scan.nextLine();
                        System.out.print("Enter New CGPA: ");
                        cgpa = Float.parseFloat(scan.nextLine());

                        operations.updateStudent(prn, name, branch, batch, cgpa);
                        break;

                    case 7:
                        System.out.print("Enter PRN to delete: ");
                        prn = Integer.parseInt(scan.nextLine());
                        operations.deleteStudent(prn);
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 8);
    }
}
