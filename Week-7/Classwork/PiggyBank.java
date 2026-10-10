public class PiggyBank {
    // Final immutable ID locked at creation
    private final String id;
    // Private savings amount changed only via deposit and withdraw
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0; // Starts with 0 savings
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("pb.deposit(" + amount + ") -> savings = " + savings);
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("pb.withdraw(" + amount + ") -> rejected (invalid amount), savings stays " + savings);
        } else if (amount > savings) {
            System.out.println("pb.withdraw(" + amount + ") -> rejected, savings stays " + savings);
        } else {
            savings -= amount;
            System.out.println("pb.withdraw(" + amount + ") -> savings = " + savings);
        }
    }

    // Read-only getter for savings
    public int getSavings() {
        return savings;
    }

    // Read-only getter for final ID
    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}
