class Solution {
/** For the follow up question, we can use divide and conquer approach: spilt array in halves, then 
 * recursively call minSubArrayLen on those two halves. Then we combine the result by comparing the 
 * outputs and the minSubArrayLen formed by moving two pointers from the middle outward. 
 * Time Complexity is O(nlog n) by Master Theorem (T(n) <= 2T(ceil(n/2)) + O(n)).
 */

 /** Another approach is calculate the prefix sum array (which is sorted due to positive entries). Then
  *  we perform nums.length binary searches of prefixSum[i] + target. Then, we pick the minimum length 
  * of all searches. Length = output of BS - i + 1. 
  */

    public int minSubArrayLen(int target, int[] nums) {
        // Two pointers l and r. Slide the window nums[l:r-1] (inclusive). Update length if needed
        int l = 0, r = 0;
        int sum = 0;
        int length = nums.length + 1;  // Pseudo infinity

        while (r <= nums.length && l <= r) {
            if (sum < target) {
                r++;
                if (r > nums.length) break;
                sum += nums[r-1];
            }
            else {
                if (sum >= target) {
                    // Update length if needed
                    if (sum >= target && length > r-l) length = r - l;
                    sum -= nums[l];
                    l++;
                }
            }
        }

        if (length == nums.length + 1) return 0;
        return length;
    }
}