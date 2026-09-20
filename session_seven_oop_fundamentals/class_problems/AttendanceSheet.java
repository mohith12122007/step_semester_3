package session_seven_oop_fundamentals.class_problems;
public class AttendanceSheet {

    private final String[] presentStudents; // fixed max size, never exposed
    private int count = 0;

    public AttendanceSheet(int maxClassSize) {
        presentStudents = new String[maxClassSize];
    }

    public void markPresent(String name) {
        // Check first — no duplicates allowed
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return; // already marked, do nothing
            }
        }
        presentStudents[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate — ignored
        System.out.println("count = " + sheet.getPresentCount()); // 2
        System.out.println("Ben present? " + sheet.isPresent("Ben"));   // true
        System.out.println("Chen present? " + sheet.isPresent("Chen")); // false
    }
}