package dataStructure;

public class LQueue {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public LQueue() {
        this.front = null;
        this.rear = null;
    }

    //Check the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Add an element to rear
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;
    }

    //Remove and return the element from front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        Node dequeuedNode = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }

        return dequeuedNode.data;
    }

    //Return the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return this.front.data;
    }

    //Display the elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = this.front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

   
    public static void main(String[] args) {
        LQueue q = new LQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        System.out.println("Front element is: " + q.peek());

        q.dequeue();
        q.dequeue();
        q.dequeue();  

        q.display();
    }
}
