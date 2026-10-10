import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a generic delivery request
abstract class DeliveryService {
    protected double weight;
    protected double distance;

    public DeliveryService(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getType();
}

class StandardDelivery extends DeliveryService {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        // Base fee $5 + $0.50/kg + $0.10/km
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends DeliveryService {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        // Express: Base fee $15 + expedited handling $5 + $1.00/kg + $0.20/km
        return 20.0 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends DeliveryService {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        // International: Base fee $25 + international handling $10 + $2.00/kg + $0.50/km + customsFee
        return 35.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {

    public static void processDeliveries(List<DeliveryService> deliveries) {
        double total = 0.0;
        for (DeliveryService delivery : deliveries) {
            double fee = delivery.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", delivery.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<DeliveryService> deliveries = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next().toUpperCase();
                double weight = sc.nextDouble();
                double distance = sc.nextDouble();
                if (type.equals("INTERNATIONAL")) {
                    double customs = sc.nextDouble();
                    deliveries.add(new InternationalDelivery(weight, distance, customs));
                } else if (type.equals("EXPRESS")) {
                    deliveries.add(new ExpressDelivery(weight, distance));
                } else {
                    deliveries.add(new StandardDelivery(weight, distance));
                }
            }
            processDeliveries(deliveries);
        } else {
            // Default sample demonstration
            deliveries.add(new StandardDelivery(10, 50));
            deliveries.add(new ExpressDelivery(5, 20));
            deliveries.add(new InternationalDelivery(20, 100, 30));
            processDeliveries(deliveries);
        }
        sc.close();
    }
}
