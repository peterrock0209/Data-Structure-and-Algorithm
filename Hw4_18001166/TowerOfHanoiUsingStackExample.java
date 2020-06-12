package Hw4_18001166;

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoiUsingStackExample extends TowerOfHanoiUsingStack{
	public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();
        
        /* Accepting number of disks */         
        System.out.println("Enter number of disks");
        int num = scan.nextInt();
        N = num;
        play(num);
    }
}
