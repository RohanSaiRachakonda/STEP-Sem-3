public class CourseCreditManagement {

    // Class representing an academic course with constructor chaining
    public static class Course {
        String code;
        String title;
        int credits;
        int labCredits;

        // 4-argument constructor: sets all fields directly
        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        // 3-argument constructor for theory-only courses, chains via this(...)
        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        // Calculates total credits
        public int totalCredits() {
            return credits + labCredits;
        }
    }

    public static void main(String[] args) {
        // Theory-only course using 3-argument constructor
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);

        // Course with lab component using 4-argument constructor
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());
    }
}
