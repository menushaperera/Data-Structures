package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class FIFOArrayList {
    private List<Integer> queue;

    public FIFOArrayList() {
        queue = new ArrayList<>();
    }

    // Add an element 
    public void enqueue(int item) {
        queue.add(item);
    }

    // Remove an element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue.remove(0);
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
        FIFOArrayList queue = new FIFOArrayList();
        queue.enqueue(21);
        queue.enqueue(15);
        queue.enqueue(13);
        queue.display();
        
        queue.dequeue();
        queue.display();
        
        queue.enqueue(9);
        queue.display();
        
        queue.dequeue();
        queue.display();
        
        queue.enqueue(24);
        queue.display();
    }
}