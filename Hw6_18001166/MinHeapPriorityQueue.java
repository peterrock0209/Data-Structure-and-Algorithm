package Hw6_18001166;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue {
	ArrEntry<K,E> heapPQ[];
	private int n = 0;
	private int defaultsize = 100000000;
	
	public MinHeapPriorityQueue() {
        heapPQ = new ArrEntry[defaultsize];
    }

	@Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (n == defaultsize) return;
        heapPQ[n] = new ArrEntry(entry.getKey(), entry.getValue());
        upHeap();
        n ++;
    }

    @Override
    public void insert(Object k, Object e) {
        if (n == defaultsize) return;
        heapPQ[n] = new ArrEntry(k, e);
        upHeap();
        n ++;
    }
    
    @Override
    public Entry removeMin() {
        if (isEmpty()) return null;
        Entry result = heapPQ[0];
        heapPQ[0] = heapPQ[n - 1];
        heapPQ[n - 1] = null;
        n --;
        downHeap();
        return result;
    }
    
    @Override
    public Entry min() {
        if (isEmpty()) return null;
        return heapPQ[0];
    }
	
	protected void upHeap() {
		int index = n;
        while (true) {
            if (index == 0) break;
            int parent = (index / 2);
            if (index % 2 == 0) parent --;
            if (heapPQ[parent].getKey().compareTo(heapPQ[index].getKey()) != 0) {
                if (heapPQ[parent].getKey().compareTo(heapPQ[index].getKey()) > 0) {
                    ArrEntry<K, E> temp = heapPQ[parent];
                    heapPQ[parent] = heapPQ[index];
                    heapPQ[index] = temp;
                    index = parent;
                }
                else
                    break;
            }
            
            else {
                if (((Comparable) heapPQ[parent].getValue()).compareTo(heapPQ[index].getValue()) > 0) {
                    ArrEntry<K, E> temp = heapPQ[parent];
                    heapPQ[parent] = heapPQ[index];
                    heapPQ[index] = temp;
                    index = parent;
                }
                
                else
                    break;
            }
        }
	} 
	
	protected void downHeap() {
		int index = 0;
        while (true) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            if (rightChild < size()) {
                if (heapPQ[leftChild].getKey().compareTo(heapPQ[rightChild].getKey()) != 0) {
                    if (heapPQ[leftChild].getKey().compareTo(heapPQ[rightChild].getKey()) > 0) {
                        int temp = leftChild;
                        leftChild = rightChild;
                        rightChild = temp;
                    }
                }
                
                else {
                    if (((Comparable) heapPQ[leftChild].getValue()).compareTo(heapPQ[rightChild].getValue()) > 0) {
                        int temp = leftChild;
                        leftChild = rightChild;
                        rightChild = temp;
                    }
                }
            }
            
            if (leftChild >= size()) break;
            boolean flag = true;
            if (heapPQ[index].getKey().compareTo(heapPQ[leftChild].getKey()) != 0) {
                if (heapPQ[index].getKey().compareTo(heapPQ[leftChild].getKey()) > 0) {
                    ArrEntry temp = heapPQ[index];
                    heapPQ[index] = heapPQ[leftChild];
                    heapPQ[leftChild] = temp;
                    index = leftChild;
                }
                
                else {
                    if (rightChild < size()) {
                        if (heapPQ[index].getKey().compareTo(heapPQ[rightChild].getKey()) != 0) {
                            if (heapPQ[index].getKey().compareTo(heapPQ[rightChild].getKey()) > 0) {
                                ArrEntry temp = heapPQ[index];
                                heapPQ[index] = heapPQ[rightChild];
                                heapPQ[rightChild] = temp;
                                index = rightChild;
                            }
                            else break;
                        }
                        
                        else {
                            if (((Comparable) heapPQ[index].getValue()).compareTo(heapPQ[rightChild].getValue()) > 0) {
                                ArrEntry temp = heapPQ[index];
                                heapPQ[index] = heapPQ[rightChild];
                                heapPQ[rightChild] = temp;
                                index = rightChild;
                            }
                            else break;
                        }
                    }
                    else break;
                }
            }
            
            else {
                if (((Comparable) heapPQ[index].getValue()).compareTo(heapPQ[leftChild].getValue()) > 0) {
                    ArrEntry temp = heapPQ[index];
                    heapPQ[index] = heapPQ[leftChild];
                    heapPQ[leftChild] = temp;
                    index = leftChild;
                }
                else break;
            }

        }
	} 
	
    public void print(int root, int lv) {
        if (root < 0 || root > n || heapPQ[root] == null) return;
        lv += 10;
        print(root * 2 + 2, lv);
        System.out.print("\n");
        for (int i = 10; i < lv; i++) 
            System.out.print(" ");
        	System.out.print(heapPQ[root].getKey() + "\t");
        	print(root * 2 + 1, lv);
    }

}
