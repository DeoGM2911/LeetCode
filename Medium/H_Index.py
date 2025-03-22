class Solution(object):
    MAX_CITATION = 1000 + 1
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        # The idea is that given a number i, we want to count the number 
        # of papers with citations with at least i citations. The suffix sum approach takes O(n).  
        #* Remark: Since MAX_CITATION is small, it's fine to not search for the 
        #* max number of citations for a paper.
        # Create the frequency list: 
        # of citations (index) -> # of papers with that many citations (entry)
        freq = [0] * self.MAX_CITATION
        for num_cita in citations:
            freq[num_cita] += 1
        
        # Create the suffix_sum map.
        suffix_sum = [0]*self.MAX_CITATION
        suffix_sum[self.MAX_CITATION-1] = freq[self.MAX_CITATION-1]
        for i in range(self.MAX_CITATION-2, -1, -1):
            suffix_sum[i] = suffix_sum[i+1] + freq[i]
        
        # Find max i s.t. suffix_sum[i] >= i
        h = 0
        for i in range(1, self.MAX_CITATION):
            if suffix_sum[i] >= i:
                h = i
        return h
    
    def hIndex2(self, citations):
        #* Since len(citations) <= 5000, we can sort the list, then search for the largest 
        #* number of citations i satisfying citations[i] <= len(citations) - i. Time complexity: O(nlogn)
        citations.sort(reverse=True)
        n = len(citations)
        h = 0
        i = 0
        while i < n:
            if citations[i] >= i + 1:  # At least i + 1 papers have been cited at least i + 1 times.
                h = i + 1
            i += 1
        return h