class Solution():
    def wordSubsets(self, A, B):
        def count(word):
            #there are 26 characters in the English alphabet
            answer = [0] * 26
            for letter in word:
                #the index in the list starts at 0 corresponding to the letter 'a'
                #return a list consists of counts corresponding to each letter in the alpabet
                answer[ord(letter) - ord('a')] += 1
            return answer

        bmax = [0] * 26
        for b in B:
            for i, c in enumerate(count(b)):
                #Check whether the character has the largest count
                bmax[i] = max(bmax[i], c) 

        answer = []
        for a in A:
            if all(x >= y for x, y in zip(count(a), bmax)):
                answer.append(a)
        return answer
x = Solution()
print(x.wordSubsets(['facebook','google','dsadwqvinhbhsauyc','dskajhuiy','leetcode'],['dsa']))