package session_seven_oop_fundamentals.class_problems;

public class PiggyBank {

    private double savings;
    private final String id; // fixed forever at creation

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0; // new piggy bank starts at 0
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
            return;
        }
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings (savings stays " + savings + ")");
            return;
        }
        savings -= amount;
    }

    public double getSavings() {  // read-only — no setter exists anywhere
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings()); // 100
        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings()); // 70
        pb.withdraw(500);                                   // rejected
        System.out.println("savings = " + pb.getSavings()); // 70
    }
}