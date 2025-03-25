class Solution(object):
    NUM_CHAR = 26
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        #* The straightforward idea is to count the frequencies of the characters in a string, then
        #* see if there is a mismatch. Note, we can use bult-in str.count() for efficiency. 
        #* This method is better for UNICODE characters case, since the length of the word << # of chars.
        #* Time Complexity: O(n) where n := len(s).
        if len(s) != len(t):
            return False
        
        count_s = {}
        count_t = {}
        for i in range(len(s)):
            count_s[s[i]] = count_s.get(s[i], 0) + 1
            count_t[t[i]] = count_t.get(t[i], 0) + 1

        return count_t == count_s

    def isAnagram2(self, s, t):
        #* A different way: Since s, t contain lower case English words only, we can simply
        #* replace our maps with a list of length 26. The final count for every character must be 0.
        #* Note: again, we can use str.count(), and all() for efficiency. This is faster and more 
        #* memory efficient since we only use a list (rather an array). Not good for UNICODE case
        #* since # of chars >> len(s). Time Complexity: O(NUM_CHAR * n). For small NUM_CHAR, it's basically
        #* O(n).
        if len(s) != len(t):
            return False
        
        count = [0] * self.NUM_CHAR
        base = ord('a')
        for i in range(len(count)):
            count[i] += s.count(chr(base + i))
            count[i] -= t.count(chr(base + i))
        
        # Check if all the counts are 0
        return all(x == 0 for x in count)
