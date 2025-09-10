package com.java.brushup;

/**
 * FUNCTIONAL INTERFACE - Step by Step Learning
 * 
 * What is a Functional Interface?
 * - An interface with EXACTLY ONE abstract method
 * - Can have multiple default and static methods
 * - Used as foundation for lambda expressions (we'll learn lambdas next!)
 * - Marked with @FunctionalInterface annotation (optional but recommended)
 */

// Step 1: Creating a simple functional interface
@FunctionalInterface
interface Calculator {
    // Only ONE abstract method allowed
    int calculate(int a, int b);
    
    // Default methods are allowed (they have implementation)
    default void printResult(int a, int b) {
        System.out.println("Result: " + calculate(a, b));
    }
    
    // Static methods are allowed
    static void info() {
        System.out.println("This is Calculator functional interface");
    }
}

// Step 2: More functional interface examples
@FunctionalInterface
interface StringChecker {
    boolean check(String text);
}

@FunctionalInterface
interface NumberProcessor {
    void process(int number);
}

@FunctionalInterface
interface ValueSupplier {
    String getValue();
}

public class FunctionalInterfaceDemo {
    
    public static void main(String[] args) {
        System.out.println("=== FUNCTIONAL INTERFACE BASICS ===\n");
        
       step1_TraditionalWay();
        // step2_AnonymousClasses();
        // step3_WhyFunctionalInterfaces();
        // step4_BuiltInInterfaces();
    }
    
    // Step 1: Traditional way - Creating classes
    public static void step1_TraditionalWay() {
        System.out.println("STEP 1: Traditional Way (Creating Classes)\n");
        
        // We need to create separate classes for each operation
        Calculator adder = new Addition();
        Calculator multiplier = new Multiplication();
        
        System.out.println("10 + 5 = " + adder.calculate(10, 5));
        System.out.println("10 * 5 = " + multiplier.calculate(10, 5));
        
        System.out.println("Problem: Too many classes for simple operations!\n");
    }
    
    // Step 2: Anonymous classes - Better but still verbose
    public static void step2_AnonymousClasses() {
        System.out.println("STEP 2: Anonymous Classes (Better but Verbose)\n");
        
        // Create implementation without separate class files
        Calculator subtractor = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }
        };
        
        Calculator divider = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a / b;
            }
        };
        
        System.out.println("10 - 5 = " + subtractor.calculate(10, 5));
        System.out.println("10 / 5 = " + divider.calculate(10, 5));
        
        // Using default method
        subtractor.printResult(20, 8);
        
        // Using static method
        Calculator.info();
        
        System.out.println("Better, but still too much code for simple operations!\n");
    }
    
    // Step 3: Why functional interfaces are special
    public static void step3_WhyFunctionalInterfaces() {
        System.out.println("STEP 3: Why Functional Interfaces are Special\n");
        
        System.out.println("Functional interfaces are special because:");
        System.out.println("1. They have exactly ONE abstract method");
        System.out.println("2. This makes them perfect for lambda expressions");
        System.out.println("3. Lambda expressions = shorter, cleaner code");
        System.out.println("4. We'll learn lambdas in the next lesson!\n");
        
        // Examples of what makes an interface functional
        System.out.println("Examples of Functional Interfaces:");
        
        StringChecker isEmpty = new StringChecker() {
            @Override
            public boolean check(String text) {
                return text.isEmpty();
            }
        };
        
        NumberProcessor printer = new NumberProcessor() {
            @Override
            public void process(int number) {
                System.out.println("Processing: " + number);
            }
        };
        
        ValueSupplier greeting = new ValueSupplier() {
            @Override
            public String getValue() {
                return "Hello World!";
            }
        };
        
        // Using them
        System.out.println("Is empty string empty? " + isEmpty.check(""));
        printer.process(42);
        System.out.println("Greeting: " + greeting.getValue());
        
        System.out.println();
    }
    
    // Step 4: Java's built-in functional interfaces (preview)
    public static void step4_BuiltInInterfaces() {
        System.out.println("STEP 4: Java's Built-in Functional Interfaces (Preview)\n");
        
        System.out.println("Java provides many built-in functional interfaces:");
        System.out.println();
        
        System.out.println("1. Predicate<T> - Tests a condition");
        System.out.println("   - Has method: boolean test(T t)");
        System.out.println("   - Example: Check if number is even");
        System.out.println();
        
        System.out.println("2. Function<T,R> - Transforms input to output");
        System.out.println("   - Has method: R apply(T t)");
        System.out.println("   - Example: Convert string to its length");
        System.out.println();
        
        System.out.println("3. Consumer<T> - Consumes/processes input");
        System.out.println("   - Has method: void accept(T t)");
        System.out.println("   - Example: Print a value");
        System.out.println();
        
        System.out.println("4. Supplier<T> - Supplies/generates a value");
        System.out.println("   - Has method: T get()");
        System.out.println("   - Example: Generate random number");
        System.out.println();
        
        System.out.println("We'll use these with lambda expressions in the next lesson!");
        System.out.println();
        
        System.out.println("=== SUMMARY ===");
        System.out.println("✓ Functional Interface = Interface with ONE abstract method");
        System.out.println("✓ Can have default and static methods");
        System.out.println("✓ Foundation for lambda expressions");
        System.out.println("✓ Java provides many built-in functional interfaces");
        System.out.println("✓ Next: Learn Lambda Expressions!");
    }
}

// Helper classes for traditional approach
class Addition implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

class Multiplication implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}