package Hw3_18001166;

import java.util.Iterator;

	//Tạo giao diện ListInterface kế thừa giao diện Iterable
	public interface ListInterface<T> extends Iterable<T> {
	public void add(T data);
	public T get(int i);
	public void set(int I, T data);
	public void remove(T data);
	public boolean isContain(T data);
	public int size();
	public boolean isEmpty();
}
	
	
