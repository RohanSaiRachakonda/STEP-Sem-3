public class PayrollSalaryManagement {

    // Encapsulated payroll account class
    public static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        // Public constructor: initializes basic salary, defaults to 0 with warning if negative
        public PayrollAccount(double openingSalary) {
            if (openingSalary < 0) {
                System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
                this.basicSalary = 0.0;
            } else {
                this.basicSalary = openingSalary;
            }
            this.bonus = 0.0;
        }

        // Credits bonus if amount > 0, otherwise rejects with message
        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus rejected: Amount must be greater than 0.");
            } else {
                this.bonus += amount;
                System.out.println("Bonus credited: Rs " + amount);
            }
        }

        // Deducts tax percentage from basic salary; validates 0-100% range
        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax deduction rejected: Percentage must be between 0 and 100.");
            } else {
                this.basicSalary -= this.basicSalary * (percent / 100.0);
                if (percent == (long) percent) {
                    System.out.println("Tax deducted: " + (long) percent + "%");
                } else {
                    System.out.println("Tax deducted: " + percent + "%");
                }
            }
        }

        // Read-only access to net salary (basic salary + bonus)
        public double getNetSalary() {
            return this.basicSalary + this.bonus;
        }
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
