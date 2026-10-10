import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a public transport journey
abstract class TransportJourney {
    protected double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getTransportType();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        // Base fare $2, plus $0.10 per km. Max fare $10.
        double fare = 2.0 + (0.10 * distance);
        return Math.min(10.0, fare);
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        // Base fare $3, plus $0.15 per km.
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        // Base fare $1.50, plus $0.20 per km, multiplied by PeakHourFactor.
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {

    public static void processJourneys(List<TransportJourney> journeys) {
        double grandTotal = 0.0;
        for (TransportJourney journey : journeys) {
            double fare = journey.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f%n", journey.getTransportType(), fare);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TransportJourney> journeys = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next().toUpperCase();
                double distance = sc.nextDouble();
                if (type.equals("METRO")) {
                    double factor = sc.nextDouble();
                    journeys.add(new MetroJourney(distance, factor));
                } else if (type.equals("TRAIN")) {
                    journeys.add(new TrainJourney(distance));
                } else {
                    journeys.add(new BusJourney(distance));
                }
            }
            processJourneys(journeys);
        } else {
            // Default sample demonstration
            journeys.add(new BusJourney(15));
            journeys.add(new TrainJourney(50));
            journeys.add(new MetroJourney(10, 1.5));
            processJourneys(journeys);
        }
        sc.close();
    }
}
