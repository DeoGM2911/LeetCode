class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # We wish the keep track of the "running" max(i+nums[i]). This denotes the
        # maximum index we can jump to whenever we starts at the the first index (like flood-fill, 
        # we try to find what is the furtherest index reachable from some index we have reached before).
        # Note that if a max index reached is only the max index reached so far, we can never reach the 
        # end (that's we can't never pass that index) (unless it's the end itself).
        running_max = 0
        for i in range(len(nums)):
            if running_max < i + nums[i]:  # Or use the built-in max
                running_max = i + nums[i]
            # Check if we can explore further
            if running_max == i and i != len(nums) - 1:
                return False
        return True