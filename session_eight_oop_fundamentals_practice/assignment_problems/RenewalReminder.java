import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RenewalReminder {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    abstract static class Subscription {
        protected final String name;
        protected final LocalDate startDate;
        protected Subscription(String name, LocalDate startDate) {
            this.name = name; this.startDate = startDate;
        }
        public abstract int getValidityDays();
        public LocalDate getRenewalDate() { return startDate.plusDays(getValidityDays()); }
    }

    static class BasicPlan extends Subscription {
        BasicPlan(String name, LocalDate start) { super(name, start); }
        public int getValidityDays() { return 30; }
    }

    static class StandardPlan extends Subscription {
        StandardPlan(String name, LocalDate start) { super(name, start); }
        public int getValidityDays() { return 90; }
    }

    static class PremiumPlan extends Subscription {
        PremiumPlan(String name, LocalDate start) { super(name, start); }
        public int getValidityDays() { return 365; }
    }

    static Subscription createSubscription(String type, String name, String startDate) {
        LocalDate start = LocalDate.parse(startDate, FMT);
        switch (type) {
            case "BASIC":    return new BasicPlan(name, start);
            case "STANDARD": return new StandardPlan(name, start);
            case "PREMIUM":  return new PremiumPlan(name, start);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Subscription> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            subscribers.add(createSubscription(parts[0], parts[1], parts[2]));
        }
        for (Subscription s : subscribers)              // uniform, no type checks
            System.out.println(s.name + ": " + FMT.format(s.getRenewalDate()));
    }
}