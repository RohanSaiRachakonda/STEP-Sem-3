public class FirstNonRepeating {
    public static char findFirstNonRepeatingChar(String text) {
        int[] counts = new int[256];
        for (char c : text.toCharArray()) {
            counts[c]++;
        }
        for (char c : text.toCharArray()) {
            if (counts[c] == 1) return c;
        }
        return '\0';
    }
    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};
        for (String test : tests) {
            char res = findFirstNonRepeatingChar(test);
            if (res == '\0') {
                System.out.println(test + " -> No Non-Repeating Character Found");
            } else {
                System.out.println(test + " -> First Non-Repeating Character: '" + res + "'");
            }
        }
    }
}