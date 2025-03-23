class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #* Idea: Use a "modified" prefix product and a "modified" suffix product array.
        #* That is we calculate two arrays P and S such that P[i] = nums[0]*nums[1]*...*nums[i-1]
        #* and S[i] = nums[n-1]*nums[n-2]*...*nums[i+1]. Note that S[n-1] = 1 and P[0] = 1
        #* Then our desired result is result[i] = S[i]*P[i]
        n = len(nums)
        prefix = [1] * n
        suffix = [1] * n  # Note that this array is reversed
        for i in range(1, n):
            prefix[i] = nums[i-1] * prefix[i-1]
            suffix[i] = nums[n-i] * suffix[i-1]
        
        for i in range(n):
            nums[i] = prefix[i]*suffix[n-1-i]
        
        return nums

    def productExceptSelf(self, nums):
        #* Improve space, we loop through the array twice: one time we will calculate cummulative
        #* prefix product, one time we will calculate the cumulative suffix product. 
        #* In both loops, we'll update the result immediately.
        n = len(nums)
        prefix_prod = 1
        suffix_prod = 1
        result = [1] * n
        for i in range(n):
            result[i] *= prefix_prod  # Calculate this first since our product must exclude "self"
            prefix_prod *= nums[i]
        
        for i in range(n-1, -1, -1):
            result[i] *= suffix_prod
            suffix_prod *= nums[i]
            
        return result