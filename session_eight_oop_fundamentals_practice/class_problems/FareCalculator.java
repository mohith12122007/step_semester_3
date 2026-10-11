package session_eight_oop_fundamentals_practice.class_problems;

import java.util.*;

public class FareCalculator {

    abstract static class Transport {
        protected final double distance;
        protected Transport(double distance) { this.distance = distance; }
        public abstract String getType();
        public abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double d) { super(d); }
        public String getType() { return "BUS"; }
        public double calculateFare() { return Math.min(10.0, 2 + 0.10 * distance); }
    }

    static class Train extends Transport {
        Train(double d) { super(d); }
        public String getType() { return "TRAIN"; }
        public double calculateFare() { return 3 + 0.15 * distance; }
    }

    static class Metro extends Transport {
        private final double peakHourFactor;
        Metro(double d, double f) { super(d); this.peakHourFactor = f; }
        public String getType() { return "METRO"; }
        public double calculateFare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
    }

    static Transport createTransport(String type, double distance, double peakFactor) {
        switch (type) {
            case "BUS":   return new Bus(distance);
            case "TRAIN": return new Train(distance);
            case "METRO": return new Metro(distance, peakFactor);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            double peakFactor = parts.length > 2 ? Double.parseDouble(parts[2]) : 1.0;
            journeys.add(createTransport(parts[0], Double.parseDouble(parts[1]), peakFactor));
        }
        double total = 0;
        for (Transport t : journeys) {                // uniform, no type checks
            double fare = t.calculateFare();
            System.out.printf(Locale.US, "%s: %.2f%n", t.getType(), fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}