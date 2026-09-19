package session_two_string_operations_performance.class_problems;

public class StudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0] + " | Roll No: " + fields[1] + " | Dept: " + fields[2]);
    }

    public static void main(String[] args) {
        parseStudentRecord("Mohith Reddy,RA2511003011914,CSE"); // Name: Mohith Reddy | Roll No: RA2511003011914 | Dept: CSE
        parseStudentRecord("Mohith reddy,CSE");                 // Invalid Record
    }
}