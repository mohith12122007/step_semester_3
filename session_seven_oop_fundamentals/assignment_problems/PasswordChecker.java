package session_seven_oop_fundamentals.assignment_problems;

public class PasswordChecker {

    private final String password; // stored once, never exposed, never changed

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        boolean hasDigit = false;

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        if (len < 6) {
            return "Weak";
        } else if (len < 10 || !hasDigit) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength()); // Strong

        PasswordChecker pc3 = new PasswordChecker("abc123");
        System.out.println(pc3.getStrength()); // Medium (6 chars, has digit — your rule decides)
    }
}