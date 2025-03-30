import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int length = 0;
        int temp_len;
        for (int el:numSet) {
            if (!numSet.contains(el-1)) {  // Ensure we ONLY look at the lower bound of all the ranges -> Ensure O(n)
                temp_len = 1;
                while (numSet.contains(++el)) temp_len += 1;
                length = Math.max(length, temp_len);
            }
        }
        return length;
    }

    public int longestConsecutiveScratch(int[] nums) {
        // ! This method is too long and slow
        // Map lower bound to upper bound and vice versa of a range
        Map<Integer, Integer> range = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        int temp_lower, temp_upper;
        for (int i = 0; i < nums.length; i++) {
            // Only care if we have never encounter the element
            if (!seen.contains(nums[i])) {
                // Remember the number
                seen.add(nums[i]);
                if (range.containsKey(nums[i]-1)) {
                    if (range.containsKey(nums[i]+1)) {
                        temp_lower = range.get(nums[i]-1);
                        temp_upper = range.get(nums[i]+1);
                        range.put(temp_lower, temp_upper);
                        range.put(temp_upper, temp_lower);
                        if (temp_lower != nums[i]-1) range.remove(nums[i]-1);
                        if (temp_upper != nums[i]+1) range.remove(nums[i]+1);
                    }

                    else {
                        if (range.get(nums[i]-1) != nums[i]-1) {
                            range.put(range.get(nums[i]-1), nums[i]);
                            range.put(nums[i], range.get(nums[i]-1));
                            range.remove(nums[i]-1);
                        }

                        else {
                            range.put(nums[i], nums[i]-1);
                            range.put(nums[i]-1, nums[i]);
                        }
                    }

                }
                else if (range.containsKey(nums[i] + 1)) {  // We know that range doesn't contain nums[i-1]
                    if (range.get(nums[i]+1) != nums[i]+1) {
                        range.put(range.get(nums[i]+1), nums[i]);
                        range.put(nums[i], range.get(nums[i]+1));
                        range.remove(nums[i]+1);
                    }
                    else {
                        range.put(nums[i], nums[i]+1);
                        range.put(nums[i]+1, nums[i]);
                    }
                }
                else {
                    range.put(nums[i], nums[i]);
                }
            }
        }

        // Find the best length
        int bestLength = 0;
        for (int element:range.keySet()) {  // Worst case: n keys
            if (range.get(element) - element + 1 > bestLength) {
                bestLength = range.get(element) - element + 1;
            }
        }

        return bestLength;
    }
}