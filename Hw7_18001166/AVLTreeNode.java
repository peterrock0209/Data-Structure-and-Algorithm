package Hw7_18001166;

import java.util.*;

public class AVLTreeNode<T> {
 
    private T content;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;
    private AVLTreeNode<T> parent;
    private int balanceFactor;
 
    public AVLTreeNode() {
        content = null;
        left = null;
        right = null;
        parent = null;
        balanceFactor = 0;
    }
 
    public AVLTreeNode(T data) {
        content = data;
        left = null;
        right = null;
        parent = null;
        balanceFactor = 0;
    }
 
    public T getContent() {
        return content;
    }
 
    public void setContent(T content) {
        this.content = content;
    }
 
    public AVLTreeNode<T> getLeft() {
        return left;
    }
 
    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }
 
    public AVLTreeNode<T> getRight() {
        return right;
    }
 
    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }
      
     public AVLTreeNode<T> getParent() {
          return parent;
     }
      
     public void setParent(AVLTreeNode<T> parent) {
          this.parent = parent;
     }
      
     public int getBalanceFactor() {
          return balanceFactor;
     }
 
     public void setBalanceFactor(int balanceFactor) {
          this.balanceFactor = balanceFactor;
     }
      
}
