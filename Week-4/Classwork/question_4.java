package class_assignments;
import java.util.HashMap;
import java.util.Scanner;
public class question_4 {
        public static int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int currentSum = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                currentSum = currentSum + nums[i];
                if (map.containsKey(currentSum - k)) {
                    count = count + map.get(currentSum - k);
                }
                if (map.containsKey(currentSum)) {
                    map.put(currentSum, map.get(currentSum) + 1);
                } else {
                    map.put(currentSum, 1);
                }
            }
            return count;
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
            System.out.print("Enter k: ");
            int k = sc.nextInt();
            int result = subarraySum(nums, k);
            System.out.println("Output: " + result);
            sc.close();
        }
    }