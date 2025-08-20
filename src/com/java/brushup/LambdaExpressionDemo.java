package com.java.brushup;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/* LAMBDA EXPRESSION DEFINITION:
 * 
 * LAMBDA EXPRESSION = Anonymous function that can be passed around
 * - Introduced in Java 8
 * - Provides clear and concise way to represent functional interfaces
 * - Enables functional programming style
 * - Reduces boilerplate code
 * 
 * SYNTAX:
 * (parameters) -> expression
 * (parameters) -> { statements; }
 * 
 * COMPONENTS:
 * 1. Parameter list: (int a, int b) or (a, b) or a (single param)
 * 2. Arrow operator: ->
 * 3. Body: expression or block of statements
 * 
 * TYPES:
 * 1. No parameters: () -> expression
 * 2. Single parameter: x -> expression (parentheses optional)
 * 3. Multiple parameters: (x, y) -> expression
 * 4. Block body: (x, y) -> { statements; return value; }
 * 
 * BENEFITS:
 * - Concise code
 * - Functional programming
 * - Better readability
 * - Easier parallel processing
 * - Method references support
 */

public class LambdaExpressionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== LAMBDA EXPRESSION DEMO ===\n");
        
        demonstrateBasicSyntax();
        demonstrateWithCollections();
        demonstrateMethodReferences();
        demonstrateVariableCapture();
        demonstrateStreamOperations();
    }
    
    public static void demonstrateBasicSyntax() {
        System.out.println("1. BASIC LAMBDA SYNTAX:");
        
        // No parameters
        Runnable task = () -> System.out.println("Task executed!");
        task.run();
        
        // Single parameter (parentheses optional)
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));
        
        // Multiple parameters
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));
        
        // Block body with return
        Function<String, String> formatter = (str) -> {
            String result = str.trim().toUpperCase();
            return "Formatted: " + result;
        };
        System.out.println(formatter.apply("  hello world  "));
        
        // Predicate example
        Predicate<String> isLongString = s -> s.length() > 5;
        System.out.println("Is 'Programming' long? " + isLongString.test("Programming"));
        
        System.out.println();
    }
    
    public static void demonstrateWithCollections() {
        System.out.println("2. LAMBDA WITH COLLECTIONS:");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        
        // forEach with lambda
        System.out.print("Names: ");
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();
        
        // Filtering with lambda
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        System.out.println("Long names: " + longNames);
        
        // Sorting with lambda
        List<String> sortedNames = new ArrayList<>(names);
        sortedNames.sort((a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Sorted names: " + sortedNames);
        
        // Mapping with lambda
        List<Integer> nameLengths = names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());
        System.out.println("Name lengths: " + nameLengths);
        
        // Reducing with lambda
        Optional<String> longestName = names.stream()
                .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        System.out.println("Longest name: " + longestName.orElse("None"));
        
        System.out.println();
    }
    
    public static void demonstrateMethodReferences() {
        System.out.println("3. METHOD REFERENCES (Lambda shortcuts):");
        
        List<String> words = Arrays.asList("java", "python", "javascript", "go");
        
        // Static method reference
        System.out.println("Using String::valueOf");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .map(String::valueOf)  // Same as: x -> String.valueOf(x)
                .forEach(System.out::println);
        
        // Instance method reference
        System.out.println("Using String::toUpperCase");
        words.stream()
                .map(String::toUpperCase)  // Same as: s -> s.toUpperCase()
                .forEach(System.out::println);
        
        // Constructor reference
        System.out.println("Using ArrayList::new");
        List<List<String>> listOfLists = words.stream()
                .map(word -> Arrays.asList(word))
                .collect(Collectors.toCollection(ArrayList::new));  // Same as: () -> new ArrayList<>()
        System.out.println("List of lists: " + listOfLists);
        
        // Method reference on specific object
        String prefix = "Language: ";
        Function<String, String> prefixer = prefix::concat;  // Same as: s -> prefix.concat(s)
        System.out.println(prefixer.apply("Java"));
        
        System.out.println();
    }
    
    public static void demonstrateVariableCapture() {
        System.out.println("4. VARIABLE CAPTURE:");
        
        // Effectively final variables can be captured
        String message = "Hello";  // Effectively final
        final int multiplier = 2;  // Final
        
        Function<String, String> greeter = name -> message + ", " + name + "!";
        Function<Integer, Integer> doubler = x -> x * multiplier;
        
        System.out.println(greeter.apply("World"));
        System.out.println("Double of 5: " + doubler.apply(5));
        
        // Local variables in enclosing scope
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int threshold = 3;  // Effectively final
        
        List<Integer> filtered = numbers.stream()
                .filter(n -> n > threshold)  // Captures threshold
                .collect(Collectors.toList());
        System.out.println("Numbers > " + threshold + ": " + filtered);
        
        // Instance variables can be accessed
        demonstrateInstanceVariableAccess();
        
        System.out.println();
    }
    
    private static String instanceVar = "Instance Variable";
    
    private static void demonstrateInstanceVariableAccess() {
        Supplier<String> supplier = () -> "Accessing: " + instanceVar;
        System.out.println(supplier.get());
    }
    
    public static void demonstrateStreamOperations() {
        System.out.println("5. LAMBDA WITH STREAM OPERATIONS:");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 35),
            new Person("Diana", 28)
        );
        
        // Complex filtering and mapping
        List<String> adultNames = people.stream()
                .filter(person -> person.age >= 30)  // Filter adults
                .map(person -> person.name.toUpperCase())  // Transform names
                .sorted()  // Sort alphabetically
                .collect(Collectors.toList());
        System.out.println("Adult names (uppercase, sorted): " + adultNames);
        
        // Grouping with lambda
        Map<Boolean, List<Person>> groupedByAge = people.stream()
                .collect(Collectors.partitioningBy(person -> person.age >= 30));
        System.out.println("Adults: " + groupedByAge.get(true));
        System.out.println("Young: " + groupedByAge.get(false));
        
        // Finding with lambda
        Optional<Person> oldestPerson = people.stream()
                .max((p1, p2) -> Integer.compare(p1.age, p2.age));
        System.out.println("Oldest person: " + oldestPerson.orElse(null));
        
        // Parallel processing with lambda
        long count = people.parallelStream()
                .filter(person -> person.name.length() > 4)
                .count();
        System.out.println("People with long names: " + count);
        
        System.out.println();
    }
    
    // Helper class
    static class Person {
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}