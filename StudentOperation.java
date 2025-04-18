import java.sql.*;
import java.util.*;

public class StudentOperations {
    
    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (name, prn, branch, batch, cgpa) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnections.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getPRN());
            ps.setString(3, student.getBranch());
            ps.setString(4, student.getBatch());
            ps.setFloat(5, student.getcgpa());
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        }
    }

    public void displayStudents() throws SQLException {
        String query = "SELECT * FROM students";
        try (Connection con = DBConnections.getConnection(); Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student s = new Student(rs.getString("name"), rs.getInt("prn"), rs.getString("branch"),
                        rs.getString("batch"), rs.getFloat("cgpa"));
                s.display();
            }
        }
    }

    public Student searchStudentByPRN(int prn) throws SQLException, StudentNotFoundException {
        String query = "SELECT * FROM students WHERE prn = ?";
        try (Connection con = DBConnections.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, prn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getString("name"), rs.getInt("prn"),
                        rs.getString("branch"), rs.getString("batch"), rs.getFloat("cgpa"));
            } else {
                throw new StudentNotFoundException("No student found with PRN: " + prn);
            }
        }
    }

    public List<Student> searchStudentByName(String name) throws SQLException {
        String query = "SELECT * FROM students WHERE name LIKE ?";
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnections.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(rs.getString("name"), rs.getInt("prn"),
                        rs.getString("branch"), rs.getString("batch"), rs.getFloat("cgpa")));
            }
        }
        return list;
    }

    public List<Student> searchStudentByBranch(String branch) throws SQLException {
        String query = "SELECT * FROM students WHERE branch = ?";
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnections.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, branch);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(rs.getString("name"), rs.getInt("prn"),
                        rs.getString("branch"), rs.getString("batch"), rs.getFloat("cgpa")));
            }
        }
        return list;
    }

    public void updateStudent(int prn, String name, String branch, String batch, float cgpa) throws SQLException {
        String query = "UPDATE students SET name=?, branch=?, batch=?, cgpa=? WHERE prn=?";
        try (Connection con = DBConnections.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, branch);
            ps.setString(3, batch);
            ps.setFloat(4, cgpa);
            ps.setInt(5, prn);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        }
    }

    public void deleteStudent(int prn) throws SQLException {
        String query = "DELETE FROM students WHERE prn=?";
        try (Connection con = DBConnections.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, prn);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        }
    }
}
