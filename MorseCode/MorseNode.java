package MorseCode;

/**
 * Node class to use with morse code tree.
 * 
 */
public class MorseNode {
 
    /** a letter of the alphabet */ 
    private char letter;
    /** reference to the left child */
    private MorseNode left;
    /** reference to the right child */
    private MorseNode right;
    /** value of letter if empty (not set) */
    public static final char EMPTY = ' ';
 
    /**
     * Default constructor
     */
    public MorseNode() {
        letter = EMPTY;
        left = null;
        right = null;
    }
 
    /**
     * @return String - letter value
     */
    public char getLetter() {
        return letter;
    }
 
    /**
     * Sets letter in node
     * @param String - letter to set
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }
 
    /**
     * Gets the node referenced by left
     * @return MorseNode - left
     */
    public MorseNode getLeft() {
        return left;
    }
 
    /**
     * Sets left referenced
     * @param left - referenced to the node to set
     */
    public void setLeft(MorseNode left) {
        this.left = left;
    }
 
    /**
     * Gets the node referenced by right
     * @return MorseNode - right
     */
    public MorseNode getRight() {
        return right;
    }
 
    /**
     * Sets right referenced
     * @param right - referenced to the node to set
     */
    public void setRight(MorseNode right) {
        this.right = right;
    }
 
}