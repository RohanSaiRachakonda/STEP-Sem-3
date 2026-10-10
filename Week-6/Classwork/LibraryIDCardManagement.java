public class LibraryIDCardManagement {

    // Class representing a library ID card demonstrating reference vs object identity
    public static class IdCard {
        String name;
        int booksIssued;

        // Constructor to initialize fields
        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        // Create initial object
        IdCard ravi = new IdCard("Ravi", 0);

        // Assign a second reference to the same object
        IdCard duplicate = ravi;

        // Mutate through the second reference
        duplicate.booksIssued = 3;

        // Create a third separate object with identical values
        IdCard separate = new IdCard("Ravi", 3);

        // Verify shared reference vs distinct instances
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
