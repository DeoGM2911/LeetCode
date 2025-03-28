import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRangesNaive(int[] nums) {
        // The code should be self-explanatory
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        String start = null;
        String end;
        String range;
        for (int i = 0; i < nums.length; i++) {
            if (start == null) start = String.valueOf(nums[i]);
            end = String.valueOf(nums[i]);
            if (i == nums.length - 1 || nums[i+1] > nums[i] + 1) {  // Avoid overflow! 0 - (-2^31)
                if (start.equals(end)) range = start;
                else range = start + "->" + end;
                result.add(range);
                start = null;
            }
        }
        return result;
    }

    public List<String> summaryRangesDVC(int[] nums) {
        // Divide and Conquer
        if (nums.length == 1) {
            return new ArrayList<String>(nums[0]);
        }
    }
}