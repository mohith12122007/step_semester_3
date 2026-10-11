package session_nine_abstraction_and_interfaces.assignment_problems;

```java
import java.util.Scanner;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0.0;
    }
}

interface Insurable {
    double INSURANCE_RATE = 0.02;

    double calculateInsurance();
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

public class ParcelShippingDesk{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight, value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid parcel type");
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
```