import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a hostel room electricity bill
abstract class HostelRoom {
    protected int units;

    public HostelRoom(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getRoomType();
}

class SingleRoom extends HostelRoom {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0; // ₹8 per unit
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }
}

class SharedRoom extends HostelRoom {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = Math.max(1, occupants);
    }

    @Override
    public double calculateBill() {
        // ₹6 per unit, divided equally among occupants
        return (units * 6.0) / occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }
}

class AcRoom extends HostelRoom {
    public AcRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        // ₹10 per unit, plus a fixed charge of ₹200
        return (units * 10.0) + 200.0;
    }

    @Override
    public String getRoomType() {
        return "AC";
    }
}

public class HostelElectricityBillCalculator {

    public static void processBills(List<HostelRoom> rooms) {
        double grandTotal = 0.0;
        for (HostelRoom room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<HostelRoom> rooms = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next().toUpperCase();
                int units = sc.nextInt();
                if (type.equals("SHARED")) {
                    int occupants = sc.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                } else if (type.equals("AC")) {
                    rooms.add(new AcRoom(units));
                } else {
                    rooms.add(new SingleRoom(units));
                }
            }
            processBills(rooms);
        } else {
            // Default sample demonstration
            rooms.add(new SingleRoom(120));
            rooms.add(new SharedRoom(150, 3));
            rooms.add(new AcRoom(100));
            processBills(rooms);
        }
        sc.close();
    }
}
