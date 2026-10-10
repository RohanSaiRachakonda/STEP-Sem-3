public class LockerCode {
    // Final locker number fixed at creation
    private final int lockerNumber;
    // Private combination code with no getter (write-only via authenticated change)
    private String code;

    public LockerCode(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    // Changes code only if the current code is entered correctly first
    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("l.changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> success");
            return true;
        } else {
            System.out.println("l.changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> rejected, code is still \"" + this.code + "\"");
            return false;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        LockerCode l = new LockerCode(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
