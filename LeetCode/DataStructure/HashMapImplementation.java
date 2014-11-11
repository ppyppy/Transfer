package com.solution;

public class MyHashMap<K, V> {
	private int size = 0;
	private int threshold;
	final private int DEFAULT_CAPACITY = 16;
	private double loadFactor = 0.75;
	private transient MyEntry<K, V>[] table;
	
	public MyHashMap(){
		int capacity = 1;
        while (capacity < DEFAULT_CAPACITY)
            capacity <<= 1;
		threshold = (int) (capacity/loadFactor);
		table = new MyEntry[capacity];
	}
	
 	public MyHashMap(int hashsize){
		int capacity = 1;
        while (capacity < hashsize)-
            capacity <<= 1;
		threshold = (int) (capacity*loadFactor);
		table = new MyEntry[capacity];
	}
	
	public MyHashMap(int hashsize, int loadfactor){
		this.loadFactor = loadfactor;
		int capacity = 1;
        while (capacity < hashsize)
            capacity <<= 1;
		threshold = (int) (capacity/loadFactor);
		table = new MyEntry[capacity];
	}
	
	public V put(K key, V value){
		int hashCode = key.hashCode();
		int index = hash(hashCode);
		
		for(MyEntry<K, V> entry = table[index]; entry!=null; entry=entry.next){
			if(entry.getKey()==key || entry.getKey().equals(key)){
				V oldVal = entry.getValue();
				entry.setValue(value);
				return oldVal;
			}
		}
		size++;
		addEntry(key, value, index);
		return null;
	}
	
	public V get(K key){
		int index = hash(key.hashCode());
		for(MyEntry<K, V> entry = table[index]; entry!=null; entry=entry.next){
			if(entry.getKey()==key || entry.getKey().equals(key)){
				return entry.getValue();
			}
		}
		return null;
	}
	public V remove(K key){
		int index = hash(key.hashCode());
		for(MyEntry<K, V> entry = table[index]; entry!=null; entry=entry.next){
			if(entry.getKey()==key || entry.getKey().equals(key)){
				if(entry.pre!=null)
					entry.pre.next = entry.next;
				if(entry.next!=null)
					entry.next.pre = entry.pre;
				V oldVal = entry.getValue();
				if(entry.pre==null && entry.next==null)
					table[index] = null;
				entry = null;
				size--;
				return oldVal;
			}
		}
		return null;
	}

	
	public int getSize(){
		return size;
	}
	
	private void addEntry(K key, V val, int index){
		MyEntry<K, V> old = table[index];
		MyEntry<K, V> entry = new MyEntry(key, val);
		entry.next = old;
		if(old!=null)
			old.pre = entry;
		table[index] = entry;
		if(size > threshold){
			resizeTable(2*table.length);
		}
	}
	
	private void resizeTable(int newCapacity){
		MyEntry[] newTable = new MyEntry[newCapacity];
        
        for (int j = 0; j < table.length; j++) {
            MyEntry<K,V> e = table[j];
            if (e != null) {
                do {
                    MyEntry<K,V> next = e.next;
            		int hashCode = e.getKey().hashCode();
            		int index = hashCode % newTable.length;
            		MyEntry<K, V> oldEntry = newTable[index];
            		e.next = oldEntry;
            		if(oldEntry!=null)
            			oldEntry.pre = e;
                    newTable[index] = e;
            		e = next;
                } while (e != null);
            }
        }
		table = newTable;
		threshold = (int) (newCapacity*this.loadFactor);
	}
	
	private int hash(int hashcode){
		return (hashcode % table.length);
	}
	
	public static void main(String[] args){
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>(3);
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		System.out.println(map.get(3));
		System.out.println(map.get(0));
		System.out.println(map.get(1));
		System.out.println(map.get(6));
		
	}
}

class MyEntry<K, V>{
	private K key;
	private V val;
	public MyEntry<K, V> next;
	public MyEntry<K, V> pre;
	public MyEntry(K k, V value){
		key = k;
		val = value;
		next = null;
		pre = null;
	}
	public K getKey(){
		return key;
	}
	public V getValue(){
		return val;
	}
	public void setValue(V value){
		this.val = value;
	}
}
