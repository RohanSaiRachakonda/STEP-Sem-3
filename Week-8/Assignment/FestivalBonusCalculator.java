import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a company employee for festival bonus
abstract class CompanyEmployee {
    protected String name;
    protected double monthlySalary;

    public CompanyEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends CompanyEmployee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10; // 10% of monthly salary
    }
}

class PartTimeEmployee extends CompanyEmployee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05; // 5% of monthly salary
    }
}

class InternEmployee extends CompanyEmployee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.00; // Fixed bonus of ₹2,000 regardless of salary
    }
}

public class FestivalBonusCalculator {

    public static void processBonuses(List<CompanyEmployee> employees) {
        double grandTotal = 0.0;
        for (CompanyEmployee emp : employees) {
            double bonus = emp.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CompanyEmployee> employees = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next().toUpperCase();
                String name = sc.next();
                double salary = sc.nextDouble();
                switch (type) {
                    case "FULLTIME":
                        employees.add(new FullTimeEmployee(name, salary));
                        break;
                    case "PARTTIME":
                        employees.add(new PartTimeEmployee(name, salary));
                        break;
                    case "INTERN":
                        employees.add(new InternEmployee(name, salary));
                        break;
                }
            }
            processBonuses(employees);
        } else {
            // Default sample demonstration
            employees.add(new FullTimeEmployee("Asha", 50000));
            employees.add(new PartTimeEmployee("Ravi", 30000));
            employees.add(new InternEmployee("Neha", 15000));
            processBonuses(employees);
        }
        sc.close();
    }
}
