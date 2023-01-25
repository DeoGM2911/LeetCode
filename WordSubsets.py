# The idea is to create a dictionary that consists of all characters with their max counts.
# Then check each word in words1 whether it contains more or equal number of the value corresponding to the character
class Solution:
    def wordSubsets(self, words1: list[str], words2: list[str]) -> list[str]:
        self.words1 = words1
        self.words2 = words2
        self.list_words_OK = []
        self.dict_words2 = {}
        for word in words2:
            self.dict_temp = {}
            for char in word:
                self.dict_temp[char] = self.dict_temp.get(char,0) + 1
                for char, count in self.dict_temp.items():
                    if char in self.dict_words2:
                        self.dict_words2[char] = max (count, self.dict_temp[char])
                    else:
                        self.dict_words2[char] = count
        for word in self.words1:
            isValid = True
            for char in self.dict_words2.keys():
                if word.count(char) < self.dict_words2[char]:
                    isValid = False
                    break
                elif isValid:
                    self.list_words_OK.append(word)
            '''self.dict_words1 = {}
            for char in word:
                self.dict_words1[char] = self.dict_words1.get(char,0) + 1
            if not all(x in self.dict_words1.keys() for x in self.dict_words2.keys()):
                continue
            else:
                n = 0
                for chars in self.dict_words2.keys():
                    if self.dict_words1[chars] < self.dict_words2[chars]:
                        break
                    else:
                        n += 1
                        if n == len(self.dict_words2.keys()):
                            self.list_words_OK.append(word)'''
        return self.list_words_OK
x = Solution()
print(x.wordSubsets(["dcbddbbbeb","edeabaedbc","beecbdbabe","bacadddbda","ecbdebddbb","abeabbcaaa","eabbdbadbb","aacabeacde","bcceeaccae","ebbdebbcad"],
["add","b","ba","ada","dcd"]))