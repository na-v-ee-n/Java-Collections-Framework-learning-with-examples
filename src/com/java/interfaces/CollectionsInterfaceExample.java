package com.java.interfaces;

import java.util.*;

/* KEY DEFINITIONS:
 * 
 * INTERFACE = Contract/blueprint defining WHAT methods a class must have (not HOW)
 *             Example: List interface defines add(), remove(), size() methods
 * 
 * POLYMORPHISM = Same interface reference can point to different implementations
 *                Example: List<String> can be ArrayList or LinkedList
 * 
 * LOOSE COUPLING = Code depends on interface, not specific implementation
 *                  Benefits: Easy to switch implementations without changing code
 * 
 * COLLECTIONS FRAMEWORK INTERFACES:
 * - Collection: Root interface for all collections
 * - List: Ordered collection, allows duplicates, indexed access
 * - Set: No duplicates allowed, mathematical set operations
 * - Queue: FIFO (First In, First Out) operations
 * - Map: Key-value pairs, no duplicate keys
 */

// REAL-WORLD EXAMPLE: How Collections Use Interfaces

public class CollectionsInterfaceExample {
    public static void main(String[] args) {
        System.out.println("=== COLLECTIONS INTERFACES IN ACTION ===\n");
        
        // STEP 1: Interface as Reference Type
        // POLYMORPHISM: Same interface (List), different implementations
        List<String> list1 = new ArrayList<>();  // List interface, ArrayList implementation
        List<String> list2 = new LinkedList<>(); // List interface, LinkedList implementation
        
        // Both have same interface methods
        addItems(list1);
        addItems(list2);
        
        System.out.println("ArrayList: " + list1);
        System.out.println("LinkedList: " + list2);
        
        // STEP 2: Polymorphism - Same method, different behavior
        // SET INTERFACE: No duplicates, but different ordering behavior
        Set<String> hashSet = new HashSet<>();   // No order guaranteed
        Set<String> treeSet = new TreeSet<>();   // Sorted order
        
        addToSet(hashSet, "Banana", "Apple", "Cherry", "Apple");
        addToSet(treeSet, "Banana", "Apple", "Cherry", "Apple");
        
        System.out.println("HashSet (no order): " + hashSet);
        System.out.println("TreeSet (sorted): " + treeSet);
        
        // STEP 3: Interface allows switching implementations
        demonstrateFlexibility();
        
        // STEP 4: Why interfaces matter
        System.out.println("\n=== WHY INTERFACES MATTER ===");
        explainBenefits();
    }
    
    // LOOSE COUPLING: Method accepts ANY List implementation (ArrayList, LinkedList, Vector, etc.)
    // This is the power of programming to interfaces!
    public static void addItems(List<String> list) {
        list.add("Java");
        list.add("Python");
        list.add("JavaScript");
    }
    
    // FLEXIBILITY: Method works with ANY Set implementation (HashSet, TreeSet, LinkedHashSet, etc.)
    public static void addToSet(Set<String> set, String... items) {
        for(String item : items) {
            set.add(item);
        }
    }
    
    public static void demonstrateFlexibility() {
        System.out.println("\n=== FLEXIBILITY DEMO ===");
        
        // INTERFACE REFERENCE: Can easily switch implementations at runtime
        // Same variable can hold different implementations!
        List<Integer> numbers;
        
        // IMPLEMENTATION CHOICE: For frequent access by index - use ArrayList (O(1) access)
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        System.out.println("ArrayList access: " + numbers.get(0));
        
        // IMPLEMENTATION SWITCH: For frequent insertions - switch to LinkedList (O(1) insertion)
        numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        System.out.println("LinkedList size: " + numbers.size());
        
        // INTERFACE CONTRACT: Same interface methods work with both implementations!
        // This is why interfaces are so powerful in Java Collections Framework
    }
    
    public static void explainBenefits() {
        System.out.println("1. FLEXIBILITY - Easy to switch implementations");
        System.out.println("2. POLYMORPHISM - Same method, different behavior");
        System.out.println("3. LOOSE COUPLING - Code depends on interface, not class");
        System.out.println("4. TESTABILITY - Easy to mock interfaces for testing");
        System.out.println("5. EXTENSIBILITY - Add new implementations without changing existing code");
        
        System.out.println("\nExample: Collections Framework");
        System.out.println("- List interface: ArrayList, LinkedList, Vector");
        System.out.println("- Set interface: HashSet, TreeSet, LinkedHashSet");
        System.out.println("- Map interface: HashMap, TreeMap, LinkedHashMap");
        System.out.println("- All follow same contract but different implementations!");
    }
}