package Hw7_18001166;

import java.util.Iterator;

public class BSTArray<T extends Comparable<T>> implements ListInterface<T> {
	private T[] array;
	private int n;
	private int defaultSize = 100;
	public BSTArray() {
		array = (T[]) new Comparable[defaultSize];
	}

	public BSTArray(int capacity) {
		array = (T[]) new Comparable[capacity];
	}
	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {

            private int curIndex = 0;

            @Override
            public boolean hasNext() {
                return (curIndex < n) && array[curIndex]!= null;
            }
            @Override
            public T next() {
                if (hasNext()){
                    return array[curIndex++];
                }
                return null; 
            }
		};
        return it;
	}

	@Override
	public void add(T data) {
		n++;
		this.array[n-1] = data;
	}
	
	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		if(i < n) {
			return array[i];
		}
		return null;
	}

	@Override
	public void set(int i, T data) {
		// TODO Auto-generated method stub
		if(i < 0 || i >= n) {
			System.out.println("Out of range");
		}
		else {
			array[i] = data;
		}
	}

	@Override
	public void remove(T data) {
		for(int i = 0; i < array.length; i++) {
			if(data.equals(array[i])) { 
				for(int k = i; k<array.length-1;k++) {
					array[k] = array[k+1];
				}
				array[n] = null;
				n--;
			}
		}
	}

	@Override
	public void isContain(T data) {
		int i = 0;
		while((i < array.length) && (array[i] != data)){
			i++;
		}
		if(i > array.length-1) {
			System.out.println("Not found!");
		}else {
			System.out.println("Element found at index " + i);
		}
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
	public int indexOf(T data) {
		for (int i = 0; i < n; i++) {
			if (array[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}
}

