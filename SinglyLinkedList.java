package dataStructure;

import java.util.Scanner;

public class SinglyLinkedList {
    //Inner Node class.
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    //Insert a new node at the beginning.
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Insert a new node at the end.
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    //Insert a new node in the middle.
    public void insertAtMiddle(int data, int position) {
        if (position <= 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            insertAtEnd(data);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    //Delete a node from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    //Delete a node from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    //Delete a node from the middle
    public void deleteFromMiddle(int position) {
        if (head == null || position <= 1) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null && current.next != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            deleteFromEnd();
        } else {
            current.next = current.next.next;
        }
    }

    //Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at middle");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from middle");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the beginning data: ");
                    int beginData = scanner.nextInt();
                    linkedList.insertAtBeginning(beginData);
                    linkedList.display();
                    break;
                case 2:
                    System.out.print("Enter the end data: ");
                    int endData = scanner.nextInt();
                    linkedList.insertAtEnd(endData);
                    linkedList.display();
                    break;
                case 3:
                    System.out.print("Enter the middle data: ");
                    int midData = scanner.nextInt();
                    System.out.print("Enter the insert position: ");
                    int position = scanner.nextInt();
                    linkedList.insertAtMiddle(midData, position);
                    linkedList.display();
                    break;
                case 4:
                    linkedList.deleteFromBeginning();
                    linkedList.display();
                    break;
                case 5:
                    linkedList.deleteFromEnd();
                    linkedList.display();
                    break;
                case 6:
                    System.out.print("Enter position to delete from: ");
                    int delPosition = scanner.nextInt();
                    linkedList.deleteFromMiddle(delPosition);
                    linkedList.display();
                    break;
                case 7:
                    System.out.println("Program will be terminated..");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
