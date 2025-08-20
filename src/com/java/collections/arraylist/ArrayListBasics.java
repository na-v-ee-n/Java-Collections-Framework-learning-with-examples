package com.java.collections.arraylist;

import java.util.*;

/* ARRAYLIST DEFINITION:
 * 
 * ARRAYLIST = Resizable array implementation of List interface
 * - Dynamic size (grows/shrinks automatically)
 * - Allows duplicates and null values
 * - Maintains insertion order
 * - Indexed access (0-based)
 * - NOT synchronized (not thread-safe)
 * 
 * WHEN TO USE:
 * - Frequent random access by index
 * - More reads than insertions/deletions
 * - Need to maintain insertion order
 * 
 * WHEN NOT TO USE:
 * - Frequent insertions/deletions in middle
 * - Thread-safe operations needed
 * - Memory is very limited
 */

public class ArrayListBasics {
    
    public static void main(String[] args) {
        System.out.println("=== ARRAYLIST BASICS ===\n");
        
        // CREATION
        demonstrateCreation();
        
        // BASIC OPERATIONS
        demonstrateBasicOperations();
        
        // CAPACITY AND SIZE
        demonstrateCapacity();
    }
    
    public static void demonstrateCreation() {
        System.out.println("1. ARRAYLIST CREATION:");
        
        // Default constructor - initial capacity 10
        ArrayList<String> list1 = new ArrayList<>();
        
        // With initial capacity
        ArrayList<String> list2 = new ArrayList<>(20);
        
        // From another collection
        List<String> sourceList = Arrays.asList("A", "B", "C");
        ArrayList<String> list3 = new ArrayList<>(sourceList);
        
        // Using List interface reference (recommended)
        List<String> list4 = new ArrayList<>();
        
        System.out.println("Empty list: " + list1);
        System.out.println("From collection: " + list3);
        System.out.println();
    }
    
    public static void demonstrateBasicOperations() {
        System.out.println("2. BASIC OPERATIONS:");
        
        List<String> fruits = new ArrayList<>();
        
        // ADD operations
        fruits.add("Apple");           // Add at end
        fruits.add("Banana");
        fruits.add(1, "Orange");       // Add at specific index
        fruits.addAll(Arrays.asList("Mango", "Grapes"));  // Add collection
        
        System.out.println("After adding: " + fruits);
        
        // GET operations
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Last fruit: " + fruits.get(fruits.size() - 1));
        
        // SET operations (replace)
        fruits.set(1, "Pineapple");    // Replace at index 1
        System.out.println("After replacing: " + fruits);
        
        // REMOVE operations
        fruits.remove("Mango");        // Remove by value
        fruits.remove(0);              // Remove by index
        System.out.println("After removing: " + fruits);
        
        // SEARCH operations
        System.out.println("Contains Banana: " + fruits.contains("Banana"));
        System.out.println("Index of Grapes: " + fruits.indexOf("Grapes"));
        
        System.out.println();
    }
    
    public static void demonstrateCapacity() {
        System.out.println("3. CAPACITY vs SIZE:");
        
        ArrayList<Integer> numbers = new ArrayList<>(5);  // Initial capacity 5
        
        System.out.println("Initial size: " + numbers.size());
        
        // Add elements
        for(int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        
        System.out.println("Size after adding 10 elements: " + numbers.size());
        System.out.println("ArrayList automatically resized!");
        
        // Trim to actual size
        numbers.trimToSize();
        System.out.println("After trimToSize() - capacity = size");
        
        System.out.println();
    }
}