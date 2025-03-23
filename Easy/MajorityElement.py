class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #* Easy approach (only work for comparable (well-ordered) elements):
        #* sort and keep track of potential candidate
        #* Since the majory element > floor(n/2) times, any times we encounter a new
        #* element nums[i] s.t. nums[i] == nums[i+floor(n/2)], we know that this is the 
        #* majority element. Furthermore, we only need to search up to i=floor(n/2).
        #* Time Complexity: O(nlogn) - the sorting takes most of the time.
        nums.sort()
        return nums[len(nums)//2]
        
    def majorityElementRecursive(self, nums):
        #* Divide and Conquer approach (work for non-comparble (no well-ordered property)
        #* elements): Recursively find the majority elements for the left (m1) and right (m2) halves.
        #* Then note that the majority element in the combined array can only be either m1 or m2.
        #* Also, we will return the count of each majority element
        #* Then we just compare which one's count is larger overall - takes O(n).
        #* Time Complexity: O(nlogn).
        # Base case
        if len(nums) == 1:
            return nums[0], 1
        # Recursive case
        else:
            n = len(nums) // 2
            m1, c1 = majorityElement(nums[:n])
            m2, c2 = majorityElement(nums[n:])
            # Count in the opposite half
            for i in range(n):
                if nums[i] == m2: c2 += 1
            for i in range(n, len(nums)):
                if nums[i] == m1: c1 += 1
            # Decide winner
            if c1 > c2:
                return m1, c1
            elif c2 > c1:
                return m2, c2
            else:  # There may be cases when there is no major element e.g. nums=[1, 2]
                return None, 0
    
    def majorityElementDict(self, nums):
        #* Linear time & constant space: We'll use dictionary, which assumes that
        #* insert/update/query takes O(1)
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0) + 1
        
        for k in freq:
            if freq[k] > len(nums) // 2:
                return k
    
    def majorityElementLinear(self, nums):
        #* Linear time & constant space: Only true if the existence of the majority element 
        #* is guaranteed
        #* If we maintain the frequency of a candidate element (+1 when encounter it).
        #* If we encounter an element that is not the candidate, we deduct 1 from the frequency.
        #* Then, if the freq is 0, we can "switch" our candidate.
        #* Since the freq of majority element is > len(nums) / 2, then observe we can think 
        #* of the array as having two elements: non-majority and majority. Then we can see that the
        #* majority element will always reduced the freq of any other element.
        candidate, count_cand = None, 0
        for num in nums:
            if count_cand == 0:
                candidate = num
            if num == candidate:
                count_cand += 1
            else:
                count_cand -= 1
        return candidate