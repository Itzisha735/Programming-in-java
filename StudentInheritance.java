class Student {
    // Common data members
    protected int studentId;
    protected String studentName;
    protected String department;

    // Constructor
    Student(int studentId, String studentName, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
    }

    // Method to display common student details
    void displayStudentDetails() {
        System.out.println("Student ID = " + studentId);
        System.out.println("Student Name = " + studentName);
        System.out.println("Department = " + department);
    }
}

// Subclass for Undergraduate students
class UndergraduateStudent extends Student {
    private int semester;
    private double cgpa;

    // Constructor
    UndergraduateStudent(int studentId, String studentName,
                         String department, int semester, double cgpa) {
        super(studentId, studentName, department);
        this.semester = semester;
        this.cgpa = cgpa;
    }

    // Method to display UG-specific details
    void displayUGDetails() {
        System.out.println("Semester = " + semester);
        System.out.println("CGPA = " + cgpa);
    }
}

// Subclass for Postgraduate students
class PostgraduateStudent extends Student {
    private String specialization;
    private String researchTopic;

    // Constructor
    PostgraduateStudent(int studentId, String studentName,
                        String department, String specialization,
                        String researchTopic) {
        super(studentId, studentName, department);
        this.specialization = specialization;
        this.researchTopic = researchTopic;
    }

    // Method to display PG-specific details
    void displayPGDetails() {
        System.out.println("Specialization = " + specialization);
        System.out.println("Research Topic = " + researchTopic);
    }
}

// Main class
public class StudentInheritance {
    public static void main(String[] args) {

        // Create UndergraduateStudent object
        UndergraduateStudent ug = new UndergraduateStudent(
                101, "Ravi", "CSE", 5, 8.75
        );

        System.out.println("----- Undergraduate Student -----");
        ug.displayStudentDetails();
        ug.displayUGDetails();

        System.out.println();

        // Create PostgraduateStudent object
        PostgraduateStudent pg = new PostgraduateStudent(
                201, "Anita", "ECE", "AI", "Computer Vision"
        );

        System.out.println("----- Postgraduate Student -----");
        pg.displayStudentDetails();
        pg.displayPGDetails();

        System.out.println();

        // Additional inheritance verification
        UndergraduateStudent ug2 = new UndergraduateStudent(
                102, "Kiran", "ISE", 7, 9.10
        );

        System.out.println("----- Inheritance Verification -----");
        ug2.displayStudentDetails();
        ug2.displayUGDetails();
    }
}