package Hw6_18001166;

public class Demo<K extends Comparable, E> implements PriorityQueueInterface {
	public static class ArrEntry<K, E> implements Entry<K, E>{
		K key; 
		E element;
		public ArrEntry (K k, E e){
			this.key = k;
            this.element = e;
        }
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}
		@Override
		public E getValue() {
			// TODO Auto-generated method stub
			return element;
		} 
		
		@Override
        public String toString() {
            return "key = " + key +", element = " + element ;
        }
	}
	
	ArrEntry<K, E> [] array;
	int n = 0;
	int defaultsize = 1000;
	
	// constructor
	public Demo() {
        array = new ArrEntry[defaultsize];
    }
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}
	
	@Override
	public void insert(Entry entry) {
		// TODO Auto-generated method stub
		if (n == defaultsize) return;
        array[n] = new ArrEntry(entry.getKey(), entry.getValue());
        n += 1;
    }
	
	@Override
	public void insert(Object k, Object e) {
		// TODO Auto-generated method stub
		if (n == defaultsize) return;
		array[n] = new ArrEntry(k, e);
		n += 1;
	}
	
	@Override
	public Entry removeMin() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("Queue is empty, don't remove!"); 
			return null;
		}
		
		ArrEntry min = array[0];
		int point = 0;
		for (int i = 0; i < n; i++) {
			if(array[i].getKey().compareTo(min.getKey()) < 0) {
				min = array[i];
				point = i;
			}
			else if(array[i].getKey().compareTo(min.getKey()) == 0) {
				if(((Comparable) array[i].getValue()).compareTo(min.getValue()) < 0) {
					min = array[i];
					point = i;
				}
			}
		}
		
		for (int j = point; j < n - 1; j++) {
			array[j] = array[j+1];
		}
		
		n--;
		return min;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Entry min() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
        ArrEntry min = array[0];
        for (int i = 0; i < n; i++) {
			if(array[i].getKey().compareTo(min.getKey()) < 0) {
				min = array[i];
			}else if(array[i].getKey().compareTo(min.getKey()) == 0) {
				if(((Comparable) array[i].getValue()).compareTo(min.getValue()) < 0) {
					min = array[i];
				}
			}
		}
        return min;
	}
	
	public void sort() {
		int pos = 0;
		for (int i = 0; i < n; i++) {
			pos = i;
			ArrEntry temp = array[i];
			for (int j = i+1; j < n; j++) {
				if (array[j].getKey().compareTo(array[pos].getKey()) < 0 ) {
					temp = array[j];
					pos = j;
				}
			}
			array[pos] = array[i];
			array[i] = temp;
		}
	}
	
	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(array[i].getKey() + " " + array[i].getValue());
		}
	}
	public static void main(String []args) {
		
		Demo pq = new Demo();
		long start = System.nanoTime();
		ArrEntry value;
		value = new Demo.ArrEntry(2, "am");
		pq.insert(value);
		value = new Demo.ArrEntry(5, "I");
		pq.insert(value);
		value = new Demo.ArrEntry(7, "a");
		pq.insert(value);
		value = new Demo.ArrEntry(8, "scientist!");
		pq.insert(value);
		
		pq.insert(1, "I");
		pq.insert(3, "Peter");
		pq.insert(4, "Rock");
		pq.insert(6, "am");
		pq.sort();
		pq.print();
		long end = System.nanoTime();
		System.out.println("Time: " + (end - start));
		
//		while(!pq.isEmpty()) {
//		    System.out.println("----------------------------------");
//		    System.out.println("*Minimum has: " + pq.min());
//		    System.out.println("*Remove min!");
//		    System.out.println("----------------------------------");
//		    pq.removeMin();
//		    pq.print();
//		}
//		if(pq.isEmpty()) {
//			System.out.println("Priority queue is empty, don't remove :>>");
//		}
	}
}
