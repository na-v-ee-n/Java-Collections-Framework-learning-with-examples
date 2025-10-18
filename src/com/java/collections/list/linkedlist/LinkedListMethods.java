package com.java.collections.list.linkedlist;

import java.util.LinkedList;

/**
 * LinkedList Methods - Core functionality
 */
public class LinkedListMethods {
    public static void main(String[] args) {
        System.out.println("=== LINKEDLIST METHODS ===\n");
        
        LinkedList<Integer> numbers = new LinkedList<>();
        
        // Adding methods
        numbers.add(10);
        numbers.add(20);
        numbers.add(1, 15); // Insert at index
        numbers.addFirst(5);
        numbers.addLast(25);
        
        System.out.println("After adding: " + numbers);
        
        // Access methods
        System.out.println("Element at index 2: " + numbers.get(2));
        System.out.println("First element: " + numbers.peekFirst());
        System.out.println("Last element: " + numbers.peekLast());
        
        // Search methods
        System.out.println("Contains 15: " + numbers.contains(15));
        System.out.println("Index of 20: " + numbers.indexOf(20));
        
        // Modification methods
        numbers.set(1, 12); // Replace element at index
        System.out.println("After set: " + numbers);
        
        // Queue operations
        numbers.offer(30); // Add to end
        Integer polled = numbers.poll(); // Remove from front
        System.out.println("Polled: " + polled + ", List: " + numbers);
        
        // Stack operations
        numbers.push(1); // Add to front
        Integer popped = numbers.pop(); // Remove from front
        System.out.println("Popped: " + popped + ", List: " + numbers);
        
        System.out.println("Final size: " + numbers.size());
    }
}