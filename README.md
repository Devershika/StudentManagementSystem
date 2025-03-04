# StudentManagementSystem

This Java-based Student Management System allows users to perform various operations on student records, such as adding, searching, updating, and deleting student details. The program uses a menu-driven approach to interact with the user and employs a Scanner for input handling.

## Features

* Add Student: Allows the user to input student details including Name, PRN, Branch, Batch, and CGPA.

* Display All Students: Lists all students currently stored in the system.

* Search Student by PRN: Retrieves a student’s details using their unique PRN.

* Search Student by Name: Displays all students that match a given name.

* Search Student by Branch: Lists all students belonging to a specific branch.

* Update Student: Modifies the details of an existing student using PRN as an identifier.

* Delete Student: Removes a student’s record from the system.

* Exit: Terminates the program.

## Prerequisites

Ensure you have the following installed:

Java Development Kit (JDK 8 or later)

An IDE or terminal for executing Java programs


## Code Structure

* Main.java: Contains the main method and user interaction logic.

* Student.java (to be implemented if not already included): Defines the Student class with attributes and display methods.

* StudentOperations.java (to be implemented): Handles CRUD operations on student records using a List<Student>.

Example Usage

Menu:
1. Add Student
2. Display All Students
3. Search Student by PRN
4. Search Student by Name
5. Search Student by Branch
6. Update Student
7. Delete Student
8. Exit
Enter your choice: 1
Enter Name: John Doe
Enter PRN: 12345
Enter Branch: Computer Science
Enter Batch: 2025
Enter CGPA: 8.9
Student added successfully!


