package session_two_string_operations_performance.assignment_problems;

public class IsbnValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        String pub = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        return "[" + pub + "] YEAR: " + year + " | CATALOG: " + catalog;
    }

    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1)); // [PEN] YEAR: 2026 | CATALOG: 004251

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2)); // Invalid: publisher code must be 3 letters
    }
}