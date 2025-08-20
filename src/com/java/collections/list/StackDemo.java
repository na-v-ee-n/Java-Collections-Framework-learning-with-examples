package com.java.collections.list;

import java.util.*;

/**
 * Stack - LIFO (Last In First Out) data structure
 * - Extends Vector class
 * - Thread-safe but legacy
 * - Prefer Deque implementations for stack operations
 */
public class StackDemo {
    public static void main(String[] args) {
        System.out.println("=== STACK DEMO ===\n");
        
        // Creation
        Stack<String> books = new Stack<>();
        
        // Push operations (add to top)
        books.push("Java Basics");
        books.push("Data Structures");
        books.push("Algorithms");
        books.push("Design Patterns");
        System.out.println("After pushing: " + books);
        
        // Peek operation (view top without removing)
        System.out.println("Top book (peek): " + books.peek());
        System.out.println("Stack after peek: " + books);
        
        // Pop operations (remove from top)
        String removed1 = books.pop();
        String removed2 = books.pop();
        System.out.println("Popped: " + removed1 + ", " + removed2);
        System.out.println("Stack after popping: " + books);
        
        // Search operation (1-based index from top)
        System.out.println("Position of 'Java Basics': " + books.search("Java Basics"));
        System.out.println("Position of 'Data Structures': " + books.search("Data Structures"));
        
        // Check if empty
        System.out.println("Is empty: " + books.empty());
        
        // Modern alternative using Deque
        System.out.println("\n--- Modern Alternative (Deque) ---");
        Deque<String> modernStack = new ArrayDeque<>();
        
        modernStack.push("Item 1");
        modernStack.push("Item 2");
        modernStack.push("Item 3");
        System.out.println("Deque as stack: " + modernStack);
        
        System.out.println("Peek: " + modernStack.peek());
        System.out.println("Pop: " + modernStack.pop());
        System.out.println("After pop: " + modernStack);
        
        // Performance characteristics
        System.out.println("\n--- Performance Notes ---");
        System.out.println("• LIFO operations: push(), pop(), peek()");
        System.out.println("• Thread-safe (extends Vector)");
        System.out.println("• Legacy class - prefer ArrayDeque for stack operations");
        System.out.println("• All operations O(1) except search O(n)");
    }
}