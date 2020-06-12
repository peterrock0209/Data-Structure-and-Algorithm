package Hw6_18001166;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
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
	
	public NodeEntry head;
    public NodeEntry tail;
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
		if (isEmpty()) {
            head = new NodeEntry(entry.getKey(), entry.getValue());
            tail = new NodeEntry(entry.getKey(), entry.getValue());
            return;
        }
		
		NodeEntry root = head;
        NodeEntry temp = new NodeEntry(entry.getKey(), entry.getValue());
        
        K keyN = (K) head.getKey();

        if (keyN.compareTo(temp.getKey()) > 0) {
            temp.next = head;
            head = temp;
        }
        else {
            K key = (K) root.getKey();
            E element = (E) root.getValue();
            NodeEntry preRoot = null;
            
            while (root.next != null && (key.compareTo(temp.getKey()) < 0 ||
                  (key.compareTo(temp.getKey()) == 0 && ((Comparable) element).compareTo(temp.getValue()) > 0))) {
            	preRoot = root;
                root = root.next;
                key = (K) root.getKey();
                element = (E) root.getValue();
            }

            key = (K) root.getKey();
            if (key.compareTo(temp.getKey()) <= 0) {
                if (key.compareTo(temp.getKey()) < 0) {
                    NodeEntry preNext = root.next;
                    if (preNext == null) {
                        tail = temp;
                        root.next = tail;
                        tail.next = null;
                    }
                    else {
                    	root.next = temp;
                        temp.next = preNext;
                    }
                }
                else {
                    if (((Comparable) element).compareTo(temp.getValue()) > 0) {
                        NodeEntry preNext = root.next;
                        root.next = temp;
                        temp.next = preNext;
                    }
                    else {
                        if (preRoot != null) {
                        	preRoot.next = temp;
                            temp.next = root;                           
                        }
                        else {
                        	NodeEntry val = head;
                            head = temp;
                            head.next = val;
                        }

                    }
                }
            }
            else {
            	preRoot.next = temp;
                temp.next = root;
            }
        }
        ++ n;
	}

	@Override
	public void insert(Object k, Object e) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
            head = new NodeEntry(k, e);
            tail = new NodeEntry(k,e);
            return;
        }
		
		NodeEntry root = head;
        NodeEntry temp = new NodeEntry(k,e);
        
        K keyN = (K) head.getKey();

        if (keyN.compareTo(temp.getKey()) > 0) {
            temp.next = head;
            head = temp;
        }
        else {
            K key = (K) root.getKey();
            E element = (E) root.getValue();
            NodeEntry preRoot = null;
            
            while (root.next != null && (key.compareTo(temp.getKey()) < 0 ||
                    (key.compareTo(temp.getKey()) == 0 && ((Comparable) element).compareTo(temp.getValue()) > 0))) {
            	preRoot = root;
                root = root.next;
                key = (K) root.getKey();
                element = (E) root.getValue();
            }

            key = (K) root.getKey();
            if (key.compareTo(temp.getKey()) <= 0) {
                if (key.compareTo(temp.getKey()) < 0) {
                    NodeEntry ptrNext = root.next;
                    if (ptrNext == null) {
                        tail = temp;
                        root.next = tail;
                        tail.next = null;
                    }
                    else {
                    	root.next = temp;
                        temp.next = ptrNext;
                    }
                }
                else {
                    if (((Comparable) element).compareTo(temp.getValue()) > 0) {
                        NodeEntry ptrNext = root.next;
                        root.next = temp;
                        temp.next = ptrNext;
                    }
                    else {
                        if (preRoot != null) {
                        	preRoot.next = temp;
                            temp.next = root;                           
                        }
                        else {
                        	NodeEntry val = head;
                            head = temp;
                            head.next = val;
                        }

                    }
                }
            }
            else {
            	preRoot.next = temp;
                temp.next = root;
            }
        }
        ++ n;
	}

	@Override
	public Entry removeMin() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
            return null;
        }
        NodeEntry root = head;
        if (head.next != null)
            head = head.next;
        else{
            tail = null;
            head = null;
        }
        -- n;
        return root;
	}

	@Override
	public Entry min() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
            return null;
        }
		return head;
	}
	
}
