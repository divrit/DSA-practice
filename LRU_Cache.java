public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(created);
            map.put(key, created);
        }
    }

    private void remove(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            end = n.prev;
        }
    }

    private void setHead(Node n) {
        n.next = head;
        n.prev = null;

        if (head != null) {
            head.prev = n;
        }

        head = n;

        if (end == null) {
            end = head;
        }
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
