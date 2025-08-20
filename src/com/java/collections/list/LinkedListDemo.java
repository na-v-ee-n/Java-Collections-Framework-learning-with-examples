package com.java.collections.list;

import java.util.*;

/**
 * LinkedList - Doubly-linked list implementation
 * - Implements both List and Deque interfaces
 * - Fast insertion/deletion at both ends
 * - Not synchronized (not thread-safe)
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        System.out.println("=== LINKEDLIST DEMO ===\n");
        
        // Creation
        LinkedList<String> cities = new LinkedList<>();
        
        // Adding elements (List operations)
        cities.add("New York");
        cities.add("London");
        cities.add("Tokyo");
        System.out.println("After adding: " + cities);
        
        // Deque operations (both ends)
        cities.addFirst("Paris");
        cities.addLast("Sydney");
        System.out.println("After adding first/last: " + cities);
        
        // Access operations
        System.out.println("First element: " + cities.getFirst());
        System.out.println("Last element: " + cities.getLast());
        System.out.println("Element at index 2: " + cities.get(2));
        
        // Removal operations
        cities.removeFirst();
        cities.removeLast();
        System.out.println("After removing first/last: " + cities);
        
        // Queue operations (FIFO)
        cities.offer("Mumbai"); // Add to end
        cities.offer("Berlin");
        System.out.println("After offering: " + cities);
        
        String polled = cities.poll(); // Remove from front
        System.out.println("Polled: " + polled);
        System.out.println("After polling: " + cities);
        
        // Stack operations (LIFO)
        cities.push("Cairo"); // Add to front
        cities.push("Rome");
        System.out.println("After pushing: " + cities);
        
        String popped = cities.pop(); // Remove from front
        System.out.println("Popped: " + popped);
        System.out.println("After popping: " + cities);
        
        // Performance characteristics
        System.out.println("\n--- Performance Notes ---");
        System.out.println("• Fast insertion/deletion at ends O(1)");
        System.out.println("• Random access O(n)");
        System.out.println("• Good for frequent insertions/deletions");
        System.out.println("• Implements both List and Deque");
    }
}