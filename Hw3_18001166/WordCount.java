package Hw3_18001166;

public class WordCount {
	private String word;
    private int count = 1;

    public WordCount(){
    }
    public WordCount(String word){
        this.word = word;
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }
    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word: \"" + word + "\"" + " appears " + count + " times"; 
    }

    @Override
    public boolean equals(Object other) {
        String s1 = this.word.toLowerCase();
        String s2 = ((WordCount) other).getWord().toLowerCase();
        return s1.equals(s2);
    }
}
