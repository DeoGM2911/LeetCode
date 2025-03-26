class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        #* Idea: We will continuously compute the sum of the squares of all digits. If we encounter 
        #* a loop that doesn't contain 1, we return False, else, we return true.
        seen = set()
        seen.add(n)
        while n != 1:
            n = sum(int(x)**2 for x in str(n))
            if n in seen:  # We get in a loop doesn't contain 1
                return False
            seen[n] = None  # Remember the number
        return True