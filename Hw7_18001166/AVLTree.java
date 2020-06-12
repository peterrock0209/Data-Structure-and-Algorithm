package Hw7_18001166;

import java.util.*;

public class AVLTree<T extends Comparable<T>> implements BinarySearchTreeInterface<T> {
 
    private AVLTreeNode<T> root;
    private int count = 0;
        
    public AVLTree(){
    	root = new AVLTreeNode<T>(); 
    }
    
    public void add(T data) {
    	AVLTreeNode<T> temp = new AVLTreeNode<T>(data);
        if(count == 0){
        	root = temp;
        	root.setLeft(null);
        	root.setRight(null);
        	root.setParent(null);
        	count++;
        }
        else {
          AVLTreeNode<T> current = root;
          boolean added = false;
           
          while(!added)
          {
            if(data.compareTo(current.getContent()) <0){
                if(current.getLeft() == null){
                  current.setLeft(temp);
                   temp.setParent(current);
 
                  added = true;
                  
                  }
                  else{
                  current = current.getLeft();
                      }
                  }
                  else
                  {
                   if(current.getRight() == null){
                      current.setRight(temp);
                      temp.setParent(current);
 
                      added = true;
                      }
                      else
                      {
                       current = current.getRight();
                     }
                  }
             }
 
        }
        count++;
     
    }
       
    public void remove(T target) {
     
    	if(target.equals(root.getContent())){
    	root = replacement(root);
    	count--;   
      
    	}else{
    		AVLTreeNode<T> current = null;
    		AVLTreeNode<T> parent = root;
    		boolean found = false;
    		if (target.compareTo(root.getContent()) >0)
    			current = root.getRight();
	            else
	            	current = root.getLeft();
	           
	          while((current.getContent().compareTo(target) != 0)){
		          if(target.equals(current.getContent())){
			          found = true;
			          count--;
			          if(current == parent.getLeft()){
			              AVLTreeNode<T> replacementNode = replacement(current);
			              parent.setLeft(replacementNode);
			          }
			          else{
			              AVLTreeNode<T> replacementNode = replacement(current);
			              parent.setRight(replacementNode);
			          }	
		          }
	          }
    	}
    }
  
    private AVLTreeNode<T> replacement(AVLTreeNode<T> node){
    	AVLTreeNode<T>result = null;
  
            if((node.getLeft() == null) && (node.getRight() == null))
            return null;
 
            else if((node.getLeft() != null) && (node.getRight() == null))
            return node.getLeft();
     
            else if ((node.getLeft() == null) && (node.getRight() != null))
            return node.getRight();
             
            else{
                AVLTreeNode<T> current = node.getRight();
                AVLTreeNode<T> parent = node;
   
                    while(current.getLeft() != null)
                    {
	                    parent = current;
	                    current.getLeft();
                    }
   
                    if(node.getRight() == current)
                    	current.setLeft(node.getLeft());
      
                    else
                    {
                    	parent.setLeft(current.getLeft());
                    	current.setRight(node.getRight());
                    	current.setLeft(node.getLeft());
                    }
                    result = current;
            }
            return result;
     }
             
     public void removeMin() {
      
	     T result = null;
	      
	     if (isEmpty())
	      
	     System.out.println("Binary Search Tree is Empty");
	       
	      else
	      {
	       if (root.getLeft() == null){
	         
	         result = root.getContent();
	         root = root.getRight();
	       } 
	       else{
	    	   AVLTreeNode<T> parent = root;
	    	   AVLTreeNode<T> current = root.getLeft();
	          
	    	   while (current.getLeft() != null){
	         
		         parent = current;
		         current = current.getLeft();
	    	   }
		       result = current.getContent();
		       parent.setLeft(current.getRight());
		    }	         
	        count--;
	    }
    }
                 
    public void removeMax() {
      
       T result = null;
      
       if (isEmpty())
      
       System.out.println("Binary Search Tree is Empty");
       
       else
       {
          if (root.getRight() == null)
          {
         
	         result = root.getContent();
	         root = root.getRight();
	      }         
          else
          {
        	  AVLTreeNode<T> parent = root;
        	  AVLTreeNode<T> current = root.getRight();
          
        	  while (current.getRight() != null)
        	  {
         
        		  parent = current;
        		  current = current.getRight();
        	  }
        	  result = current.getContent();
        	  parent.setRight(current.getLeft());
          }        
          count--;
        }
     }
            
     public void levelOrderTraversal() {
      
    	 Queue<AVLTreeNode<T>> queueTemp = new LinkedList<AVLTreeNode<T>>();
  
    	 queueTemp.offer(root);
  
    	 while(!queueTemp.isEmpty())
	     {
	        AVLTreeNode<T> node = queueTemp.poll();
	  
	        System.out.print(node.getContent() + " ");
	  
            if(node.getLeft() != null)
            {
                queueTemp.offer(node.getLeft());
            }
  
            if(node.getRight() != null)
            {
               queueTemp.offer(node.getRight());
            }
	     }
     } 
     public void inOrderTraversal() {
      
	     if( root.getLeft() != null)
	     {
	      
	       root = root.getLeft();
	       inOrderTraversal();
	       root = root.getParent();
	      
	     }
	     System.out.print(root.getContent() + " ");   
	     if( root.getRight() != null)
	     {
	      
	       root = root.getRight();
	       inOrderTraversal();
	       root = root.getParent();
	      
	    }       
    }
     
     public T getElement() {
			return (T) root;
		}
   // Print nodes of binary tree
 	public void print(AVLTreeNode<T> p, int lv) {
 		if(p == null) return;
 		print(p.getRight(), lv + 1);
 		for (int i = 0; i < lv; i++) {
 			System.out.print("\t");
 		}
 		System.out.println(p.getParent());
 		print(p.getLeft(), lv + 1);
 	}
            
    public boolean isEmpty(){      
        return (root == null);
      
    }
            
    public int size(){    
    	return count;
    }  
}
