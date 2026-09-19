package session_two_string_operations_performance.class_problems;

public class PhoneMasker {

    static String maskPhoneNumber(String phone) {
        // Validate: exactly 10 digits, all numeric
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String last4 = phone.substring(6); // last 4 digits

        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append(last4);
        sb.insert(6, "-"); // XXXXXX-3210

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210")); 
        System.out.println(maskPhoneNumber("98765"));      
        System.out.println(maskPhoneNumber("98765ABC10")); 
    }
}