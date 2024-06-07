package dataStructure;

public class FIFOArray {
	 private int[] queue;
	    private int front;
	    private int rear;
	    private int size;
	    private int capacity;

	    public FIFOArray(int capacity) {
	        this.capacity = capacity;
	        queue = new int[capacity];
	        front = 0;
	        rear = -1;
	        size = 0;
	    }

	    // Add an element
	    public void enqueue(int item) {
	        if (isFull()) {
	            System.out.println("Queue is full.");
	            return;
	        }
	        rear = (rear + 1) % capacity;
	        queue[rear] = item;
	        size++;
	    }

	    // Remove an element
	    public int dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty.");
	            return -1;
	        }
	        int item = queue[front];
	        front = (front + 1) % capacity;
	        size--;
	        return item;
	    }

	    // Check the queue is empty
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    // Check the queue is full
	    public boolean isFull() {
	        return size == capacity;
	    }

	    // Display the current state
	    public void display() {
	        System.out.print("Queue: ");
	        for (int i = 0; i < size; i++) {
	            System.out.print(queue[(front + i) % capacity] + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        FIFOArray queue = new FIFOArray(5);
	        queue.enqueue(10);
	        queue.enqueue(21);
	        queue.enqueue(15);
	        queue.display();
	        
	        queue.dequeue();
	        queue.display();
	        
	        queue.enqueue(14);
	        queue.display();
	        
	        queue.dequeue();
	        queue.display();
	        
	        queue.enqueue(19);
	        queue.enqueue(24);
	        queue.display();
	    }
}
