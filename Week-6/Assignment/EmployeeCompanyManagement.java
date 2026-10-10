public class EmployeeCompanyManagement {

    // Employee class demonstrating static shared fields vs instance fields
    public static class Employee {
        // Instance fields
        String empName;
        double salary;

        // Static fields shared across all Employee instances
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        // Constructor increments employeeCount on every invocation
        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        // Static method accessing only static state
        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        // Create three Employee objects
        Employee emp1 = new Employee("Rajesh", 55000);
        Employee emp2 = new Employee("Simran", 62000);
        Employee emp3 = new Employee("Anand", 58000);

        // Call printCompanyInfo() through class name directly
        Employee.printCompanyInfo();
    }
}
