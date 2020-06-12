package Hw3_18001166;

import java.util.Arrays;
import java.util.Iterator;

    //Tạo lớp SimpleArrayList cài đặt giao diện ListInterface
	public class SimpleArrayList <T> implements ListInterface<T> {
	private T[] array;
	private int n = 0;
	private int defaultSize = 100;
	
	@SuppressWarnings("unchecked")
    public SimpleArrayList(){
        array = (T[]) new Object[defaultSize];
    }

    @SuppressWarnings("unchecked")
    public SimpleArrayList(int capacity){
        this.array = (T[]) new Object[capacity];
    }
    
	public void add(T data) {
		boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                array[i] = data;
                check = true;
                break;
            }
        }
        if(check == false){
            array = Arrays.copyOf(array, n + 1);
            array[n] = data;
        }
        n++;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
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

	public T get(int i) {
		// TODO Auto-generated method stub
		return array[i];
	}

	public void set(int i, T data) {
		// TODO Auto-generated method stub
		array[i] = data;
	}

	public void remove(T data) {
		// TODO Auto-generated method stub
		int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!= data){
                array[j] = array[i];
                j++;
            }
            else {
                n--;
            }
        }
        array = Arrays.copyOf(array, n);
	}
	
	@Override
	/* public boolean isContain(T data){
		// TODO Auto-generated method stub
		if(Arrays.binarySearch(array, data) < 0){
            return false;
        }
        else return true;
	} */

	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	public boolean isContain(T data) {
		// TODO Auto-generated method stub
		if(Arrays.binarySearch(array, data) < 0){
            return false;
        }
        else return true;
	}
	public void print(SimpleArrayList<T> a) {
		for (int i = 0; i < a.size(); i++) {
	    	  System.out.print(a.get(i)+ "    ");
		}
	}
}