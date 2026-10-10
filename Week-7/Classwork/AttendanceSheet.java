public class AttendanceSheet {
    // Private array holding names of present students (no getter returning the array)
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    // Marks a student present, preventing duplicate entries
    public void markPresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        if (!isPresent(name) && presentCount < presentStudents.length) {
            presentStudents[presentCount++] = name;
        }
    }

    // Exposes only count
    public int getPresentCount() {
        return presentCount;
    }

    // Exposes yes/no lookup
    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount()); // 2
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));   // true
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen")); // false
    }
}
