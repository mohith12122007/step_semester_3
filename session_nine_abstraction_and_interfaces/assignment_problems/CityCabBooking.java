package session_nine_abstraction_and_interfaces.assignment_problems;

```java
import java.util.Scanner;

abstract class Cab {
    static final double MINIMUM_FARE = 100.0;

    abstract double getRate();

    double calculateFare(double km) {
        return Math.max(MINIMUM_FARE, km * getRate());
    }
}

interface NightService {
    double NIGHT_MULTIPLIER = 1.20;
}

class Mini extends Cab {
    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    double getRate() {
        return 14.0;
    }
}

class SUV extends Cab implements NightService {
    double getRate() {
        return 18.0;
    }
}

public class CityCabBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini();
                    break;
                case "SEDAN":
                    cab = new Sedan();
                    break;
                case "SUV":
                    cab = new SUV();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                fare *= NightService.NIGHT_MULTIPLIER;
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
```