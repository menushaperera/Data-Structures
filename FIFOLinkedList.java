package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOLinkedList {
    private Queue<Integer> queue;

    public FIFOLinkedList() {
        queue = new LinkedList<>();
    }

    // Add an element
    public void enqueue(int item) {
        queue.offer(item);
    }

    // Remove an element 
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue.poll();
    }

    // Check the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Display the current state 
    public void display() {
        System.out.println("Queue: " + queue);
    }

    public static void main(String[] args) {
        FIFOLinkedList queue = new FIFOLinkedList();
        queue.enqueue(17);
        queue.enqueue(21);
        queue.enqueue(13);
        queue.display();
        
        queue.dequeue();
        queue.display();
        
        queue.enqueue(32);
        queue.display();
        
        queue.dequeue();
        queue.display();
    }
}