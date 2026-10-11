import java.util.*;

public class CanteenBilling {

    abstract static class Customer {
        protected final double billAmount;
        protected Customer(double billAmount) { this.billAmount = billAmount; }
        public abstract String getType();
        public abstract double getFinalAmount();
    }

    static class Student extends Customer {
        Student(double amount) { super(amount); }
        public String getType() { return "STUDENT"; }
        public double getFinalAmount() { return billAmount * 0.90; } // 10% discount
    }

    static class Staff extends Customer {
        Staff(double amount) { super(amount); }
        public String getType() { return "STAFF"; }
        public double getFinalAmount() { return billAmount * 0.95; } // 5% discount
    }

    static class Guest extends Customer {
        private static final double SERVICE_CHARGE = 10.0;
        Guest(double amount) { super(amount); }
        public String getType() { return "GUEST"; }
        public double getFinalAmount() { return billAmount + SERVICE_CHARGE; }
    }

    static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT": return new Student(amount);
            case "STAFF":   return new Staff(amount);
            case "GUEST":   return new Guest(amount);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            bills.add(createCustomer(parts[0], Double.parseDouble(parts[1])));
        }
        double total = 0;
        for (Customer c : bills) {                    // uniform, no type checks
            double amount = c.getFinalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", c.getType(), amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}