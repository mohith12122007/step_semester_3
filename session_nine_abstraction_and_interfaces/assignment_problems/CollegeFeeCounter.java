package session_nine_abstraction_and_interfaces.assignment_problems;

```java
import java.util.Scanner;

abstract class Student {
    String name;

    static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {
        double fee = calculateFee();

        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000.0;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000.0;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }

            double fee = student.getTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n", totalCollected
        );

        sc.close();
    }
}
```
