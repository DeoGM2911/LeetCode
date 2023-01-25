class Solution:
    def removeElement(self, nums: list[int], val: int) -> int:
        i = 0 
        while True:
            if i == len(nums):
                return i
            if nums[i] == val:
                del(nums[i])
                i -= 1
            i += 1


""" Reference code:
class Solution:
def removeElement(self, nums: List[int], val: int) -> int:
    length = len(nums)
    i = 0
    while i<length:
        if nums[i] == val:
            del(nums[i])
            i -= 1
            length -=1
        i += 1
    return length
"""
