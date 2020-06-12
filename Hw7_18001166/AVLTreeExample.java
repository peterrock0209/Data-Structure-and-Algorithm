package Hw7_18001166;

public class AVLTreeExample {

   public static void main(String[] args) {    
        AVLTree<Integer> avlTree = new AVLTree<Integer>();                 
        avlTree.add(40);
        avlTree.add(4);
        avlTree.add(66);
        avlTree.add(81);
        avlTree.add(20);
        avlTree.add(13);
        avlTree.add(14);
        avlTree.add(56);
        avlTree.add(90);
        
        System.out.println("Tree ");
        avlTree.inOrderTraversal();  
        System.out.println();
        
        System.out.println("AVL Tree");
        avlTree.levelOrderTraversal();
        System.out.println();
          
        avlTree.removeMax();  
        System.out.println("AVL Tree after remove ");
        avlTree.levelOrderTraversal();                 
    }
   
}
