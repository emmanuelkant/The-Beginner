package tests;

import java.util.NoSuchElementException;
import java.util.Random;

import fifoStack.FifoStack;

public class FifoStackTest {

	public static void main(String[] args) {
		
		FifoStack stack = new FifoStack();
		try {
			System.out.println(stack.peek().getContent());
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		Random random = new Random();
		
		for (int i = 0; i < 6; i++) {
			stack.enQueue(random.nextInt(10));
		}
		System.out.println(stack.toString());
		stack.deQueue();
		System.out.println(stack.toString());
		stack.deQueue();
		System.out.println(stack.toString());
		stack.deQueue();
		System.out.println(stack.toString());
		stack.deQueue();
		System.out.println(stack.toString());
		stack.deQueue();
		System.out.println(stack.toString());
		stack.deQueue();
		System.out.println(stack.toString() + "-");
		
		System.out.println(stack.toString());
		stack.deQueue();
		System.out.println(stack.toString());
		
		
	}

}
