package session_nine_abstraction_and_interfaces.assignment_problems;

```java
import java.util.Scanner;

abstract class Ticket {
    // Convenience fee is defined in one place only
    static final double CONVENIENCE_FEE = 20.0;

    abstract double getPrice();

    double calculateAmount(int count) {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class Regular extends Ticket {
    double getPrice() {
        return 150.0;
    }
}

class Premium extends Ticket {
    double getPrice() {
        return 250.0;
    }
}

class Recliner extends Ticket {
    double getPrice() {
        return 400.0;
    }
}

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new Regular();
                    break;
                case "PREMIUM":
                    ticket = new Premium();
                    break;
                case "RECLINER":
                    ticket = new Recliner();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid seat type");
            }

            double amount = ticket.calculateAmount(count);
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
```