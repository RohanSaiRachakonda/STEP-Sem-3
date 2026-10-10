import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Customer class modeling common billing operation
abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getCustomerType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.00; // Full amount + ₹10 service charge
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {

    public static void processBills(List<Customer> bills) {
        double grandTotal = 0.0;
        for (Customer bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f%n", bill.getCustomerType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Customer> bills = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next().toUpperCase();
                double amount = sc.nextDouble();
                switch (type) {
                    case "STUDENT":
                        bills.add(new StudentCustomer(amount));
                        break;
                    case "STAFF":
                        bills.add(new StaffCustomer(amount));
                        break;
                    case "GUEST":
                        bills.add(new GuestCustomer(amount));
                        break;
                }
            }
            processBills(bills);
        } else {
            // Default sample demonstration
            bills.add(new StudentCustomer(200));
            bills.add(new StaffCustomer(300));
            bills.add(new GuestCustomer(150));
            processBills(bills);
        }
        sc.close();
    }
}
