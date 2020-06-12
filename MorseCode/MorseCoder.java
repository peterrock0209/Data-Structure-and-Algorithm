package MorseCode;

import java.io.*;
import java.util.*;
 
public class MorseCoder implements MorseCodeInterface {
     
    private MorseNode root;
    private String code;
 
    /**
     * constructor to build the tree
     */
    public MorseCoder() {
        root = new MorseNode();
        readTreeInfo();
    }
    
    public MorseNode getLetter() {
		return root;
	}
 
    /**
     * reads the tree info from the text file
     */
    private void readTreeInfo() {
        Scanner input = null;
        try {
            input = new Scanner(new File("/C:/encoding.txt/"));
        } catch (FileNotFoundException exception) {
            System.out.println("File not found!");
        }
 
        while (input.hasNextLine()) {
            String data = input.nextLine().trim();
            if (data.length() > 0) {
                add(data.substring(1).trim(), data.charAt(0));
            }
        }
        input.close();
    }
     
    /**
     * adds the letter to the tree based on the morse code string (helper method)
     * @param morsecode - the string is added
     * @param letter - the letter being added at the node
     */
    private void add(String morsecode, char letter) {
        MorseNode current = root;
        String signal = " ";
 
        for (int i = 0; i < morsecode.length(); i++) {
            signal = morsecode.substring(i, i + 1);
            if (signal.equals(".")) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new MorseNode());
                    current = current.getLeft();
                }
            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            }
        }
        current.setLetter(letter);
    }
    

    /**
     * print tree format 
     */
    public void print(MorseNode p, int lv) {
    
		if(p == null) return;
		print(p.getRight(), lv + 1);
		for (int i = 0; i < lv; i++) {
			System.out.print("\t");
		}
		System.out.println(p.getLetter());
		print(p.getLeft(), lv + 1);
    }
 
    /**
     * print out in order tree contents 
     */
    public void inOrderPrint() {        
        MorseNode current = root;
        printInorder(current);
    }
 
    /**
     * called by inOrderPrint to print tree contents 
     * @param current node to print
     */
    private void printInorder(MorseNode current) {      
        if (current != null) {
            printInorder(current.getLeft());
            System.out.print(current.getLetter());  
            printInorder(current.getRight());
        }
    }
    
 
    /**
     * decodes a String of morse code to English
     * @param str - String of morse code
     * @return result - String of English
     */
    public String decode(String str) {
        String signal = "";
        StringBuffer result = new StringBuffer("");
        MorseNode current = root;
         
        for (int i = 0; i < str.length(); i++) {
            signal = str.substring(i, i + 1);
            if (signal.equals(".")) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new MorseNode());
                    current = current.getLeft();
                }
            }else if (signal.equals("-")) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            } else {
                result = result.append(current.getLetter());
                current = root;
            }
        }
        result = result.append(current.getLetter());
 
        return result.toString();
    }
 
    /**
     * encodes a string of English to morse code
     * @param str - string of English
     * @return code - string of morse code
     */
    public String encode(String str) {
        MorseNode current = root;
        String s = "";
        char letter;
        code = "";
        for (int i = 0; i < str.length(); i++) {
        	letter = str.charAt(i);
        	searchTree(current, letter, s);
        }
        return code;
    }   
 
    /**
     * searches the tree for the letter(s) being inputed and outputs a string of morse
     * @param current the node of the tree
     * @param letter - the letter being searched for in the tree
     * @param s - the string being used to build the morse code
     * @return the morse code corresponding to the item being checked
     */
    public void searchTree(MorseNode current, char letter, String s) {
 
        if (current.getLetter() == letter) { 
        	if(code.trim().isEmpty()) {
        		code= s;
        	}else {
        		code = code.trim()+" "+s.trim();
        	}
        	
        } else {
            if (current.getLeft() != null) {
                searchTree(current.getLeft(), letter, (s + "."));
            }
            if (current.getRight() != null ) {
                searchTree(current.getRight(), letter, (s + "-"));
            }  
        }
    }

}