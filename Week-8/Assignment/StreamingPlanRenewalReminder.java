import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a streaming subscription plan
abstract class StreamingPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public StreamingPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends StreamingPlan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30); // 30-day validity
    }
}

class StandardPlan extends StreamingPlan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90); // 90-day validity
    }
}

class PremiumPlan extends StreamingPlan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365); // 365-day validity
    }
}

public class StreamingPlanRenewalReminder {

    public static void displayRenewals(List<StreamingPlan> subscribers) {
        for (StreamingPlan plan : subscribers) {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.getSubscriberName() + ": " + renewalDate);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<StreamingPlan> subscribers = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String planType = sc.next().toUpperCase();
                String name = sc.next();
                String dateStr = sc.next();
                LocalDate startDate = LocalDate.parse(dateStr);
                switch (planType) {
                    case "BASIC":
                        subscribers.add(new BasicPlan(name, startDate));
                        break;
                    case "STANDARD":
                        subscribers.add(new StandardPlan(name, startDate));
                        break;
                    case "PREMIUM":
                        subscribers.add(new PremiumPlan(name, startDate));
                        break;
                }
            }
            displayRenewals(subscribers);
        } else {
            // Default sample demonstration
            subscribers.add(new BasicPlan("Asha", LocalDate.parse("2024-01-15")));
            subscribers.add(new StandardPlan("Ravi", LocalDate.parse("2024-02-01")));
            subscribers.add(new PremiumPlan("Neha", LocalDate.parse("2024-03-10")));
            subscribers.add(new BasicPlan("Kiran", LocalDate.parse("2024-12-20")));
            displayRenewals(subscribers);
        }
        sc.close();
    }
}
