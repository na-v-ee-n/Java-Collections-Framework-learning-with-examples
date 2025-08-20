package com.java.collections.brushup;

import java.util.function.*;

/* FUNCTIONAL INTERFACE DEFINITION:
 * 
 * FUNCTIONAL INTERFACE = Interface with exactly ONE abstract method
 * - Can have multiple default and static methods
 * - Annotated with @FunctionalInterface (optional but recommended)
 * - Target for lambda expressions and method references
 * - Foundation of functional programming in Java 8+
 * 
 * BUILT-IN FUNCTIONAL INTERFACES (java.util.function):
 * 
 * 1. PREDICATE<T> - Takes T, returns boolean
 *    - test(T t) - for filtering/testing conditions
 * 
 * 2. FUNCTION<T,R> - Takes T, returns R
 *    - apply(T t) - for transforming/mapping
 * 
 * 3. CONSUMER<T> - Takes T, returns void
 *    - accept(T t) - for consuming/processing
 * 
 * 4. SUPPLIER<T> - Takes nothing, returns T
 *    - get() - for supplying/generating values
 * 
 * 5. BIFUNCTION<T,U,R> - Takes T and U, returns R
 *    - apply(T t, U u) - for binary operations
 * 
 * 6. UNARYOPERATOR<T> - Takes T, returns T (extends Function<T,T>)
 *    - apply(T t) - for same-type transformations
 * 
 * 7. BINARYOPERATOR<T> - Takes two T, returns T (extends BiFunction<T,T,T>)
 *    - apply(T t1, T t2) - for combining same types
 */

// Custom functional interface
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
    
    // Default methods allowed
    default void printResult(int a, int b) {
        System.out.println("Result: " + calculate(a, b));
    }
    
    // Static methods allowed
    static void info() {
        System.out.println("Calculator functional interface");
    }
}

public class FunctionalInterfaceDemo {
    
    public static void main(String[] args) {
        System.out.println("=== FUNCTIONAL INTERFACE DEMO ===\n");
        
        demonstrateCustomFunctionalInterface();
        demonstrateBuiltInInterfaces();
        demonstratePredicates();
        demonstrateFunctions();
        demonstrateConsumers();
        demonstrateSuppliers();
    }
    
    public static void demonstrateCustomFunctionalInterface() {
        System.out.println("1. CUSTOM FUNCTIONAL INTERFACE:");
        
        // Using lambda expression
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtract = (a, b) -> a - b;
        
        System.out.println("Addition: " + add.calculate(10, 5));
        System.out.println("Multiplication: " + multiply.calculate(10, 5));
        System.out.println("Subtraction: " + subtract.calculate(10, 5));
        
        // Using default method
        add.printResult(8, 3);
        
        // Using static method
        Calculator.info();
        
        System.out.println();
    }
    
    public static void demonstrateBuiltInInterfaces() {
        System.out.println("2. BUILT-IN FUNCTIONAL INTERFACES:");
        
        // Predicate - test condition
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 5 even? " + isEven.test(5));
        
        // Function - transform input
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Consumer - consume input
        Consumer<String> printer = str -> System.out.println("Processing: " + str);
        printer.accept("Java");
        
        // Supplier - supply value
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random value: " + randomValue.get());
        
        System.out.println();
    }
    
    public static void demonstratePredicates() {
        System.out.println("3. PREDICATE EXAMPLES:");
        
        Predicate<String> isEmpty = str -> str.isEmpty();
        Predicate<String> isLong = str -> str.length() > 5;
        Predicate<Integer> isPositive = num -> num > 0;
        
        // Basic usage
        System.out.println("Is '' empty? " + isEmpty.test(""));
        System.out.println("Is 'Hello World' long? " + isLong.test("Hello World"));
        
        // Combining predicates
        Predicate<String> isNotEmptyAndLong = isEmpty.negate().and(isLong);
        System.out.println("Is 'Programming' not empty and long? " + 
                          isNotEmptyAndLong.test("Programming"));
        
        // Predicate with collections
        java.util.List<Integer> numbers = java.util.Arrays.asList(-2, -1, 0, 1, 2, 3);
        long positiveCount = numbers.stream().filter(isPositive).count();
        System.out.println("Positive numbers count: " + positiveCount);
        
        System.out.println();
    }
    
    public static void demonstrateFunctions() {
        System.out.println("4. FUNCTION EXAMPLES:");
        
        Function<String, String> toUpperCase = str -> str.toUpperCase();
        Function<String, Integer> wordCount = str -> str.split("\\s+").length;
        Function<Integer, Integer> square = num -> num * num;
        
        // Basic usage
        System.out.println("Uppercase: " + toUpperCase.apply("hello world"));
        System.out.println("Word count: " + wordCount.apply("Java is awesome"));
        System.out.println("Square of 5: " + square.apply(5));
        
        // Function composition
        Function<String, Integer> upperCaseLength = toUpperCase.andThen(String::length);
        System.out.println("Length after uppercase: " + upperCaseLength.apply("java"));
        
        // BiFunction example
        BiFunction<Integer, Integer, Integer> power = (base, exp) -> (int) Math.pow(base, exp);
        System.out.println("2^3 = " + power.apply(2, 3));
        
        System.out.println();
    }
    
    public static void demonstrateConsumers() {
        System.out.println("5. CONSUMER EXAMPLES:");
        
        Consumer<String> logger = msg -> System.out.println("[LOG] " + msg);
        Consumer<Integer> numberProcessor = num -> System.out.println("Processing number: " + num);
        
        // Basic usage
        logger.accept("Application started");
        numberProcessor.accept(42);
        
        // Consumer chaining
        Consumer<String> upperCaseLogger = logger.andThen(msg -> 
            System.out.println("[UPPER] " + msg.toUpperCase()));
        upperCaseLogger.accept("chained consumer");
        
        // BiConsumer example
        BiConsumer<String, Integer> keyValuePrinter = (key, value) -> 
            System.out.println(key + " = " + value);
        keyValuePrinter.accept("Age", 25);
        
        System.out.println();
    }
    
    public static void demonstrateSuppliers() {
        System.out.println("6. SUPPLIER EXAMPLES:");
        
        Supplier<String> currentTime = () -> java.time.LocalTime.now().toString();
        Supplier<Integer> randomNumber = () -> (int)(Math.random() * 100);
        Supplier<java.util.List<String>> emptyList = () -> new java.util.ArrayList<>();
        
        // Basic usage
        System.out.println("Current time: " + currentTime.get());
        System.out.println("Random number: " + randomNumber.get());
        System.out.println("Empty list: " + emptyList.get());
        
        // Lazy evaluation with Supplier
        System.out.println("Lazy evaluation demo:");
        processValue(true, () -> "Expensive computation result");
        processValue(false, () -> "This won't be computed");
        
        System.out.println();
    }
    
    // Helper method for lazy evaluation
    public static void processValue(boolean condition, Supplier<String> valueSupplier) {
        if(condition) {
            System.out.println("Value: " + valueSupplier.get());
        } else {
            System.out.println("Condition false, supplier not called");
        }
    }
}