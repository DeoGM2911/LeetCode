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

    temp_list = list()

    def add(self):
        if self.val is None:
            return list()
        if self.nxt is not None:
            self.temp_list.append(self.val)
            return self.nxt.add()
        self.temp_list.append(self.val)
        self.temp_list.sort()
        return self.temp_list

    def sort(self):
        if self.val is None:
            return
        list_val = self.add()
        if self.nxt is not None:
            self.val = list_val[0]
            return self.nxt.sort()
        else:
            self.val = list_val[0]
            return


class Solution:
    @staticmethod
    def merge_two_lists(list1: ListNode, list2: ListNode) -> ListNode:
        list1.extend(list2)
        list1.sort()
        return list1


list01 = ListNode(4)
list02 = ListNode(2, list01)
list03 = ListNode(1, list02)

list11 = ListNode(5)
list22 = ListNode(3, list11)

list3 = ListNode(1, ListNode(2, ListNode(4, ListNode(3, ListNode(5)))))

sort_list3 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))

list3.sort()

print(list3.add())