package session_six_classes_objects_revision.assignment_problems;
class HallTicket {

    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicketMain {

    public static void main(String[] args) {
        HallTicket mohith = new HallTicket("Mohith", 0);
        HallTicket copy = mohith;          // same object, second reference
        copy.seatNumber = 45;             // change seen through second variable

        HallTicket separate = new HallTicket("Mohith", 45); // brand new object, same values

        System.out.println("Mohith's seatNumber (via first variable): " + mohith.seatNumber);
        System.out.println("copy == Mohith: " + (copy == mohith));
        System.out.println("separate == Mohith: " + (separate == mohith));
    }
}