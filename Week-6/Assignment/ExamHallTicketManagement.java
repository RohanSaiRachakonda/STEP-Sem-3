public class ExamHallTicketManagement {

    // HallTicket class demonstrating reference assignment vs distinct object creation
    public static class HallTicket {
        String studentName;
        int seatNumber;

        // Constructor initializing both fields
        public HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {
        // Create initial HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Assign a second variable to the same object reference
        HallTicket copy = priya;

        // Mutate seatNumber through the second variable
        copy.seatNumber = 45;

        // Create a third, separate object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);

        // Verify shared reference vs distinct heap allocation
        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
