package session_eight_oop_fundamentals_practice.class_problems;

import java.util.*;

public class DeliverySystem {

    abstract static class Delivery {
        protected final double weight, distance;
        protected Delivery(double weight, double distance) {
            this.weight = weight; this.distance = distance;
        }
        public abstract String getType();
        public abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double w, double d) { super(w, d); }
        public String getType() { return "STANDARD"; }
        public double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double w, double d) { super(w, d); }
        public String getType() { return "EXPRESS"; }
        public double calculateFee() { return 15 + 1.00 * weight + 0.20 * distance; }
    }

    static class InternationalDelivery extends Delivery {
        private final double customsFee;
        InternationalDelivery(double w, double d, double customsFee) {
            super(w, d); this.customsFee = customsFee;
        }
        public String getType() { return "INTERNATIONAL"; }
        public double calculateFee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
    }

    static Delivery createDelivery(String type, double w, double d, double customs) {
        switch (type) {
            case "STANDARD":      return new StandardDelivery(w, d);
            case "EXPRESS":       return new ExpressDelivery(w, d);
            case "INTERNATIONAL": return new InternationalDelivery(w, d, customs);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            double customs = parts.length > 3 ? Double.parseDouble(parts[3]) : 0;
            deliveries.add(createDelivery(parts[0],
                    Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), customs));
        }
        double total = 0;
        for (Delivery del : deliveries) {             // uniform, no type checks
            double fee = del.calculateFee();
            System.out.printf(Locale.US, "%s: %.2f%n", del.getType(), fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}