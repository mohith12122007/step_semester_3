package session_eight_oop_fundamentals_practice.class_problems;

import java.util.*;

public class PaymentSystem {

    abstract static class Payment {
        protected final double amount;
        protected Payment(double amount) { this.amount = amount; }
        public abstract String getType();
        public abstract double calculateFinalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) { super(amount); }
        public String getType() { return "CARD"; }
        public double calculateFinalAmount() { return amount * 1.02; } // 2% fee
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) { super(amount); }
        public String getType() { return "WALLET"; }
        public double calculateFinalAmount() { return amount * 1.01; } // 1% fee
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) { super(amount); }
        public String getType() { return "BANKTRANSFER"; }
        public double calculateFinalAmount() { return amount; } // no fee
    }

    static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD":          return new CardPayment(amount);
            case "WALLET":        return new WalletPayment(amount);
            case "BANKTRANSFER":  return new BankTransferPayment(amount);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Payment> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            transactions.add(createPayment(parts[0], Double.parseDouble(parts[1])));
        }
        double total = 0;
        for (Payment p : transactions) {              // uniform, no type checks
            double adjusted = p.calculateFinalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", p.getType(), adjusted);
            total += adjusted;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}