from bisect import bisect_right, bisect_left

class Solution(object):
    def countFairPairs(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: int
        """
        # Sort the array in ascending order
        nums.sort()
        
        # Perform n binary search for each index i in the sorted array to find the 
        # range of "fair partners" j 
        count = 0
        for i in range(len(nums)):
            # Only start searching from i+1 to avoid repetitive counting
            c1 = bisect_right(nums, upper-nums[i], i+1)
            c2 = bisect_left(nums, lower-nums[i], i+1)
            count += c1 - c2

        return count