package dataStructure;

public class StackLinkedList {

    //Node class to represent each elements
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    //Constructor to initialize the stack
    public StackLinkedList() {
        this.top = null;
    }

    //push an element on stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Push:" + data);
    }

    //pop an element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int poppedData = top.data;
            top = top.next;
            System.out.println("Popped:" + poppedData);
            return poppedData;
        }
    }

    //check the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    //display the current state
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            Node current = top;
            System.out.print("Current stack: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(15);
        stack.push(21);
        stack.push(26);
        stack.display();

        stack.pop();
        stack.display();

        stack.push(34);
        stack.display();

        stack.pop();
        stack.display();
        
        stack.push(48);
        stack.display();

        
    }
}