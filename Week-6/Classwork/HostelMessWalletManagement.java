public class HostelMessWalletManagement {

    // Encapsulated class representing a student's hostel mess card wallet
    public static class MessWallet {
        private double balance;

        // Constructor accepting opening balance; warns and defaults to 0 if negative
        public MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Warning: Opening balance cannot be negative. Setting balance to 0.");
                this.balance = 0.0;
            } else {
                this.balance = openingBalance;
            }
        }

        // Rejects non-positive amounts, otherwise adds to balance
        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: Amount must be greater than 0.");
            } else {
                this.balance += amount;
            }
        }

        // Rejects amounts exceeding current balance to prevent negative balance
        public void deduct(double amount) {
            if (amount <= 0) {
                System.out.println("Deduct rejected: Amount must be greater than 0.");
            } else if (amount > this.balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                this.balance -= amount;
            }
        }

        // Read-only getter for balance
        public double getBalance() {
            return this.balance;
        }
    }

    public static void main(String[] args) {
        // Sample execution
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());

        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
