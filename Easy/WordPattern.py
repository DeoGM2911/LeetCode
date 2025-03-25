class Solution(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type s: str
        :rtype: bool
        """
        #* The idea is straight forward, we map evert character in the pattern to a word in the same
        #* position in the string s (and the reverse). If we found a mismatch as we fill up our maps,
        #* return False. Note a mitch match can be of length, of 2 chars share same word, or 2 words 
        #* share the same char. 
        words = s.split(' ')
        if len(words) != len(pattern): return False  # Different length => not follow
        
        pattern_map = {}
        word_map = {}  # Could also use a list or a set to keep track which words have been seen
        for i in range(len(pattern)):
            if pattern[i] not in pattern_map:
                if words[i] in word_map:
                    return False
                pattern_map[pattern[i]] = words[i]
                word_map[words[i]] = None
            elif pattern_map[pattern[i]] != words[i]:
                return False
        return True