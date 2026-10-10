public class StudentPlacementRecordManagement {

    // Class to represent an individual student placement record
    public static class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;

        // Constructor to initialize all three fields
        public PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        // Instance method to print one formatted placement record line
        public void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public static void main(String[] args) {
        // Create three PlacementRecord objects and store them in an array
        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        // Print each placement record in a loop
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
