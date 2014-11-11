//Design and implement a data structure for Least Recently Used (LRU) cache. 
//It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
//otherwise return -1.

//set(key, value) - Set or insert the value if the key is not already present. 

//When the cache reached its capacity, it should invalidate the least recently used item 
//before inserting a new item.

public class LRUCache {  
    private int capacity;  
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();  
    private Node head = new Node(-1, -1);  
    private Node tail = new Node(-2, -2);  
  
    public LRUCache(int capacity) {  
        this.capacity = capacity;  
        head.next = tail;  
        tail.pre = head;  
    }  
  
    public int get(int key) {  
        if (!map.containsKey(key))  
            return -1;  
        Node cur = map.get(key);  
        cur.pre.next = cur.next;  
        cur.next.pre = cur.pre;  
        attach(cur);  
        return cur.value;  
    }  
  
    public void set(int key, int value) {  
        if (map.containsKey(key)) {  
            Node cur = map.get(key);  
            cur.value = value;  
            cur.pre.next = cur.next;  
            cur.next.pre = cur.pre;  
            attach(cur);  
        } else {  
            if (map.size() == capacity)  
                dettach();  
            Node cur = new Node(key, value);  
            attach(cur);  
            map.put(key, cur);  
        }  
    }  
      
    public void dettach(){  
        Node last = tail.pre;  
        last.pre.next = last.next;  
        last.next.pre = last.pre;  
        map.remove(last.key);  
    }  
      
    public void attach(Node cur){  
        cur.next = head.next;  
        cur.next.pre = cur;  
        head.next = cur;  
        cur.pre = head;  
    }  
  
    private class Node {  
        public Node pre = null;  
        public int key;  
        public int value;  
        public Node next = null;  
  
        Node(int key, int value) {  
            this.key = key;  
            this.value = value;  
        }  
    }  
}  

//java implementation

public class LRULinkedHashMap extends LinkedHashMap<Object, Object> {
	private static final long serialVersionUID = 1L;
	private final int capacity;
	public LRULinkedHashMap(int capacity) {
		super(capacity + 1, 1.1F, true);
		//Setting the load factor to 1.1 ensures that the rehashing mechanism of the 
		//underlying HashMap class isn't triggered - this isn't a vital point but helps 
		//a little with efficiency at run-time. 
		//initialCapacity - the initial capacity
		//loadFactor - the load factor (usually in java using 0.75)
		//accessOrder - the ordering mode - true for access-order, false for insertion-order
		this.capacity = capacity;
	}

	protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
		//The removeEldestEntry(Map.Entry) method may be overridden to impose a policy 
		//for removing stale mappings automatically when new mappings are added to the map.
		return size() > capacity;
	}
	
	 public Object get(Object key, Object value)
	  {
	    if (containsKey(key))
	    {
	      return super.get(key);
	    }
	    super.put(key, value);
	    return value;
	  }
	
	public static void main(String[] args){
			LRULinkedHashMap cache = new LRULinkedHashMap(5);
			cache.put(1, 1);
			cache.put(2, 2);
			cache.put(3, 3);
			cache.put(4, 4);
			cache.put(5, 5);
			cache.get(1, 1);
			cache.get(8, 8);
			cache.put(6, 6);
			cache.put(7, 7);
		    System.out.println(cache);
		    //{5=5, 1=1, 8=8, 6=6, 7=7}

	}
}