package Hw3_18001166;

public class TestSimpleArrayList {
	public static void main(String[ ] args) {
		  SimpleArrayList<String> animals = new SimpleArrayList<String>();
		  animals.add("fox");
		  animals.add("cat");
		  animals.add("dog");
		  animals.add("rabbit");
		  animals.add("dog");
		  animals.add("dog");
	      animals.print(animals);
	      System.out.println();
	      
		  animals.remove("dog");
		  System.out.println("ArrayList after remove ");
	      animals.print(animals);
	      animals.set(2, "shark");
	      animals.print(animals);

	}
}
