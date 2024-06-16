package dataStructure;

public class LStack {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public LStack() {
        this.top = null;
    }

    //Check the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    //Add an element to the top
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed: " + data);
    }

    //Remove and return the element from top 
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int poppedData = top.data;
        top = top.next;
        System.out.println("Popped: " + poppedData);
        return poppedData;
    }

    //Return the top element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    //Display the elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        LStack stack = new LStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        stack.pop();
        stack.display();

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop(); 
        
        stack.display();
    }
}

