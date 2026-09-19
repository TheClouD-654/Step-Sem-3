public class PiggyBank {
    private final String id;
    private int savings;

    // Constructor: locks the final ID in place; starts at 0 savings
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposits money into savings
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
            return;
        }
        this.savings += amount;
        System.out.println("deposit(" + amount + ") -> savings = " + this.savings);
    }

    // Withdraws money; rejects if amount exceeds current savings
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Withdraw rejected: amount must be positive");
            return;
        }
        if (amount > this.savings) {
            System.out.println("withdraw(" + amount + ") -> rejected, savings stays " + this.savings);
            return;
        }
        this.savings -= amount;
        System.out.println("withdraw(" + amount + ") -> savings = " + this.savings);
    }

    // Read-only getter for savings (no setter exists)
    public int getSavings() {
        return savings;
    }

    // Getter for final ID
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
