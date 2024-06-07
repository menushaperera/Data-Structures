package dataStructure;

import java.util.NoSuchElementException;

public class Steque<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    public Steque() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add an element to front
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
        size++;
    }

    // Remove an element from front
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Steque is empty.");
        }
        T item = front.item;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null; // Set rear to null if the steque becomes empty
        }
        return item;
    }

    // Add an element to end 
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Check the steque is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of 
    public int size() {
        return size;
    }

    // Display the current state
    public void display() {
        Node<T> current = front;
        System.out.print("Steque: ");
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(10);
        steque.push(21);
        steque.enqueue(35);
        steque.enqueue(24);
        steque.display();
        
        System.out.println("Popped: " + steque.pop());
        steque.display();
        
        steque.push(45);
        steque.enqueue(16);
        steque.display();
        
        System.out.println("Popped: " + steque.pop());
        steque.display();
    }
}