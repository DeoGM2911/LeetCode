class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: Optional[ListNode]
        :type k: int
        :rtype: Optional[ListNode]
        """
        #* The approach is straightforward: Splice the last k elements and make them the 
        #* head of the list (and of course concatenate the original last and original head)
        # Check some base cases first
        if head is None or head.next is None or k == 0:
            return head
        
        # Find the length of the list
        n = 0  # n will guaranteed > 1.
        cur = head
        last = None  # The last element
        while cur is not None:
            n += 1
            if cur.next is None:
                last = cur
            cur = cur.next
        # If k == 0, nothing to do
        k = k % n
        if k == 0: return head
        
        # Find the n-k element and its parent
        cur = head
        prev = None  # The n-k element
        i = n
        while i != k:
            prev = cur
            cur = cur.next
            i -= 1
        # Cut the end and make it the new head
        prev.next = None
        last.next = head
        return cur