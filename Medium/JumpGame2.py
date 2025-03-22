class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Greedy approach: keep remember what is the furthest index we can jump to. Add 1 step
        # for every expansion. This also helps spot if we can't reach n-1 (via Jump Game 1).
        # Worst case runtime: O(n). Note that the number of iteration is the number of line 21 
        # while loop's iteration. 
        n = len(nums)
        step = 0
        reachable = 0  # Max reachable index
        i = 0  # Current index
        
        while i < n:
            if reachable >= n-1:
                return step
            
            # Find the next reachable index
            next_reachable = 0
            while i <= reachable:
                next_reachable = max(next_reachable, i + nums[i])  # Can use if statement here
                i += 1
            # Check if we can reach nums[n-1]. LeetCode test cases guarantee nums[n-1]'s reachability
            # if reachable == next_reachable and next_reachable < n-1:
            #     return False  # We can't reach nums[n-1]
            reachable = next_reachable
            step += 1
        
        # The method below is Dynamic Programing.
        # dp[i] := the minimum number of steps needed to reach nums[n-1] from nums[i]
        # dp[i] = min(dp[j] + 1, X). X = 1 if i + nums[i] >= n-1, +infinity otherwise. 
        # j are the indices reachable from i 
        # This array is reverse i.e. dp[0] := min # of steps to reach nums[n-1] 
        # from nums[n-1]
        #* Code for DP below. Worst case: O(n^2)
        # n = len(nums)
        # dp = [0]
        # for i in range(n-2, -1, -1):
        #     if nums[i] + i >= n-1:
        #         dp.append(1)
        #     else:
        #         min_step = n  # Act as +infinity
        #         for j in range(1, min(n-i, nums[i]+1)):
        #             min_step = min(min_step, dp[-j])  # -j since the dp array is reversed
        #         dp.append(min_step + 1)
        # return dp[n-1]