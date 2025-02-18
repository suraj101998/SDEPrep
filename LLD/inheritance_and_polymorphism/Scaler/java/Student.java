package LLD.inheritance_and_polymorphism.Scaler.java;

public class Student extends User {

    // TODO: Implement a Student class which is a subclass of User with the following additional properties:
    //studentId: representing the unique identifier of the student.
    //course: representing the course in which the student is enrolled.

    private int studentId;
    private String course;

    public Student(String username, String email, int studentId, String course){
        super(username, email);
        this.studentId = studentId;
        this.course = course;
    }
    
    public String getCourse() {
        return this.course;
    }
    public int getStudentId() {
        return this.studentId;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
    public static void main(String[] args) {
        Student student = new Student("jane_doe", "jane.doe@example.com", 101, "Computer Science");
        System.out.println("Username: " + student.getUsername());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Course: " + student.getCourse());
        student.displayInfo();
    }

}
