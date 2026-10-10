public class ATMPinValidator {
    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN must be exactly 4 digits."); // Prints if length is not exactly 4[cite: 5].
        } else {
            System.out.println("PIN length OK."); // Prints if length is exactly 4[cite: 5].
        }
    }
    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }
}