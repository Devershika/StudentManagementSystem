import java.util.*;

public class StudentOperations {
    private ArrayList<Student> students;

    public StudentOperations() {
        this.students = new ArrayList<>();
    }

    // 1. Add Student
    public void addStudent(Student student) throws DuplicateStudentException, InvalidDataException {
        if (student.getCgpa() < 0 || student.getCgpa() > 10) {
            throw new InvalidDataException("CGPA must be between 0 and 10.");
        }

        for (Student s : students) {
            if (s.getPRN() == student.getPRN()) {
                throw new DuplicateStudentException("Student with PRN " + student.getPRN() + " already exists.");
            }
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    // 2. Display Students
    public void displayStudents() throws StudentNotFoundException {
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students available to display.");
        }
        for (Student student : students) {
            student.display();
        }
    }

    // 3. Search by PRN
    public Student searchStudentByPRN(int prn) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getPRN() == prn) {
                return student;
            }
        }
        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }

    // 4. Search by Name
    public List<Student> searchStudentByName(String name) throws StudentNotFoundException, InvalidDataException {
        if (name == null || name.isEmpty()) {
            throw new InvalidDataException("Name cannot be empty.");
        }

        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }

        if (result.isEmpty()) {
            throw new StudentNotFoundException("No student found with name: " + name);
        }

        return result;
    }

    // 5. Search by Branch
    public List<Student> searchStudentByBranch(String branch) throws StudentNotFoundException, InvalidDataException {
        if (branch == null || branch.isEmpty()) {
            throw new InvalidDataException("Branch cannot be empty.");
        }

        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getBranch().equalsIgnoreCase(branch)) {
                result.add(student);
            }
        }

        if (result.isEmpty()) {
            throw new StudentNotFoundException("No students found in branch: " + branch);
        }

        return result;
    }

    // 6. Update Student
    public void updateStudent(int prn, String newName, String newBranch, String newBatch, float newCGPA)
            throws StudentNotFoundException, InvalidDataException {
        Student student = searchStudentByPRN(prn);

        if (newCGPA < 0 || newCGPA > 10) {
            throw new InvalidDataException("Invalid CGPA. Must be between 0 and 10.");
        }

        student.setName(newName);
        student.setBranch(newBranch);
        student.setBatch(newBatch);
        student.setCgpa(newCGPA);

        System.out.println("Student details updated successfully.");
    }

    // 7. Delete Student
    public void deleteStudent(int prn) throws StudentNotFoundException {
        Iterator<Student> iterator = students.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getPRN() == prn) {
                iterator.remove();
                removed = true;
                System.out.println("Student removed successfully.");
                break;
            }
        }

        if (!removed) {
            throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
        }
    }
}
