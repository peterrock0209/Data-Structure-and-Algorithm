package Hw6_18001166;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
	protected class NodeEntry<K, E> implements Entry<K, E>{
		private K key;
		private E element;
		private NodeEntry<K, E> next;
		
		public NodeEntry (K k, E e){
			this.key = k;
			this.element = e;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}
		@Override
		public E getValue() {
			// TODO Auto-generated method stub
			return this.element;
		} 
		@Override
		public String toString() {
			return key + " " + element;
		}
		
	}
	
	public NodeEntry<K,E> head;
	public NodeEntry<K,E> tail;
	int n = 0;
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}
	@Override
	public void insert(Entry entry) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			head = new NodeEntry(entry.getKey(), entry.getValue());
			tail = new NodeEntry(entry.getKey(), entry.getValue());
			n ++; 
			return;
		}
		
		NodeEntry root = head;
		head = new NodeEntry(entry.getKey(), entry.getValue());
		head.next = root;
		n ++;
	}
	@Override
	public void insert(Object k, Object e) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			head = new NodeEntry(k, e);
			tail = new NodeEntry(k,e);
			n ++;
		}
		
		NodeEntry root = head;
		head = new NodeEntry(k, e);
		head.next = root;
		n ++;
	}
	
	@Override
	public Entry removeMin() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		
		K minKey = null; 
        NodeEntry root = head;
        NodeEntry min = head, preMin = null;
        minKey = (K) root.key;
        
        // find minimum element
        while (root.next != null) {
            K keyNext = (K) root.next.key;
            if (keyNext.compareTo(minKey) < 0) {
            	min = root.next;
                preMin = root;
                minKey = keyNext;
            }
            root = root.next;
        }

        // remove minimum element
        if (preMin == null) {
            if (min.next != null) {
                head = min.next;
            }
            else {
                head = tail = null;
            }
        }else {
            if (min.next != null) {
                preMin.next = min.next;
            }
            else {
                preMin.next = null;
                tail = preMin;
            }
        }
        -- n;
        return min;
	}
	
	@Override
	public Entry min() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("Priority queue is empty!");
			return null;
		}
		
		K minKey = null;
        NodeEntry root = head;
        NodeEntry min = head;
        minKey = (K) root.key;

        while (root.next != null) {
            K keyNext = (K) root.next.key;
            if (keyNext.compareTo(minKey) < 0) {
            	min = root.next;
                minKey = keyNext;
            }
            root = root.next;
        }
        return min;  
	}
}