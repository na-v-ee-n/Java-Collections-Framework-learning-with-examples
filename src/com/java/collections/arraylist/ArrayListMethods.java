package com.java.collections.arraylist;

import java.util.*;

/* ARRAYLIST METHODS REFERENCE:
 * 
 * ADDING METHODS:
 * - add(element) - Add at end, returns boolean
 * - add(index, element) - Add at specific index
 * - addAll(collection) - Add all elements from collection
 * - addAll(index, collection) - Add collection at specific index
 * 
 * REMOVING METHODS:
 * - remove(index) - Remove by index, returns removed element
 * - remove(object) - Remove by value, returns boolean
 * - removeAll(collection) - Remove all matching elements
 * - removeIf(predicate) - Remove elements matching condition
 * - clear() - Remove all elements
 * 
 * ACCESSING METHODS:
 * - get(index) - Get element at index
 * - set(index, element) - Replace element at index
 * - indexOf(element) - First occurrence index (-1 if not found)
 * - lastIndexOf(element) - Last occurrence index
 * 
 * QUERY METHODS:
 * - size() - Number of elements
 * - isEmpty() - Check if empty
 * - contains(element) - Check if element exists
 * - containsAll(collection) - Check if all elements exist
 * 
 * UTILITY METHODS:
 * - toArray() - Convert to array
 * - clone() - Create shallow copy
 * - trimToSize() - Reduce capacity to current size
 * - ensureCapacity(minCapacity) - Ensure minimum capacity
 */

public class ArrayListMethods {
    
    public static void main(String[] args) {
        System.out.println("=== ARRAYLIST METHODS DEMO ===\n");
        
        demonstrateAddingMethods();
        demonstrateRemovingMethods();
        demonstrateAccessingMethods();
        demonstrateQueryMethods();
        demonstrateUtilityMethods();
    }
    
    public static void demonstrateAddingMethods() {
        System.out.println("1. ADDING METHODS:");
        
        List<String> colors = new ArrayList<>();
        
        // add(element)
        colors.add("Red");
        colors.add("Blue");
        System.out.println("After add(): " + colors);
        
        // add(index, element)
        colors.add(1, "Green");
        System.out.println("After add(1, 'Green'): " + colors);
        
        // addAll(collection)
        colors.addAll(Arrays.asList("Yellow", "Purple"));
        System.out.println("After addAll(): " + colors);
        
        // addAll(index, collection)
        colors.addAll(2, Arrays.asList("Orange", "Pink"));
        System.out.println("After addAll(2, collection): " + colors);
        
        System.out.println();
    }
    
    public static void demonstrateRemovingMethods() {
        System.out.println("2. REMOVING METHODS:");
        
        List<String> animals = new ArrayList<>(Arrays.asList("Cat", "Dog", "Bird", "Fish", "Dog"));
        System.out.println("Initial: " + animals);
        
        // remove(index)
        String removed = animals.remove(0);
        System.out.println("Removed by index 0: " + removed + " -> " + animals);
        
        // remove(object)
        boolean wasRemoved = animals.remove("Dog");
        System.out.println("Removed 'Dog': " + wasRemoved + " -> " + animals);
        
        // removeAll(collection)
        animals.removeAll(Arrays.asList("Bird", "Fish"));
        System.out.println("After removeAll(): " + animals);
        
        // removeIf(predicate) - Java 8+
        animals.addAll(Arrays.asList("Elephant", "Eagle", "Eel"));
        animals.removeIf(animal -> animal.startsWith("E"));
        System.out.println("After removeIf(starts with 'E'): " + animals);
        
        System.out.println();
    }
    
    public static void demonstrateAccessingMethods() {
        System.out.println("3. ACCESSING METHODS:");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 20, 40));
        System.out.println("Numbers: " + numbers);
        
        // get(index)
        System.out.println("Element at index 2: " + numbers.get(2));
        
        // set(index, element)
        Integer oldValue = numbers.set(1, 25);
        System.out.println("Set index 1 to 25, old value: " + oldValue + " -> " + numbers);
        
        // indexOf(element)
        System.out.println("First index of 20: " + numbers.indexOf(20));
        
        // lastIndexOf(element)
        System.out.println("Last index of 20: " + numbers.lastIndexOf(20));
        
        System.out.println();
    }
    
    public static void demonstrateQueryMethods() {
        System.out.println("4. QUERY METHODS:");
        
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        
        // size()
        System.out.println("Size: " + fruits.size());
        
        // isEmpty()
        System.out.println("Is empty: " + fruits.isEmpty());
        
        // contains(element)
        System.out.println("Contains 'Banana': " + fruits.contains("Banana"));
        
        // containsAll(collection)
        System.out.println("Contains all [Apple, Cherry]: " + 
                          fruits.containsAll(Arrays.asList("Apple", "Cherry")));
        
        System.out.println();
    }
    
    public static void demonstrateUtilityMethods() {
        System.out.println("5. UTILITY METHODS:");
        
        ArrayList<String> original = new ArrayList<>(Arrays.asList("A", "B", "C"));
        
        // toArray()
        Object[] array = original.toArray();
        System.out.println("To array: " + Arrays.toString(array));
        
        // toArray(T[] array)
        String[] stringArray = original.toArray(new String[0]);
        System.out.println("To String array: " + Arrays.toString(stringArray));
        
        // clone()
        ArrayList<String> cloned = (ArrayList<String>) original.clone();
        System.out.println("Cloned: " + cloned);
        
        // Verify shallow copy
        cloned.add("D");
        System.out.println("Original after clone modification: " + original);
        System.out.println("Cloned after modification: " + cloned);
        
        System.out.println();
    }
}