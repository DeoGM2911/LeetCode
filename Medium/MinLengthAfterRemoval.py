from bisect import bisect_right, bisect_left

class Solution(object):
    def minLengthAfterRemovals(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #* The code uses binary search to find the max number of feasible operations
        #* If no number appears more than len(nums) // 2, the min length can only be 0 or 1.
        #* If a number appears more than len(nums) // 2, the min length is simply the twice the frequency 
        #* of that number minus the length of the array (pair every other number with that number).
        #* Also, that number must appear at position len(nums) // 2
        n = len(nums)
        l, r = bisect_left(nums, nums[n // 2]), bisect_right(nums, nums[n // 2])
        count = r - l
        return max(n % 2, 2*count - n)
        
        #* The code below uses a linear scan with two pointers to count the number of pairs 
        # # No pair exists
        # if len(nums) == 1:
        #     return 1
        
        # # Create two pointers to scan the array
        # l, r = 0, len(nums) // 2
        # while r < len(nums) and nums[l] == nums[r]:
        #     r += 1
            
        # count = 0
        # while l < len(nums) // 2 and r < len(nums):
        #     # We found a pair
        #     if nums[l] != nums[r]:
        #         l += 1
        #         r += 1
        #         count += 1
        #     else:
        #         r += 1

        # return len(nums) - 2* count