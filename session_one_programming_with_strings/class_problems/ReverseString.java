package session_one_topic.class_problems;

public class ReverseString {
    

    
    // Method to reverse the customer name
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        char[] characters = customerName.toCharArray();
        String reversed = "";
        for (int i = characters.length - 1; i >= 0; i--) {
            reversed += characters[i];
        }
        return reversed;
    }

    public static void main(String[] args) {
        String originalName = "Sunil";
        String reversedName = reverseCustomerName(originalName);
        
        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
    }
}