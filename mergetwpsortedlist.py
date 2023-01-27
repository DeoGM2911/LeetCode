class ListNode:
    def __init__(self, val=0, nxt=None):
        self.val = val
        self.nxt = nxt


class Solution:
    def mergeTwoLists(self, list1, list2):
        cur = res = ListNode()
        while list1 and list2:  # until one list ran out               
            if list1.val < list2.val:
                cur.nxt = list1  # set the first node behind the origin node (cur/dummy) as node 1
                list1, cur = list1.nxt, list1  # Move the to the next element of list 1 and compare with list 2 (not move yet)
            else:
                cur.nxt = list2  # set the first node behind the origin node (cur/dummy) as node 2
                list2, cur = list2.nxt, list2   # Move the to the next element of list 2 and compare with list 1(not move yet)
                
        if list1 or list2:  # if we have blank list1 or list2 left (or to begin with)
            cur.nxt = list1 if list1 else list2
            
        return res.nxt  # The resulting list