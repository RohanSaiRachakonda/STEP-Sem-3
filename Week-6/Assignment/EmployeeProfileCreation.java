public class EmployeeProfileCreation {

    // Employee class supporting permanent and intern profiles via constructor chaining
    public static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        // 3-argument constructor for permanent employees
        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        // 2-argument constructor for interns, chains via this(...)
        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        // Prints all four fields on one line
        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        // Create permanent employee
        Employee permanentEmp = new Employee("E-101", "Divya", 65000);

        // Create intern employee
        Employee internEmp = new Employee("E-102", "Arjun");

        // Print profiles
        permanentEmp.printProfile();
        internEmp.printProfile();
    }
}
