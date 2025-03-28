public class LinkedListCycle2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }

    /**
     * Here is a proof why we can find the entry point by reseting the slow pointer and move both pointers
     * 1 step at a time until they meet each other. Let x be the distance from the head to the entry point.
     * Let c be the length of the cycle, t be the distance from the start to the meeting point of the fast 
     * and slow pointers, and p be the distance from that meeting point to the entry point. Then, we know that 
     * 2t = t + Nc where N is an integer. Since the fast pointer moves t extra steps, it means that it must
     * move in the cycle for some multiple of c. Thus, t = Nc. Now, note that x + p = t = Nc or Nc - p = x.
     * Then, if our fast pointer move x steps, it must end up at the entry point of the cycle. Fast pointer is
     * p steps into the cycle, move Nc more cycles, then move back p steps, which is exactly the starting point.    
     */

    public ListNode detectCycle(ListNode head) {
        // Floyd's algorithm for finding cycle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // Cycle detected, seek the entry node
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}