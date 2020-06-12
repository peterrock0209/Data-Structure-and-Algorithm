/* This is lesson 1.1
 * Binary Tree using array*/

package Hw5_18001166;

import java.io.FileWriter;
import java.io.IOException;

public class ArrayBinaryTree<E,T> implements BinaryTreeInterface<T> {
	
	private String fileoutput = "";
	private E [] array;
	private int n = 0;
	private int defaultsize = 100;
	
	@SuppressWarnings("unchecked")
	public ArrayBinaryTree(){
		array = (E[]) new Object[defaultsize]; 
	}
	
	// update methods
	// Set element to root of an empty tree (at index 1)
	/* nếu gốc trống thì gán giá trị và tăng n, 
	 * ngược lại thay thế = element*/
	public void setRoot(E element) {
		if(isEmpty()) {
			array[1] = element;
			n ++;
		}else {
			array[1] = element;
		}
	}
	
	// Set left child of p (at index 2p)
	public void setLeft(int p, E element) {
		if(isEmpty()) return;
		if(p >= array.length / 2 || array[p] == null) return; // kiểm tra tránh tràn mảng
		if(array[2*p] == null) {                 
			array[2*p] = element; // nếu trống thì mới tăng n, ngược lại chỉ gán
			n ++;
		}else {
			array[2*p] = element;
		}
	}
	
	// Set right child of p (at index 2p + 1)
	public void setRight(int p, E element) {
		if(isEmpty()) return;
		if(p >= (array.length - 1) / 2 || array[p] == null) return;
		if(array[2*p + 1] == null) {
			array[2*p + 1] = element;
			n ++;
		}else {
			array[2*p + 1] = element;
		}
	}
	
	// print the elements of tree
	public void printTree() {
		for (int i = 1; i <= n; i++) {
			if(array[i] != null) {
				System.out.print(array[i]+ " ");
			}else 
				System.out.print("null ");
		}
	}
	
	// print tree
	public void print(T p, int lv) {
		if(p == null) return;
		int k =(int) p;
		print(right(p), lv + 1);
		for (int i = 0; i < lv; i++) {
			System.out.print("\t");
		}
		System.out.println(array[k]);
		print(left(p), lv + 1);
	}
	
	// print to file using file writer
	public void printText(T p, int lv) {
		if(p == null) return;
		int k =(int) p;
		printText(right(p), lv + 1);
		for (int i = 0; i < lv; i++) {
			fileoutput += "\t";
		}
		fileoutput += array[k] +"\n";
		printText(left(p), lv + 1);
	}
	
	public void printFile() throws IOException {
		fileoutput = "";
		printText(root(), 0);
		FileWriter myWriter = new FileWriter("/C:/binarytree.txt/");
		myWriter.write("This is a binary tree printed using ArrayBinaryTree " + "\n");
        myWriter.write(fileoutput);
        myWriter.close();
	}
	
	@Override
	public T root() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		else return (T) Integer.valueOf(1);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0 ;
	}
	@Override
	public int numChildren(T p) {
		// TODO Auto-generated method stub
		// return number of child of p
		if(!(p instanceof Integer)) return -1;
		if(isEmpty()) return -1;
		int k =(int) p;
		if(k >= array.length || array[k] == null) return -1; // kiểm tra tràn mảng trước
		
		int count=0;
		if (left(p) != null) count++;
		if (right(p) != null) count++;
		return count;
	}
	
	@Override
	public T parent(T p) {
		// TODO Auto-generated method stub
		// return position of parent
		if(!(p instanceof Integer)) return null;
		if(isEmpty()) return null;
		int k =(int) p;
		if(k >= array.length || array[k] == null) return null; 
		
		k = Math.floorDiv(k, 2);
		if(array[k] == null) return null;
		return (T) Integer.valueOf(k);
	}
	
	@Override
	public T left(T p) {
		// TODO Auto-generated method stub
		// return position of leftChild
		if(!(p instanceof Integer)) return null;
		if(isEmpty()) return null;
		int k =(int) p;
		if(k >= array.length || array[k] == null) return null;
		
		k = 2*k;
		if(k >= array.length || array[k] == null) return null;
		return (T) Integer.valueOf(k);
	}
	
	@Override
	public T right(T p) {
		// TODO Auto-generated method stub
		// return position of rightChild
		if(!(p instanceof Integer)) return null;
		if(isEmpty()) return null;
		int k =(int) p;
		if(k >= array.length || array[k] == null) return null;
		
		k = 2*k +1;
		if(k >= array.length || array[k] == null) return null;
		return (T) Integer.valueOf(k);
	}
	
	@Override
	public T sibling(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Integer)) return null;
		if(isEmpty()) return null;
		int k =(int) p;
		if(k >= array.length || array[k] == null) return null;
		
		if(k%2 == 0) {
			k = k + 1;
		}else {
			k = k - 1;
		}
		if(k >= array.length || array[k] == null) return null;
		return (T) Integer.valueOf(k);
	}
	
	// get element of array
	public E getElement(T p) {
		if(!(p instanceof Integer)) return null;
		int k =(int) p;
		if(k >= array.length || array[k] == null) return null;
		return array[k];
	}

}
