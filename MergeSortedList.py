class ListNode:
    def __init__(self, val, nxt=None):
        self.val = val
        self.nxt = nxt

    def __eq__(self, obj) -> bool:
        if self.val == obj.val and self.nxt == obj.nxt:
            return True
        return False

    def extend(self, list2):
        if self.nxt is None:
            self.nxt = list2
            return
        return self.nxt.extend(list2)

    val_list = list()

    def values(self):
        if self.val is None:
            return list()
        if self.nxt is None:
            self.val_list.append(self.val)
            return self.val_list
        self.val_list.append(self.val)
        return self.nxt.values()

    def sort(self, list_val=None, i=0):
        if self.val is None:
            return
        if i == 0:
            list_val = self.values()
            list_val.sort()
        if i != 0:
            i = 0
        if self.nxt is not None:
            self.val = list_val[0]
            list_val.pop(0)
            return self.nxt.sort(list_val, i + 1)
        else:
            self.val = list_val[0]
            list_val.pop(0)
            return


class Solution:
    @staticmethod
    def merge_two_lists(list1: ListNode, list2: ListNode) -> ListNode:
        list1.extend(list2)
        list1.sort()
        return list1


# Testing
if __name__ == "__main__":
    list01 = ListNode(4)
    list02 = ListNode(2, list01)
    list03 = ListNode(1, list02)

    list11 = ListNode(5)
    list22 = ListNode(3, list11)

    list3 = ListNode(1, ListNode(2, ListNode(1, ListNode(2, ListNode(4, ListNode(3, ListNode(5)))))))
    sort_list3 = ListNode(1, ListNode(1, ListNode(2, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))))
    
    list3.sort()
    print(list3 == sort_list3)
