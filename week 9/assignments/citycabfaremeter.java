import java.util.Scanner;

abstract class Cab {
    double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRate();

    double calculateFare() {
        return Math.max(100.0, distance * getRate());
    }
}

interface NightService {
    double NIGHT_SURCHARGE = 0.20;

    double applyNightFare(double fare);
}

class MiniCab extends Cab {
    MiniCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 14.0;
    }

    public double applyNightFare(double fare) {
        return fare * (1 + NIGHT_SURCHARGE);
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 18.0;
    }

    public double applyNightFare(double fare) {
        return fare * (1 + NIGHT_SURCHARGE);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    System.out.println("Invalid cab type");
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}