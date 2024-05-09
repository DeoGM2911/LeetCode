import java.util.*;

/**
 * Given an array of interger (nums) and a target, return the indices of 2 numbers that add up to the target
 * Use a Map to store array values to its index. if the complement of the array value is in the map, return the result,
 * else add the element to the map
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (m.containsKey(complement)) {
                result[0] = m.get(complement);
                result[1] = i;
                return result;
            }
            else {
                m.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 15};
        int target = 9;
        TwoSum ts = new TwoSum();
        System.out.println(ts.twoSum(nums, target));
    }
}
