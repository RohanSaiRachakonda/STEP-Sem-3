package class_assignments;
import java.util.Scanner;
public class question_1 {
        public static int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            int leftProduct = 1;
            for (int i = 0; i < n; i++) {
                result[i] = leftProduct;
                leftProduct = leftProduct * nums[i];
            }
            int rightProduct = 1;
            for (int i = n - 1; i >= 0; i--) {
                result[i] = result[i] * rightProduct;
                rightProduct = rightProduct * nums[i];
            }
            return result;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter size: ");
            int n = sc.nextInt();
            int[] nums = new int[n];
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int[] result = productExceptSelf(nums);
            System.out.println("Output:");
            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            sc.close();
        }
    }