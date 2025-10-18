package com.java.collections.list.linkedlist;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * LinkedList Iterators - Different ways to traverse
 */
public class LinkedListIterators {
    public static void main(String[] args) {
        System.out.println("=== LINKEDLIST ITERATORS ===\n");
        
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        
        // Enhanced for loop
        System.out.println("Enhanced for loop:");
        for (String color : colors) {
            System.out.print(color + " ");
        }
        System.out.println();
        
        // Iterator (forward only)
        System.out.println("\nIterator (forward):");
        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // ListIterator (bidirectional)
        System.out.println("\nListIterator (backward):");
        ListIterator<String> listIterator = colors.listIterator(colors.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        
        // Descendingiterator
        System.out.println("\nDescending Iterator:");
        Iterator<String> descIterator = colors.descendingIterator();
        while (descIterator.hasNext()) {
            System.out.print(descIterator.next() + " ");
        }
        System.out.println();
        
        System.out.println("\nIteration Options:");
        System.out.println("• Enhanced for loop - simplest");
        System.out.println("• Iterator - forward traversal");
        System.out.println("• ListIterator - bidirectional");
        System.out.println("• DescendingIterator - reverse order");
    }
}