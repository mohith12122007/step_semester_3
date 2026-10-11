package session_nine_abstraction_and_interfaces.class_problems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Booking {
    protected double distance;
    // The shared booking fee written in one place as requested by business rules
    protected static final double BOOKING_FEE = 50.0;

    public Booking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();
    public abstract String getModeName();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distance) { super(distance); }
    @Override public double calculateBaseFare() { return distance * 2.0; }
    @Override public String getModeName() { return "BUS"; }
}

class TrainBooking extends Booking {
    public TrainBooking(double distance) { super(distance); }
    @Override public double calculateBaseFare() { return distance * 1.5; }
    @Override public String getModeName() { return "TRAIN"; }
}

class FlightBooking extends Booking {
    public FlightBooking(double distance) { super(distance); }
    @Override public double calculateBaseFare() { return 2500.0 + (distance * 4.0); }
    @Override public String getModeName() { return "FLIGHT"; }
}

public class BookingFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            if (mode.equals("BUS")) {
                bookings.add(new BusBooking(distance));
            } else if (mode.equals("TRAIN")) {
                bookings.add(new TrainBooking(distance));
            } else if (mode.equals("FLIGHT")) {
                bookings.add(new FlightBooking(distance));
            }
        }
        scanner.close();

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f\n", b.getModeName(), b.calculateTotalFare());
        }
    }
}