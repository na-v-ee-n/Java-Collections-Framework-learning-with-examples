package com.java.collections.list;

import java.util.*;

/**
 * Vector - Synchronized resizable array
 * - Similar to ArrayList but synchronized
 * - Thread-safe but slower performance
 * - Legacy class from Java 1.0
 */
public class VectorDemo {
    public static void main(String[] args) {
        System.out.println("=== VECTOR DEMO ===\n");
        
        // Creation
        Vector<Integer> numbers = new Vector<>();
        
        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.addElement(40); // Vector-specific method
        System.out.println("After adding: " + numbers);
        
        // Capacity operations
        System.out.println("Size: " + numbers.size());
        System.out.println("Capacity: " + numbers.capacity());
        
        // Access operations
        System.out.println("Element at index 1: " + numbers.get(1));
        System.out.println("Element at index 2: " + numbers.elementAt(2)); // Vector-specific
        
        // Modification
        numbers.set(0, 15);
        numbers.setElementAt(25, 1); // Vector-specific
        System.out.println("After modifications: " + numbers);
        
        // Removal
        numbers.remove(Integer.valueOf(30));
        numbers.removeElementAt(1); // Vector-specific
        System.out.println("After removals: " + numbers);
        
        // Search operations
        numbers.add(50);
        numbers.add(60);
        System.out.println("Final vector: " + numbers);
        System.out.println("Index of 50: " + numbers.indexOf(50));
        System.out.println("Contains 40: " + numbers.contains(40));
        
        // Enumeration (legacy way)
        System.out.print("Using Enumeration: ");
        Enumeration<Integer> e = numbers.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }
        System.out.println();
        
        // Performance characteristics
        System.out.println("\n--- Performance Notes ---");
        System.out.println("• Thread-safe (synchronized methods)");
        System.out.println("• Slower than ArrayList due to synchronization");
        System.out.println("• Legacy class - prefer ArrayList + Collections.synchronizedList()");
        System.out.println("• Default capacity grows by 100% (doubles)");
    }
}