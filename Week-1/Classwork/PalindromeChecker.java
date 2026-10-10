public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
        public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }
    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = temp;
        }
        return text.equals(new String(chars));
    }
    public static void main(String[] args) {
        String[] tests = {"madam", "hello"};
        for (String text : tests) {
            System.out.printf("Input: \"%s\" | Iterative: %b | Recursive: %b | Array Reversal: %b%n",
                text, isPalindromeIterative(text), isPalindromeRecursive(text), isPalindromeArrayReversal(text));
        }
    }
}