package Hw7_18001166;


public interface BinarySearchTreeInterface<T> {

    public void add(T data);
     
    public void remove(T data);
     
    public void removeMin();
     
    public void removeMax();     

    public void levelOrderTraversal();
     
    public void inOrderTraversal();
     
    public boolean isEmpty();

    public int size();
     
}
