package dataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackArrayDeque {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        push(stack, 5);
        push(stack, 20);
        push(stack, 38);
        display(stack);

        pop(stack);
        display(stack);

        push(stack, 25);
        display(stack);

        pop(stack);
        display(stack);

        
    }

    //push elements on stack
    public static void push(Deque<Integer> stack, int item) {
        stack.addLast(item);
        System.out.println("Push:" + item );
    }

    //pop elements from stack
    public static int pop(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int item = stack.removeLast();
            System.out.println("Popped:" + item );
            return item;
        }
    }

    //display the current state
    public static void display(Deque<Integer> stack) {
        System.out.println("Current stack: " + stack);
    }
}