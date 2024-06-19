public class AddTwoNum {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode head = new ListNode(0);
        ListNode cur = head;
        int v1, v2;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null) v1 = 0;
            else v1 = l1.val;

            if (l2 == null) v2 = 0;
            else v2 = l2.val;

            cur.next = new ListNode((v1 + v2 + carry) % 10);
            carry = (v1 + v2 + carry) / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }

        return head.next;
    }
}
