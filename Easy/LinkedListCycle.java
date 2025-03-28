import java.util.HashSet;

public class LinkedListCycle {    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        // HashSet to keep track of visited nodes. We can just used default hashCode of ListNode
        HashSet<ListNode> m = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (m.contains(cur)) return true;
            m.add(cur);
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCycleConstantMemory(ListNode head) {
        // Floyd's algorithm: 2 pointers with different paces (1 and 2)
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return true;
        }
        return false;
    }
}