import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a parked vehicle
abstract class ParkedVehicle {
    protected int hours;

    public ParkedVehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateParkingCharge();
    public abstract String getVehicleType();
}

class Bike extends ParkedVehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateParkingCharge() {
        return hours * 10.0; // ₹10 per hour
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }
}

class Car extends ParkedVehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateParkingCharge() {
        // ₹30 for the first hour, plus ₹20 for each additional hour
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }
}

class Truck extends ParkedVehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateParkingCharge() {
        // ₹50 per hour, with a minimum charge of ₹100
        double charge = hours * 50.0;
        return Math.max(100.0, charge);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }
}

public class CampusParkingChargeCalculator {

    public static void processParking(List<ParkedVehicle> vehicles) {
        double grandTotal = 0.0;
        for (ParkedVehicle v : vehicles) {
            double charge = v.calculateParkingCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f%n", v.getVehicleType(), charge);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ParkedVehicle> vehicles = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next().toUpperCase();
                int hours = sc.nextInt();
                switch (type) {
                    case "BIKE":
                        vehicles.add(new Bike(hours));
                        break;
                    case "CAR":
                        vehicles.add(new Car(hours));
                        break;
                    case "TRUCK":
                        vehicles.add(new Truck(hours));
                        break;
                }
            }
            processParking(vehicles);
        } else {
            // Default sample demonstration
            vehicles.add(new Bike(3));
            vehicles.add(new Car(4));
            vehicles.add(new Truck(1));
            vehicles.add(new Car(1));
            processParking(vehicles);
        }
        sc.close();
    }
}
