package com.java.collections.arraylist;

import java.util.*;

/* ARRAYLIST ITERATION METHODS:
 * 
 * 1. ENHANCED FOR LOOP (for-each):
 *    - Simplest and most readable
 *    - Read-only access
 *    - Cannot modify collection during iteration
 * 
 * 2. TRADITIONAL FOR LOOP:
 *    - Index-based access
 *    - Can modify collection (with caution)
 *    - Best for accessing by index
 * 
 * 3. ITERATOR:
 *    - Safe removal during iteration
 *    - Forward direction only
 *    - Fail-fast behavior
 * 
 * 4. LISTITERATOR:
 *    - Bidirectional iteration
 *    - Can add, remove, set during iteration
 *    - Index information available
 * 
 * 5. STREAMS (Java 8+):
 *    - Functional programming approach
 *    - Powerful filtering and transformation
 *    - Parallel processing support
 */

public class ArrayListIterators {
    
    public static void main(String[] args) {
        System.out.println("=== ARRAYLIST ITERATION METHODS ===\n");
        
        List<String> languages = new ArrayList<>(Arrays.asList("Java", "Python", "JavaScript", "C++", "Go"));
        
        demonstrateEnhancedForLoop(languages);
        demonstrateTraditionalForLoop(languages);
        demonstrateIterator(languages);
        demonstrateListIterator(languages);
        demonstrateStreams(languages);
        demonstrateIteratorSafety();
    }
    
    public static void demonstrateEnhancedForLoop(List<String> languages) {
        System.out.println("1. ENHANCED FOR LOOP (for-each):");
        
        // Simple iteration
        System.out.print("Languages: ");
        for(String language : languages) {
            System.out.print(language + " ");
        }
        System.out.println("\n");
    }
    
    public static void demonstrateTraditionalForLoop(List<String> languages) {
        System.out.println("2. TRADITIONAL FOR LOOP:");
        
        // Forward iteration with index
        System.out.println("Forward with index:");
        for(int i = 0; i < languages.size(); i++) {
            System.out.println(i + ": " + languages.get(i));
        }
        
        // Backward iteration
        System.out.println("Backward iteration:");
        for(int i = languages.size() - 1; i >= 0; i--) {
            System.out.println(i + ": " + languages.get(i));
        }
        System.out.println();
    }
    
    public static void demonstrateIterator(List<String> languages) {
        System.out.println("3. ITERATOR:");
        
        List<String> copy = new ArrayList<>(languages);
        Iterator<String> iterator = copy.iterator();
        
        System.out.println("Iterating and removing elements containing 'a':");
        while(iterator.hasNext()) {
            String language = iterator.next();
            System.out.print(language + " ");
            
            if(language.toLowerCase().contains("a")) {
                iterator.remove();  // Safe removal
                System.out.print("(removed) ");
            }
        }
        System.out.println("\nAfter removal: " + copy);
        System.out.println();
    }
    
    public static void demonstrateListIterator(List<String> languages) {
        System.out.println("4. LISTITERATOR:");
        
        List<String> copy = new ArrayList<>(languages);
        ListIterator<String> listIterator = copy.listIterator();
        
        // Forward iteration with modification
        System.out.println("Forward iteration with index:");
        while(listIterator.hasNext()) {
            int index = listIterator.nextIndex();
            String language = listIterator.next();
            System.out.println(index + ": " + language);
            
            // Add element after Java
            if(language.equals("Java")) {
                listIterator.add("Kotlin");  // Add after current
            }
        }
        
        System.out.println("After adding Kotlin: " + copy);
        
        // Backward iteration
        System.out.println("Backward iteration:");
        while(listIterator.hasPrevious()) {
            String language = listIterator.previous();
            System.out.print(language + " ");
        }
        System.out.println("\n");
    }
    
    public static void demonstrateStreams(List<String> languages) {
        System.out.println("5. STREAMS (Java 8+):");
        
        // Simple forEach
        System.out.print("Using forEach: ");
        languages.stream().forEach(lang -> System.out.print(lang + " "));
        System.out.println();
        
        // Filter and collect
        List<String> longNames = languages.stream()
                .filter(lang -> lang.length() > 4)
                .collect(Collectors.toList());
        System.out.println("Languages with > 4 characters: " + longNames);
        
        // Transform and collect
        List<String> upperCase = languages.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase: " + upperCase);
        
        // Find operations
        Optional<String> firstLong = languages.stream()
                .filter(lang -> lang.length() > 6)
                .findFirst();
        System.out.println("First language > 6 chars: " + firstLong.orElse("None"));
        
        System.out.println();
    }
    
    public static void demonstrateIteratorSafety() {
        System.out.println("6. ITERATOR SAFETY:");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        
        // WRONG WAY - ConcurrentModificationException
        System.out.println("Wrong way (will cause exception):");
        try {
            for(Integer num : numbers) {
                if(num % 2 == 0) {
                    numbers.remove(num);  // This will throw exception
                }
            }
        } catch(ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught!");
        }
        
        // RIGHT WAY - Using Iterator
        System.out.println("Right way using Iterator:");
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()) {
            Integer num = it.next();
            if(num % 2 == 0) {
                it.remove();  // Safe removal
            }
        }
        System.out.println("After safe removal: " + numbers);
        
        // ALTERNATIVE - Using removeIf (Java 8+)
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        numbers.removeIf(num -> num % 2 == 0);
        System.out.println("Using removeIf: " + numbers);
    }
}