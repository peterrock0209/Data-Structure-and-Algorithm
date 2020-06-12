package Hw4_18001166;

import java.util.Iterator;

public class ArrayListStack<E> implements StackInterface<E> {

    private E[] array;
    private int n = 0;
    private int defaultSize = 1000000;

    // Generate a stack with default size.
    @SuppressWarnings("unchecked")
    public ArrayListStack() {
        array = (E[]) new Object[defaultSize];
    }

    // Generate stack with given size.
    @SuppressWarnings("unchecked")
    public ArrayListStack(int size) {
        array = (E[]) new Object[size];
    }

    // Return an iterator.
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private int curInd = 0;

            @Override
            public boolean hasNext() {

                return curInd < n && array[curInd] != null;
            }

            @Override
            public E next() {

                return array[curInd++];
            }
        };
        return it;
    }
    
    public void outputStack() {
		Iterator<E> iterator = iterator();
	    while (iterator.hasNext()) {
	      E val = iterator.next();
	      System.out.print("["+val+"]  ");
	    }
	    System.out.println();
  	}

    // Push an element on top.
    @Override
    public void push(E element) throws IllegalStateException {
        if (n < array.length) {
            array[n++] = element;
        } else {
            throw new IllegalStateException("Stack is full");
        }
    }

    // Remove top element.
    @Override
    public E pop() throws NullPointerException {
        if (n != 0) {
            n--;
            E lastElem = array[n];
            array[n] = null;
            return lastElem;
        }
        throw new NullPointerException("Stack is empty");

    }

    // Check empty
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    // Return first element.
    @Override
    public E top() throws NullPointerException {
        if (n != 0) {
            return array[n - 1];
        }
        throw new NullPointerException("Stack is empty");

    }
}

