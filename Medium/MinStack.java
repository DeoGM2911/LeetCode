public class MinStack {
    private class Node {
        public int minVal;
        public int val;
        public Node next;
        public Node(int val, Node next, int minVal) {
            this.val = val; 
            this.next = next;
            this.minVal = minVal;
        }
    }
    public int size;
    private Node head;

    public MinStack() {
        size = 0;
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, null, val);
        }
        else {
            Node newNode = new Node(val, head, Math.min(val, head.minVal));
            head = newNode;
        }
        size++;
    }
    
    public void pop() {
        head = head.next;
        size--;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.minVal;
    }
}
