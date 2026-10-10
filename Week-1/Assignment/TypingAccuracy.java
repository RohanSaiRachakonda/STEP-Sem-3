public class TypingAccuracy {
    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int total = original.length();
        int firstMismatchPos = -1;
        char expected = ' ';
        char actual = ' ';
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++; // Count how many characters match[cite: 3]
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; 
                expected = original.charAt(i);
                actual = typed.charAt(i);
            }
        }
        double accuracy = (matched * 100.0) / total;
        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", matched, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                              matched, total, accuracy, firstMismatchPos, expected, actual);
        }
    }
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}