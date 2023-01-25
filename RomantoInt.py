class Solution:
    def romanToInt(self, s: str) -> int:
        #'Fastest Solution'
        converter = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
        total, prev = 0, 0
        for char in reversed(s): #reverse the sequence of the string
            if converter[char] < prev: # IV = V - I (hence the reversed class)
                total -= converter[char]
            else:
                total += converter[char]
            prev = converter[char]
        return total
        # Least Memory required
        #My solution
        ''' special_case = {'IV':4,'IX':9,'XL':40,'XC':90,'CD':400,'CM':900}
        integer = 0
        for case in special_case.keys():
            if case in s:
                integer += special_case[case]
                s = s.replace(case,'')
        for i in range(len(s)):
            integer += converter.get(s[i])
        return integer'''
x = Solution()
print(x.romanToInt('MMCDXLII'))              