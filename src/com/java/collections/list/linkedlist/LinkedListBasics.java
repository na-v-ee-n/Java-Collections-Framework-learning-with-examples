package com.java.collections.list.linkedlist;

import java.util.LinkedList;

/**
 * LinkedList Basics - Essential Operations
 * Doubly-linked list implementation of List and Deque interfaces
 */
public class LinkedListBasics {
    public static void main(String[] args) {
        System.out.println("=== LINKEDLIST BASICS ===\n");
        
        // Creation
        LinkedList<String> list = new LinkedList<>();
        
        // Basic operations
        list.add("First");
        list.add("Second");
        list.addFirst("Start");
        list.addLast("End");
        
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        
        // Removal
        list.removeFirst();
        list.removeLast();
        System.out.println("After removal: " + list);
        
        // Key advantages
        System.out.println("\nKey Features:");
        System.out.println("• Fast insertion/deletion at ends O(1)");
        System.out.println("• Implements List + Deque interfaces");
        System.out.println("• Good for frequent add/remove operations");
    }
}