// Worst case: O(n)

public class removeDuplicates {
    public int removeDuplicatesFunc(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;

        int i = 0, j = 0, k = 1;
        while (true) {
            while (nums[j] == nums[i]) {
                if (j == nums.length - 1) return k;
                j++;
           }
            nums[k] = nums[j];
            i = j; k++;
        }
    }
}
