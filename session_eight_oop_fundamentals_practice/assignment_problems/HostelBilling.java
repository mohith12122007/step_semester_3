import java.util.*;

public class HostelBilling {

    abstract static class Room {
        protected final int units;
        protected Room(int units) { this.units = units; }
        public abstract String getType();
        public abstract double getBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) { super(units); }
        public String getType() { return "SINGLE"; }
        public double getBill() { return 8.0 * units; }
    }

    static class SharedRoom extends Room {
        private final int occupants;
        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }
        public String getType() { return "SHARED"; }
        public double getBill() { return 6.0 * units / occupants; } // per occupant
    }

    static class AcRoom extends Room {
        private static final double FIXED_CHARGE = 200.0;
        AcRoom(int units) { super(units); }
        public String getType() { return "AC"; }
        public double getBill() { return 10.0 * units + FIXED_CHARGE; }
    }

    static Room createRoom(String type, int units, int occupants) {
        switch (type) {
            case "SINGLE": return new SingleRoom(units);
            case "SHARED": return new SharedRoom(units, occupants);
            case "AC":     return new AcRoom(units);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            int occupants = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;
            rooms.add(createRoom(parts[0], Integer.parseInt(parts[1]), occupants));
        }
        double total = 0;
        for (Room r : rooms) {                        // uniform, no type checks
            double bill = r.getBill();
            System.out.printf(Locale.US, "%s: %.2f%n", r.getType(), bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}