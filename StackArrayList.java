package dataStructure;

import java.util.ArrayList;

public class StackArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>();

        push(stack, 12);
        push(stack, 20);
        display(stack);

        pop(stack);
        display(stack);

        push(stack, 45);
        display(stack);

        pop(stack);
        display(stack);
        
        push(stack, 34);
        display(stack);
    }

    //push elements on stack
    public static void push(ArrayList<Integer> stack, int item) {
        stack.add(item);
        System.out.println("Pushed:" + item);
    }

    //pop elements from stack
    public static int pop(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int item = stack.remove(stack.size() - 1);
            System.out.println("Popped:" + item);
            return item;
        }
    }

    //display the current state
    public static void display(ArrayList<Integer> stack) {
        System.out.println("Current stack: " + stack);
    }
}