import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    private int capacity;
    private LinkedList<ListNode> cache;
    private HashMap<Integer, ListNode> cacheMap;

    private class ListNode {
        public int val;
        public int key;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedList<>();
        cacheMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            // Update the priority
            cache.add(cacheMap.get(key));
            cache.remove(cacheMap.get(key));  // This can be in O(1) using a doublyLinkedList with head and tail pointers
            return cacheMap.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cacheMap.size() == capacity) {
            if (!cacheMap.containsKey(key)) {
                int lru_key = cache.removeFirst().key;
                cacheMap.remove(lru_key);
                cache.add(new ListNode(key, value));
                cacheMap.put(key, cache.getLast());
            }
            else {
                cache.add(cacheMap.get(key));
                cache.remove(cacheMap.get(key));
                cacheMap.get(key).val = value;
            }
        }
        else {
            if (!cacheMap.containsKey(key)) {
                cache.add(new ListNode(key, value));
                cacheMap.put(key, cache.getLast());
            }
            else {
                cache.add(cacheMap.get(key));
                cache.remove(cacheMap.get(key));
                cacheMap.get(key).val = value;
            }
        }
    }
}