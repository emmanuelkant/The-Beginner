package fifoStack;

public class QueueTest {

	public static void main(String[] args) {

		LinkedQueue linkedQueue = new LinkedQueue();
		linkedQueue.enqueue(50);
		linkedQueue.enqueue(15);

		System.out.println(linkedQueue.toString());

		System.out.println("Peek: " + linkedQueue.peek());

		System.out.println(linkedQueue.toString());

		System.out.println("Dequeue: " + linkedQueue.dequeue());

		System.out.println(linkedQueue.toString());

		System.out.println("Dequeue: " + linkedQueue.dequeue());

		
		System.out.println("Peek: " + linkedQueue.peek());

	}

}
