public class searchInsert {
    /**
     * Binary search: O(log n)
     * @param nums: arrays of integers
     * @param target
     * @return the index of the target or where it should be inserted
     */
    public int searchInsertFunc(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            }

            if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return l;
    }
}
