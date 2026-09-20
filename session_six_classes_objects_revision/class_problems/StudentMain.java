package session_six_classes_objects_revision.class_problems;

class Student {

    String name;
    double attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // increments once every time an object is created
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentMain {

    public static void main(String[] args) {
        Student s1 = new Student("Mohith", 92.5);
        Student s2 = new Student("Ullas", 88.0);

        Student.printCollegeInfo(); // called through the CLASS name
    }
}