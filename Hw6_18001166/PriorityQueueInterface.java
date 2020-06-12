package Hw6_18001166;

public interface PriorityQueueInterface<K , E> {
	public int size();
	public boolean isEmpty(); 
	public void insert(Entry<K, E> entry); //add a entry into PQ
	public void insert(K k, E e); //add a element has key & value into PQ
	public Entry<K, E> removeMin(); //remove element has minimal value
	public Entry<K, E> min(); //return element has minimal value 
}