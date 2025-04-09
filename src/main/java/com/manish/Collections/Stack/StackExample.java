package com.manish.Collections.Stack;

import java.util.Stack;

public class StackExample {
    public StackExample() {
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Stack: " + String.valueOf(stack));
        System.out.println("Top element is: " + String.valueOf(stack.peek()));
        System.out.println("Popped element: " + String.valueOf(stack.pop()));
        System.out.println("Popped element: " + String.valueOf(stack.pop()));
        System.out.println("Stack after popping elements: " + String.valueOf(stack));
        if (stack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The stack is not empty.");
        }

        int position = stack.search(10);
        if (position != -1) {
            System.out.println("Element 10 found at position: " + position);
        } else {
            System.out.println("Element 10 not found in the stack.");
        }

    }
}
