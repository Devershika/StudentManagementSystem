public class Student {
    private String name, branch, batch;
    private int prn;
    private float cgpa;

    public Student(String name, int prn, String branch, String batch, float cgpa) {
        this.name = name;
        this.prn = prn;
        this.branch = branch;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    // Getters and setters...

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("PRN: " + prn);
        System.out.println("Branch: " + branch);
        System.out.println("Batch: " + batch);
        System.out.println("CGPA: " + cgpa);
    }
}
