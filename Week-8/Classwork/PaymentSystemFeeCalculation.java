import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a generic Payment Method
abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    // Common polymorphic operation to calculate the adjusted amount
    public abstract double calculateFinalAmount();

    // Name of payment type
    public abstract String getTypeName();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02; // 2% processing fee
    }

    @Override
    public String getTypeName() {
        return "CARD";
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01; // 1% processing fee
    }

    @Override
    public String getTypeName() {
        return "WALLET";
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount; // 0% processing fee
    }

    @Override
    public String getTypeName() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystemFeeCalculation {

    // Central processor handling collection of payment methods uniformly via polymorphism
    public static void processPayments(List<PaymentMethod> payments) {
        double total = 0.0;
        for (PaymentMethod payment : payments) {
            double adjustedAmount = payment.calculateFinalAmount();
            total += adjustedAmount;
            System.out.printf("%s: %.2f%n", payment.getTypeName(), adjustedAmount);
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PaymentMethod> payments = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next().toUpperCase();
                double amount = sc.nextDouble();
                switch (type) {
                    case "CARD":
                        payments.add(new CardPayment(amount));
                        break;
                    case "WALLET":
                        payments.add(new WalletPayment(amount));
                        break;
                    case "BANKTRANSFER":
                        payments.add(new BankTransferPayment(amount));
                        break;
                }
            }
            processPayments(payments);
        } else {
            // Default sample demonstration
            payments.add(new CardPayment(1000));
            payments.add(new WalletPayment(500));
            payments.add(new BankTransferPayment(2000));
            processPayments(payments);
        }
        sc.close();
    }
}
