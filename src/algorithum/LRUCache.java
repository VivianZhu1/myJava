package algorithum;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * HashMap + doubly-linked list implementation:
 */
public class LRUCache {
	
    private class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0, 0);
        }
    }
    
    
    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }
    
    public void set(int key, int value) {
        Node n = map.get(key);
        if(null==n){
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            ++count;
        }
        else{
            n.value = value;
            update(n);
        }
        if(count>capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }
    
    private void update(Node node){
        remove(node);
        add(node);
    }
    private void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }
    
    public static void main(String[] args) {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(2,  "2");
		map.put(1,"1");
		map.put(10,"10");
		map.put(3,"3");
		
		for (Integer i : map.keySet()) {
			System.out.println(i+","+map.get(i));
		}
		
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(2,  "2");
		map1.put(1,"1");
		map1.put(10,"10");
		map1.put(3,"3");
		
		for (Integer i : map.keySet()) {
			System.out.println(i+","+map1.get(i));
		}
		for (Integer i : map.keySet()) {
			System.out.println(i+","+map1.get(i));
		}
	}
}

class LRUCacheLazy {
	
	 private LinkedHashMap<Integer, Integer> map;
	 
     private final int CAPACITY;
     
     public LRUCacheLazy(int capacity) {
    	 
         CAPACITY = capacity;
         
         map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
        	 
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("rawtypes")
			protected boolean removeEldestEntry(Map.Entry eldest) {
                
            	 return size() > CAPACITY;
             }
         };
     }
     public int get(int key) {
         return map.getOrDefault(key, -1);
     }
     
     public void set(int key, int value) {
         map.put(key, value);
     }
     
}
