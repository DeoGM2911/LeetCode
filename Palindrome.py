class Solution:
    def isPalindrome_UsingInt(self, x: int) -> bool:
        self.x = x
        if x < 0: return False
        pass

    def isPalindrome_UsingStr(self, y: int) -> bool:
        self.y = y
        y_str = str(y)
        for i in range(int(len(y_str) / 2)):
            if y_str[i] != y_str[len(y_str) - 1 - i]:
                return False
        return True

    def isPalindrome_Best(self, x: int):
        x_str = str(x)
        if x_str[::] == x_str[::-1]:
            return True
        return False


x = Solution()
print(x.isPalindrome_Best(-1))
print('abcdefghijk'[::-3])
