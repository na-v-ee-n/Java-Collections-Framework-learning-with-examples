package com.java.collections;

import java.util.*;

public class CollectionsHierarchy {
    public static void main(String[] args) {
        
        System.out.println("=== COLLECTIONS FRAMEWORK HIERARCHY ===\n");
        
        // LIST HIERARCHY
        System.out.println("1. LIST HIERARCHY:");
        System.out.println("   List (Interface) - Ordered, allows duplicates, indexed access");
        
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Apple"); // Duplicates allowed
        
        System.out.println("   ArrayList: " + arrayList);
        System.out.println("   Size: " + arrayList.size() + ", Get index 0: " + arrayList.get(0));
        
        // QUEUE HIERARCHY  
        System.out.println("\n2. QUEUE HIERARCHY:");
        System.out.println("   Queue (Interface) - FIFO operations");
        System.out.println("   Deque (Interface) - Double-ended queue");
        
        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new ArrayDeque<>();
        
        queue.offer("First");
        queue.offer("Second");
        System.out.println("   Queue: " + queue);
        System.out.println("   Poll: " + queue.poll()); // Removes first
        
        deque.addFirst("Front");
        deque.addLast("Back");
        System.out.println("   Deque: " + deque);
        
        // SET HIERARCHY
        System.out.println("\n3. SET HIERARCHY:");
        System.out.println("   Set (Interface) - No duplicates allowed");
        
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        
        hashSet.add("Red");
        hashSet.add("Blue");
        hashSet.add("Red"); // Duplicate ignored
        
        System.out.println("   HashSet: " + hashSet);
        System.out.println("   Size: " + hashSet.size()); // Only 2 elements
        
        // SPECIAL CASE: LinkedList implements BOTH List and Deque
        System.out.println("\n4. SPECIAL CASE - LinkedList:");
        LinkedList<String> special = new LinkedList<>();
        
        // Used as List
        special.add("Item1");
        special.add(0, "Item0"); // Index-based insertion
        
        // Used as Deque
        special.addFirst("Front");
        special.addLast("Back");
        
        System.out.println("   LinkedList as List+Deque: " + special);
        
        printHierarchy();
    }
    
    public static void printHierarchy() {
        System.out.println("\n=== COMPLETE HIERARCHY ===");
        System.out.println("Collection (Interface)");
        System.out.println("├── List (Interface) - Ordered, duplicates, indexed");
        System.out.println("│   ├── ArrayList - Resizable array");
        System.out.println("│   ├── LinkedList - Doubly-linked (also implements Deque)");
        System.out.println("│   └── Vector - Synchronized ArrayList");
        System.out.println("├── Set (Interface) - No duplicates");
        System.out.println("│   ├── HashSet - Hash table, no order");
        System.out.println("│   ├── LinkedHashSet - Hash table + insertion order");
        System.out.println("│   └── TreeSet - Sorted, Red-Black tree");
        System.out.println("└── Queue (Interface) - FIFO operations");
        System.out.println("    └── Deque (Interface) - Double-ended queue");
        System.out.println("        ├── ArrayDeque - Resizable array");
        System.out.println("        └── LinkedList - Doubly-linked (also List)");
        
        System.out.println("\nMap (Interface) - Separate hierarchy");
        System.out.println("├── HashMap - Hash table");
        System.out.println("├── LinkedHashMap - Hash table + insertion order");
        System.out.println("└── TreeMap - Sorted, Red-Black tree");
    }
}