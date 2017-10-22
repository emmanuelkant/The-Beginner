package tests;

import java.util.NoSuchElementException;
import java.util.Random;

import stack.LinkedStack;

public class StackTest {

	public static void main(String[] args) {
		
		LinkedStack stack = new LinkedStack();
		
		try {
		stack.peek();
		} catch (NoSuchElementException e){
			System.out.println("Fuck! " + e.toString());
		}
		
		Random rand = new Random();
		
		
		for (int i = 0; i < 5; i++) {
			stack.push(rand.nextInt(10));
		}
		
		System.out.println("Peek: " + stack.peek());
		
		System.out.println(stack.toString());
		
		System.out.println("Pop: " + stack.peek());
		stack.pop();
		System.out.println("Peek: " + stack.peek());
		
		
		
		
	}
	
}
