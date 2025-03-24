class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #* 2SUM with dictionary. Instead of 1 complement dictionary as in 2SUM, we maintain a dictionary 
        #* for all targets (a.k.a num in nums). Then we just add the triplet if it's not already there.
        #* Here I sort the triplet in order to search for them in the result set.
        n = len(nums)
        result = set()
        # Run 2SUM for each target
        for i in range(n):
            complement = {}
            for j in range(i+1, n):  # By the ordering of the numbers, i != j != k
                if nums[j] in complement:
                    triplet = tuple(sorted([nums[i], nums[j], complement[nums[j]]]))
                    result.add(triplet)
                else:
                    complement[-nums[i] - nums[j]] = nums[j]
        res = []
        for trip in result:
            res.append(list(trip))
        return res

    def threeSUM2(self, nums):
        #* 2SUM with sorting & 2 pointers.
        # Some edge cases
        if len(nums) < 3: return []
        if len(nums) == 3:
            if sum(nums) == 0: return [nums]
            else: return []
        
        # Sort the numbers
        n = len(nums)
        nums.sort()
        result = {}
        
        for i in range(n-2):  # Look up to the 3rd last element
            if i > 0 and nums[i] == nums[i-1]:  # Note that we don't want duplicated triplet
                continue
            
            # 2SUM with 2 pointers
            l, r = i + 1, n-1
            while l < r:
                if nums[l] + nums[r] == - nums[i]:
                    result[nums[i], nums[l], nums[r]] = None
                    # Skip duplicates
                    while l < r and nums[l] == nums[l+1]:
                        l += 1
                    while r > l and nums[r] == nums[r-1]:
                        r -= 1
                    l += 1
                    r -= 1
                elif nums[l] + nums[r] < -nums[i]:
                    l += 1
                else:
                    r -= 1
        return list(result.keys())