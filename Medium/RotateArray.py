class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        #* Brute-force approach: Notice, we can simply swap "continuously" backward the last k 
        #* elements with n-k steps. Time Complexity: (n-(k%n))*k%n = O(n^2) where k' = k % n.
        #* This is slow!
        #* Space complexity: O(1)
        def swap(i, step, nums):
            """
            Move the i element backward n-k times
            """
            while step > 0:
                nums[i], nums[i-1] = nums[i-1], nums[i]
                i -= 1
                step -= 1
        
        # Note that if k > n, we only rotate k%n since n rotate is the same as no rotate
        n = len(nums)
        k = k % n
        for i in range(n-k, n):
            swap(i, n-k, nums)

    def rotate2(self, nums, k):
        #* Extra memory: We simply remember the arrays and shift the first n-k elements forward
        #* then let the first k elements be the old last k elements. Time: O(n), Space: O(n)
        n = len(nums)
        k = k % n
        if k == 0:
            return
        
        copy = nums[:]  # Copy original array
        for i in range(n):
            if i < n-k:
                nums[i+k] = copy[i]
            else:
                nums[i-n+k] = copy[i]
    
    def rotate3(self, nums, k):
        #* Reverse subarray: The idea is to first reverse the array. Note that the first k
        #* element is now the original last k elements (but reversed). Then, we just need to
        #* reverse nums[1:k]. Now, note that the rest of the work is just to reverse nums[k:]
        #* to obtain the original ordering of those number. Time Complexity: O(n). 
        #* Space complexity: O(1)
        # Note that we can replace the built-in methods with simple for loops
        k = k % len(nums)
        # Reverse each part of the array
        # Reverse the entire array
        nums.reverse()
        # Reverse the first k elements
        nums[:k] = reversed(nums[:k])
        # Reverse the remaining elements
        nums[k:] = reversed(nums[k:])