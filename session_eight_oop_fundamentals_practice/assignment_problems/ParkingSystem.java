import java.util.*;

public class ParkingSystem {

    abstract static class Vehicle {
        protected final int hours;
        protected Vehicle(int hours) { this.hours = hours; }
        public abstract String getType();
        public abstract double getCharge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) { super(hours); }
        public String getType() { return "BIKE"; }
        public double getCharge() { return 10.0 * hours; }
    }

    static class Car extends Vehicle {
        Car(int hours) { super(hours); }
        public String getType() { return "CAR"; }
        public double getCharge() { return 30 + 20.0 * (hours - 1); } // first hour ₹30
    }

    static class Truck extends Vehicle {
        private static final double MINIMUM = 100.0;
        Truck(int hours) { super(hours); }
        public String getType() { return "TRUCK"; }
        public double getCharge() { return Math.max(MINIMUM, 50.0 * hours); }
    }

    static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE":  return new Bike(hours);
            case "CAR":   return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            vehicles.add(createVehicle(parts[0], Integer.parseInt(parts[1])));
        }
        double total = 0;
        for (Vehicle v : vehicles) {                  // uniform, no type checks
            double charge = v.getCharge();
            System.out.printf(Locale.US, "%s: %.2f%n", v.getType(), charge);
            total += charge;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}