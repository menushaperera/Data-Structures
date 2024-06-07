package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DequeUsingTwoFIFO {
    private Queue<Integer> frontQueue;
    private Queue<Integer> backQueue;

    public DequeUsingTwoFIFO() {
        frontQueue = new LinkedList<>();
        backQueue = new LinkedList<>();
    }

    // Add an element to front
    public void addFront(int item) {
        frontQueue.offer(item);
    }

    // Add an element to back
    public void addBack(int item) {
        backQueue.offer(item);
    }

    // Remove an element from front
    public int removeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove element.");
            return -1;
        }
        if (!frontQueue.isEmpty()) {
            return frontQueue.poll();
        } else {
            transferElements(backQueue, frontQueue);
            return frontQueue.poll();
        }
    }

    // Remove an element from back 
    public int removeBack() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove element.");
            return -1;
        }
        if (!backQueue.isEmpty()) {
            return backQueue.poll();
        } else {
            transferElements(frontQueue, backQueue);
            return backQueue.poll();
        }
    }

    // Check the deque is empty
    public boolean isEmpty() {
        return frontQueue.isEmpty() && backQueue.isEmpty();
    }

    // Transfer all elements from sourceQueue to destinationQueue
    private void transferElements(Queue<Integer> sourceQueue, Queue<Integer> destinationQueue) {
        while (!sourceQueue.isEmpty()) {
            destinationQueue.offer(sourceQueue.poll());
        }
    }

    // Display the current state of the deque
    public void display() {
        System.out.print("Deque: ");
        for (int item : frontQueue) {
            System.out.print(item + " ");
        }
        for (int item : backQueue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DequeUsingTwoFIFO deque = new DequeUsingTwoFIFO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add to Front");
            System.out.println("2. Add to Rear");
            System.out.println("3. Remove from Front");
            System.out.println("4. Remove from Rear");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add to the front: ");
                    int itemFront = scanner.nextInt();
                    deque.addFront(itemFront);
                    deque.display();
                    break;
                case 2:
                    System.out.print("Enter the element to add to the rear: ");
                    int itemBack = scanner.nextInt();
                    deque.addBack(itemBack);
                    deque.display();
                    break;
                case 3:
                    int removedFront = deque.removeFront();
                    if (removedFront != -1)
                        System.out.println("Removed from front: " + removedFront);
                    deque.display();
                    break;
                case 4:
                    int removedBack = deque.removeBack();
                    if (removedBack != -1)
                        System.out.println("Removed from rear: " + removedBack);
                    deque.display();
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Program will be terminated.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}