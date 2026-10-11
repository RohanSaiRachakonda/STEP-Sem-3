import java.util.Scanner;

abstract class Appliance {
    double hours;
    static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    double calculateCost() {
        return calculateUnits() * COST_PER_UNIT;
    }
}

interface SaverMode {
    double SAVER_FACTOR = 0.75;

    double calculateSaverUnits(double units);
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    public double calculateSaverUnits(double units) {
        return units * SAVER_FACTOR;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    public double calculateSaverUnits(double units) {
        return units * SAVER_FACTOR;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;
            if (sc.hasNextLine()) {
                String remaining = sc.nextLine().trim();
                saver = remaining.equalsIgnoreCase("SAVER");
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    System.out.println("Invalid appliance");
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).calculateSaverUnits(units);
            }

            double cost = units * 8.0;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}