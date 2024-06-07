package dataStructure;

import java.util.Scanner;

public class CircularQueue {
	 private int[] queue;
	    private int front; 
	    private int rear;  
	    private int size;  
	    private int capacity; 

	    
	    public CircularQueue(int capacity) {
	        this.capacity = capacity;
	        queue = new int[capacity];
	        front = 0;
	        rear = -1;
	        size = 0;
	    }

	    //Check the queue is empty
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    //Check the queue is full
	    public boolean isFull() {
	        return size == capacity;
	    }

	    //Enqueue an element in queue
	    public void enqueue(int item) {
	        if (isFull()) {
	            System.out.println("Queue is full. Cannot enqueue.");
	            return;
	        }
	        rear = (rear + 1) % capacity;
	        queue[rear] = item;
	        size++;
	    }

	    //Dequeue an element in queue
	    public int dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty. Cannot dequeue.");
	            return -1;
	        }
	        int item = queue[front];
	        front = (front + 1) % capacity;
	        size--;
	        return item;
	    }

	    //Get the front element of the queue
	    public int peek() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty. No front element.");
	            return -1;
	        }
	        return queue[front];
	    }

	    //Size of the queue
	    public int size() {
	        return size;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);

	        System.out.print("Enter the capacity of the queue: ");
	        int capacity = in.nextInt();
	        CircularQueue queue = new CircularQueue(capacity);

	        while (true) {
	            System.out.println("1. Enqueue");
	            System.out.println("2. Dequeue");
	            System.out.println("3. Peek");
	            System.out.println("4. Size");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = in.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enqueue an element: ");
	                    int item = in.nextInt();
	                    queue.enqueue(item);
	                    break;
	                case 2:
	                    int dequeued = queue.dequeue();
	                    if (dequeued != -1)
	                        System.out.println("Dequeued element: " + dequeued);
	                    break;
	                case 3:
	                    int frontElement = queue.peek();
	                    if (frontElement != -1)
	                        System.out.println("Front element: " + frontElement);
	                    break;
	                case 4:
	                    System.out.println("Size of the queue: " + queue.size());
	                    break;
	                case 5:
	                    in.close();
	                    System.out.println("Program will be terminated..");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid option.");
	            }
	        }
	    }

}
