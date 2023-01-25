class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        shortest_word = ''
        for word in strs:
            if shortest_word == '': 
                shortest_word = word
            elif len(shortest_word) >= len(word):
                shortest_word = word
        def slice(string, i):
            return string[0:i]
        longestCommonPrefix = ''
        for i in range(len(shortest_word)):
            x = map(slice(i), strs)
            if (all(y in word for y,word in list(x))):
                longestCommonPrefix = y
        return longestCommonPrefix
