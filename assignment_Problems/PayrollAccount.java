public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    // Public constructor: initializes basic salary with validation
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Setting basic salary to 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }

    // Credits bonus if amount is positive
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Credit rejected: bonus amount must be greater than 0");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    // Deducts tax as a percentage from basicSalary
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Deduction rejected: tax percentage must be between 0 and 100");
            return;
        }
        this.basicSalary -= this.basicSalary * (percent / 100.0);
        System.out.println("Tax deducted: " + (int) percent + "%");
    }

    // Read-only getter for net salary (basicSalary + bonus)
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
