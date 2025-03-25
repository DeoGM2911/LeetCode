class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        #* Idea: We will construct a back track map/graph as follow:
        #* a number m will point to every number that is larger than it. Then, we can find the 
        #* combinations by do a "DFS-like" search in the graph from every number from 1 to n-k+1. 
        #* The DFS-like function is accumulate. Note that the path variable in accumulate is a "must"
        #* since if we append to path_so_far, we will always append to the "same" list. Time complexity:
        #* O(k*(nCk)). Building the backtrack map takes O(n^2). The recursive accumulate for each combination 
        #* takes O(k). There are n choose k (nCk) combinations. We can think of this as how many times
        #* we visit an "edge" in our backtrack graph. 
        # Create backtrack map
        backtrack = {}
        for m in range(1, n+1):
            backtrack[m] = [i for i in range(m+1, n+1)]
        
        # Contain all combinations
        result = []
        
        def accumulate(m, level, path_so_far=[]):
            """
            Recursively grab all combinations until level is 1
            """
            path = path_so_far + [m]
            # At the end of a combination
            if level == 1:
                return result.append(path)
            if len(backtrack[m]) == 0:  # Can't extend more but the level is not 1
                return
            for num in backtrack[m]:
                accumulate(num, level-1, path)
        
        # Find all combinations
        for m in range(1, n-k+2):  # We only search to n-k+2 as the starting number
            accumulate(m, k)
        
        return result