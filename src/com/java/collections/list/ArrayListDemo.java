package com.java.collections.list;

import java.util.*;

/**
 * ArrayList - Resizable array implementation
 * - Dynamic size, fast random access
 * - Not synchronized (not thread-safe)
 * - Allows duplicates and null values
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        System.out.println("=== ARRAYLIST DEMO ===\n");
        
        // Creation
        List<String> fruits = new ArrayList<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicates allowed
        System.out.println("After adding: " + fruits);
        
        // Index-based operations
        fruits.add(1, "Mango"); // Insert at index 1
        System.out.println("After insert at index 1: " + fruits);
        System.out.println("Element at index 2: " + fruits.get(2));
        
        // Modification
        fruits.set(0, "Grapes"); // Replace element at index 0
        System.out.println("After replacing index 0: " + fruits);
        
        // Removal
        fruits.remove("Banana");
        fruits.remove(1); // Remove by index
        System.out.println("After removals: " + fruits);
        
        // Size and contains
        System.out.println("Size: " + fruits.size());
        System.out.println("Contains Apple: " + fruits.contains("Apple"));
        
        // Iteration
        System.out.print("Iteration: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // Performance characteristics
        System.out.println("\n--- Performance Notes ---");
        System.out.println("• Fast random access O(1)");
        System.out.println("• Insertion/deletion at end O(1)");
        System.out.println("• Insertion/deletion in middle O(n)");
        System.out.println("• Not thread-safe");
    }
}