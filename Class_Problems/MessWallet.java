public class MessWallet {
    private double balance;

    // Public constructor: validates opening balance
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Setting balance to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Top-up method: rejects non-positive amounts
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0");
            return;
        }
        balance += amount;
        System.out.println("Balance after top-up: " + balance);
    }

    // Deduct method: rejects amounts greater than balance
    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be greater than 0");
            return;
        }
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
    }

    // Read-only getter for balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
