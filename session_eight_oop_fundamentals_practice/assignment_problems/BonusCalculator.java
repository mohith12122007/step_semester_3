import java.util.*;

public class BonusCalculator {

    abstract static class Employee {
        protected final String name;
        protected final double salary;
        protected Employee(String name, double salary) {
            this.name = name; this.salary = salary;
        }
        public String getName() { return name; }
        public abstract double getBonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double salary) { super(name, salary); }
        public double getBonus() { return salary * 0.10; }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double salary) { super(name, salary); }
        public double getBonus() { return salary * 0.05; }
    }

    static class Intern extends Employee {
        private static final double FIXED_BONUS = 2000.0;
        Intern(String name, double salary) { super(name, salary); }
        public double getBonus() { return FIXED_BONUS; }
    }

    static Employee createEmployee(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN":   return new Intern(name, salary);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            employees.add(createEmployee(parts[0], parts[1], Double.parseDouble(parts[2])));
        }
        double total = 0;
        for (Employee e : employees) {                // uniform, no type checks
            double bonus = e.getBonus();
            System.out.printf(Locale.US, "%s: %.2f%n", e.getName(), bonus);
            total += bonus;
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}