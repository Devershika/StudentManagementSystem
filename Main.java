import java.util.*;

class Main {
    public static void main(String args[]) {
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

            
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter PRN: ");
                    int prn = Integer.parseInt(scan.nextLine()); // FIXED: Missing semicolon
                    System.out.print("Enter Branch: ");
                    String branch = scan.nextLine();
                    System.out.print("Enter Batch: ");
                    String batch = scan.nextLine();
                    System.out.print("Enter CGPA: ");
                    float cgpa = Float.parseFloat(scan.nextLine());

                    operations.addStudent(new Student(name, prn, branch, batch, cgpa));
                    break; // FIXED: Ensured break is properly placed

                case 2:
                    operations.displayStudents();
                    break;

                
                case 3:
                    System.out.print("Enter PRN to search: ");
                    prn = Integer.parseInt(scan.nextLine());
                    Student student = operations.searchStudentByPRN(prn);
                    if (student != null)
                        student.display();
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter Name to search: ");
                    name = scan.nextLine();
                    List<Student> studentsByName = operations.searchStudentByName(name);
                    if (!studentsByName.isEmpty())
                        studentsByName.forEach(Student::display);
                    else
                        System.out.println("No students found with this name.");
                    break;

                
                case 5:
                    System.out.print("Enter Branch to search: ");
                    branch = scan.nextLine();
                    List<Student> studentsByBranch = operations.searchStudentByBranch(branch);
                    if (!studentsByBranch.isEmpty())
                        studentsByBranch.forEach(Student::display);
                    else
                        System.out.println("No students found in this branch.");
                    break;

                case 6:
                    System.out.print("Enter PRN to update: ");
                    prn = Integer.parseInt(scan.nextLine());
                    System.out.print("Enter new Name: ");
                    name = scan.nextLine();
                    System.out.print("Enter new Branch: ");
                    branch = scan.nextLine();
                    System.out.print("Enter new Batch: ");
                    batch = scan.nextLine();
                    System.out.print("Enter new CGPA: ");
                    cgpa = Float.parseFloat(scan.nextLine());

                    operations.updateStudent(prn, name, branch, batch, cgpa);
                    break;

                
                case 7:
                    System.out.print("Enter PRN to delete: ");
                    prn = Integer.parseInt(scan.nextLine());
                    operations.deleteStudent(prn);
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            } // FIXED: Ensured switch block closes properly

        } while (choice != 8); // FIXED: Proper loop closure

        scan.close(); // FIXED: Ensure scanner closes properly
    }
}




                    

