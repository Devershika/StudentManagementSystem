import java.util.*;

class StudentOperations {
    ArrayList<Student> students;

    public StudentOperations() {
        this.students = new ArrayList<>();
    }

    
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student Added");
    }

