public class StudentCollegeManagement {

    // Class demonstrating static fields and static methods
    public static class Student {
        // Instance fields
        String name;
        double attendance;

        // Static fields shared across all student instances
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        // Constructor increments studentCount every time a new student is created
        public Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        // Static method accessing only static fields
        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        // Create two Student objects
        Student s1 = new Student("Amit", 85.0);
        Student s2 = new Student("Priya", 92.5);

        // Call printCollegeInfo() through the class name directly
        Student.printCollegeInfo();
    }
}
