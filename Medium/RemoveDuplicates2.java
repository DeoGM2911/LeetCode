class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 0;  // Position to be replaced
        int count = 0;  // How many duplicates
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                k += 1;
                continue;
            }
            
            // Encounter new element
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];  
                k++;
                count = 0; // Reset since we encounter new element
                continue;
            }

            // Nums[i] = nums[i-1]
            count++;
            if (count < 2) {
                // Still valid, increment k to next position
                nums[k] = nums[i];
                k++;
            }
            else {
                continue;  // This means that we skip until encounter new element.
            }
        }
        return k;
    }
}