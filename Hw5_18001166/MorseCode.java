package Hw5_18001166;

import java.io.*;
import java.util.*;

public class MorseCode extends BinaryTree{
     static BufferedReader in;
     static BinaryTree<String> bT = new BinaryTree<String>();
     
/*     public static void loadTree() throws FileNotFoundException, IOException{
          in = new BufferedReader(new FileReader("MorseCode.txt"));
          bT = readBinaryTree(in);
     }*/
     public static String decode(Character c) throws IOException{
          if(c.equals("null")){
               return "";
          }else if(c.equals(" ")){
               return " ";
          }else{
               return (":" + find(c));
          }               
     }

     public static String find(Character c) throws IOException, FileNotFoundException{
          in = new BufferedReader(new FileReader("/C:/encoding.txt/"));
          bT = readBinaryTree(in);
          Queue<BinaryTree> data = new LinkedList<BinaryTree>();
          BinaryTree<String> tempTree = bT;
          String temp = null;
          Character tempChar = null;
          data.offer(tempTree);
          while(!data.isEmpty()){
               tempTree = data.poll();
               temp = tempTree.getData();
               tempChar = temp.charAt(0);
               if(tempChar.equals(c)){
                    break;
               }
               data.offer(tempTree.getRightSubtree());
               data.offer(tempTree.getLeftSubtree());
          }
          return temp.substring(2);               
     }
     public static void main(String[] args) throws FileNotFoundException, IOException{
          Scanner scan = new Scanner(new FileReader("/C:/encoding.txt/"));
          String s = "";
          String temp = "";
          while(scan.hasNextLine()){
                temp = scan.nextLine();
                for(int i = 0; i < temp.length(); i++){
                     s = s + decode(temp.charAt(i));
                }
          }
          System.out.println(s);
     }
}

/** Class for a binary tree that stores type E objects.
*   @author Koffman and Wolfgang
* */

class BinaryTree <E> implements Serializable 
{
  //===================================================
  /** Class to encapsulate a tree node. */
  protected static class Node <E> implements Serializable 
  {
    // Data Fields
    /** The information stored in this node. */
    protected E data;

    /** Reference to the left child. */
    protected Node <E> left;

    /** Reference to the right child. */
    protected Node <E> right;

    // Constructors
    /** Construct a node with given data and no children.
        @param data The data to store in this node
     */
    public Node(E data) {
      this.data = data;
      left = null;
      right = null;
    }

    // Methods
    /** Return a string representation of the node.
        @return A string representation of the data fields
     */
    public String toString() {
      return data.toString();
    }
  }//end inner class Node
  //===================================================

  // Data Field
  /** The root of the binary tree */
  protected Node <E> root;

  public BinaryTree() 
  {
    root = null;
  }

  protected BinaryTree(Node <E> root) 
  {
    this.root = root;
  }

  /** Constructs a new binary tree with data in its root,leftTree
      as its left subtree and rightTree as its right subtree.
   */
  public BinaryTree(E data, BinaryTree <E> leftTree, BinaryTree <E> rightTree) 
  {
    root = new Node <E> (data);
    if (leftTree != null) {
      root.left = leftTree.root;
    }
    else {
      root.left = null;
    }
    if (rightTree != null) {
      root.right = rightTree.root;
    }
    else {
      root.right = null;
    }
  }

  /** Return the left subtree.
      @return The left subtree or null if either the root or
      the left subtree is null
   */
  public BinaryTree <E> getLeftSubtree() {
    if (root != null && root.left != null) {
      return new BinaryTree <E> (root.left);
    }
    else {
      return null;
    }
  }

  /** Return the right sub-tree
        @return the right sub-tree or
        null if either the root or the
        right subtree is null.
    */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }


     public String getData(){
          if(root.data == null){
               return "null";
          }else{
               return (String) root.data;
          }
     }

  /** Determine whether this tree is a leaf.
      @return true if the root has no children
   */
  public boolean isLeaf() {
    return (root.left == null && root.right == null);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrderTraverse(root, 1, sb);
    return sb.toString();
  }

  /** Perform a preorder traversal.
      @param node The local root
      @param depth The depth
      @param sb The string buffer to save the output
   */
  private void preOrderTraverse(Node <E> node, int depth,
                                StringBuilder sb) {
    for (int i = 1; i < depth; i++) {
      sb.append("  ");
    }
    if (node == null) {
      sb.append("null\n");
    }
    else {
      sb.append(node.toString());
      sb.append("\n");
      preOrderTraverse(node.left, depth + 1, sb);
      preOrderTraverse(node.right, depth + 1, sb);
    }
  }

  /** Method to read a binary tree.
      pre: The input consists of a preorder traversal
           of the binary tree. The line "null" indicates a null tree.
      @param bR The input file
      @return The binary tree
      @throws IOException If there is an input error
   */
  public static BinaryTree<String> readBinaryTree(BufferedReader bR) throws IOException 
  {
    // Read a line and trim leading and trailing spaces.
    String data = bR.readLine().trim();
    if (data.equals("null")) {
      return null;
    }
    else {
      BinaryTree < String > leftTree = readBinaryTree(bR);
      BinaryTree < String > rightTree = readBinaryTree(bR);
      return new BinaryTree < String > (data, leftTree, rightTree);
    }
  }//readBinaryTree()
  
  /*Method to determine the height of a binary tree
    pre: The line "null" indicates a null tree.
      @param T The binary tree
      @return The height as integer
     */
  public static int height(BinaryTree T){
        if(T == null){
           return 0;
      }else{
           return 1 +(int) (Math.max(height(T.getRightSubtree()), height(T.getLeftSubtree())));
      }
  }
  public static String preOrderTraversal(BinaryTree<String> T){
      String s = T.toString();
      String s2 = "";
      String temp = "";
      Scanner scan = new Scanner(s);
      while(scan.hasNextLine()){
           temp = scan.nextLine().trim();
           if(temp.equals("null")){
               s2 = s2;
          }else{
               s2 = s2 + " " + temp;
          }
      }
      return s2;
  }
     
}
