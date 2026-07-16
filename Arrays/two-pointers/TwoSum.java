import java.util.*;
public class Main {
public static int[] twosum(int nums[], int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int res[] = twosum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
