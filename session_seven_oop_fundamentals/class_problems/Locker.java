package session_seven_oop_fundamentals.class_problems;

public class Locker {

    private String code;     // private, and NO getter — write-only from outside
    private final int lockerNumber; // fixed at creation

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {   // check the old code FIRST
            System.out.println("Rejected: wrong current code. Combination unchanged.");
            return;
        }
        code = newCode;
        System.out.println("Code changed successfully.");
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678"); // success
        l.changeCode("0000", "9999"); // rejected — code is still "5678"
    }
}