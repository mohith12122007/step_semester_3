package session_two_string_operations_performance.class_problems;
public class TransactionReference {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        String first3 = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return first3 + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check bank code (first 3 characters are letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check body (remaining 11 characters are digits)
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        // Format: [HDF] DATE: 03/02/26 | SEQ: 00042
        String bank = reference.substring(0, 3);
        String dd   = reference.substring(3, 5);
        String mm   = reference.substring(5, 7);
        String yy   = reference.substring(7, 9);
        String seq  = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bank).append("]")
          .append(" DATE: ").append(dd).append("/").append(mm).append("/").append(yy)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        String ref1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(ref1));   // [HDF] DATE: 03/02/26 | SEQ: 00042

        String ref2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(ref2));   // Invalid: bank code must be 3 letters

        System.out.println(validateAndFormat(normalizeReference("axis0302XY00042"))); // Invalid: body must be digits
        System.out.println(validateAndFormat(normalizeReference(" hdfc030226 ")));    // Invalid: wrong length
    }
}