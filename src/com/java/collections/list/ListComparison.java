package com.java.collections.list;

import java.util.*;

/**
 * Comparison of all List implementations
 * - Performance characteristics
 * - Use cases and recommendations
 */
public class ListComparison {
    public static void main(String[] args) {
        System.out.println("=== LIST IMPLEMENTATIONS COMPARISON ===\n");
        
        // Sample data
        List<String> data = Arrays.asList("A", "B", "C", "D", "E");
        
        // ArrayList
        List<String> arrayList = new ArrayList<>(data);
        System.out.println("ArrayList: " + arrayList);
        
        // LinkedList
        List<String> linkedList = new LinkedList<>(data);
        System.out.println("LinkedList: " + linkedList);
        
        // Vector
        List<String> vector = new Vector<>(data);
        System.out.println("Vector: " + vector);
        
        // Performance comparison
        performanceTest();
        
        // Use case recommendations
        printRecommendations();
    }
    
    static void performanceTest() {
        System.out.println("\n--- Performance Test (10000 elements) ---");
        
        int size = 10000;
        
        // ArrayList performance
        long start = System.nanoTime();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - start;
        
        // LinkedList performance
        start = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.nanoTime() - start;
        
        System.out.println("ArrayList add time: " + arrayListTime / 1000000 + " ms");
        System.out.println("LinkedList add time: " + linkedListTime / 1000000 + " ms");
        
        // Random access test
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(size / 2);
        }
        long arrayListAccess = System.nanoTime() - start;
        
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(size / 2);
        }
        long linkedListAccess = System.nanoTime() - start;
        
        System.out.println("ArrayList random access: " + arrayListAccess / 1000000 + " ms");
        System.out.println("LinkedList random access: " + linkedListAccess / 1000000 + " ms");
    }
    
    static void printRecommendations() {
        System.out.println("\n--- When to Use Each Implementation ---");
        
        System.out.println("\nArrayList:");
        System.out.println("✓ Frequent random access by index");
        System.out.println("✓ More reads than insertions/deletions");
        System.out.println("✓ Memory-efficient storage");
        System.out.println("✗ Frequent insertions/deletions in middle");
        
        System.out.println("\nLinkedList:");
        System.out.println("✓ Frequent insertions/deletions at ends");
        System.out.println("✓ Queue/Deque operations needed");
        System.out.println("✓ Unknown or varying size");
        System.out.println("✗ Random access by index");
        System.out.println("✗ Memory-sensitive applications");
        
        System.out.println("\nVector:");
        System.out.println("✓ Thread-safety required (legacy code)");
        System.out.println("✗ New applications (use ArrayList + synchronization)");
        System.out.println("✗ Performance-critical applications");
        
        System.out.println("\nStack:");
        System.out.println("✓ Legacy code requiring LIFO operations");
        System.out.println("✗ New applications (use ArrayDeque instead)");
        
        System.out.println("\n--- Performance Summary ---");
        System.out.println("Operation     | ArrayList | LinkedList | Vector");
        System.out.println("Add (end)     | O(1)*     | O(1)       | O(1)*");
        System.out.println("Add (middle)  | O(n)      | O(n)       | O(n)");
        System.out.println("Get by index  | O(1)      | O(n)       | O(1)");
        System.out.println("Remove        | O(n)      | O(1)**     | O(n)");
        System.out.println("Contains      | O(n)      | O(n)       | O(n)");
        System.out.println("Thread-safe   | No        | No         | Yes");
        System.out.println("\n* Amortized, ** If you have reference to node");
    }
}