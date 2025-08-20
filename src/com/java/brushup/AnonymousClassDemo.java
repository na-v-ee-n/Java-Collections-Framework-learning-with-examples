package com.java.brushup;

import java.util.*;

/* ANONYMOUS CLASS DEFINITION:
 * 
 * ANONYMOUS CLASS = Class without a name that extends a class or implements an interface
 * - Defined and instantiated at the same time
 * - Used for one-time implementations
 * - Can access final/effectively final variables from enclosing scope
 * - Creates separate .class file (OuterClass$1.class)
 * 
 * SYNTAX:
 * new SuperClass/Interface() {
 *     // class body with method implementations
 * };
 * 
 * WHEN TO USE:
 * - One-time implementation needed
 * - Small, simple implementations
 * - Event handling (GUI applications)
 * - Callback implementations
 * 
 * WHEN NOT TO USE:
 * - Complex logic (use named class)
 * - Reusable code (use named class)
 * - Java 8+ functional interfaces (use lambda)
 * 
 * VS LAMBDA EXPRESSIONS:
 * - Anonymous class: Can implement any interface/extend class
 * - Lambda: Only for functional interfaces (single abstract method)
 * - Anonymous class: Can have state (instance variables)
 * - Lambda: Stateless
 * - Anonymous class: Can access 'this' (refers to anonymous class)
 * - Lambda: 'this' refers to enclosing class
 */

// Interface for demonstration
interface Greeting {
    void greet(String name);
    
    default void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}

// Abstract class for demonstration
abstract class Animal {
    protected String species;
    
    public Animal(String species) {
        this.species = species;
    }
    
    abstract void makeSound();
    
    void sleep() {
        System.out.println(species + " is sleeping");
    }
}

public class AnonymousClassDemo {
    
    private String instanceField = "Instance Field";
    
    public static void main(String[] args) {
        System.out.println("=== ANONYMOUS CLASS DEMO ===\n");
        
        AnonymousClassDemo demo = new AnonymousClassDemo();
        demo.demonstrateInterfaceImplementation();
        demo.demonstrateAbstractClassExtension();
        demo.demonstrateWithCollections();
        demo.demonstrateVariableAccess();
        demo.demonstrateVsLambda();
        demo.demonstrateEventHandling();
    }
    
    public void demonstrateInterfaceImplementation() {
        System.out.println("1. ANONYMOUS CLASS IMPLEMENTING INTERFACE:");
        
        // Anonymous class implementing Greeting interface
        Greeting formalGreeting = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Good morning, " + name + "!");
            }
        };
        
        Greeting casualGreeting = new Greeting() {
            private String style = "casual";  // Can have instance variables
            
            @Override
            public void greet(String name) {
                System.out.println("Hey " + name + "! (" + style + " style)");
            }
            
            // Can have additional methods (but can't be called from outside)
            private void additionalMethod() {
                System.out.println("Additional method in anonymous class");
            }
        };
        
        formalGreeting.greet("Alice");
        casualGreeting.greet("Bob");
        formalGreeting.sayGoodbye();  // Can use default methods
        
        System.out.println();
    }
    
    public void demonstrateAbstractClassExtension() {
        System.out.println("2. ANONYMOUS CLASS EXTENDING ABSTRACT CLASS:");
        
        // Anonymous class extending Animal
        Animal dog = new Animal("Dog") {
            @Override
            void makeSound() {
                System.out.println(species + " says: Woof!");
            }
            
            // Can override concrete methods too
            @Override
            void sleep() {
                System.out.println(species + " sleeps in a doghouse");
            }
        };
        
        Animal cat = new Animal("Cat") {
            private boolean isHungry = true;
            
            @Override
            void makeSound() {
                if(isHungry) {
                    System.out.println(species + " says: Meow! (hungry)");
                } else {
                    System.out.println(species + " says: Purr...");
                }
            }
        };
        
        dog.makeSound();
        dog.sleep();
        cat.makeSound();
        
        System.out.println();
    }
    
    public void demonstrateWithCollections() {
        System.out.println("3. ANONYMOUS CLASS WITH COLLECTIONS:");
        
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        
        // Custom Comparator using anonymous class
        Collections.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Sort by length, then alphabetically
                int lengthCompare = Integer.compare(s1.length(), s2.length());
                return lengthCompare != 0 ? lengthCompare : s1.compareTo(s2);
            }
        });
        System.out.println("Sorted by length then alphabetically: " + fruits);
        
        // Custom filtering using anonymous class
        List<String> filtered = new ArrayList<>();
        fruits.forEach(new java.util.function.Consumer<String>() {
            @Override
            public void accept(String fruit) {
                if(fruit.length() > 4) {
                    filtered.add(fruit.toUpperCase());
                }
            }
        });
        System.out.println("Long fruits (uppercase): " + filtered);
        
        System.out.println();
    }
    
    public void demonstrateVariableAccess() {
        System.out.println("4. VARIABLE ACCESS IN ANONYMOUS CLASS:");
        
        final String finalVar = "Final Variable";
        String effectivelyFinalVar = "Effectively Final";
        // String nonFinalVar = "Non-final";  // Can't be accessed if modified
        
        Runnable task = new Runnable() {
            private String taskName = "Anonymous Task";
            
            @Override
            public void run() {
                // Can access final/effectively final variables
                System.out.println("Task: " + taskName);
                System.out.println("Final var: " + finalVar);
                System.out.println("Effectively final: " + effectivelyFinalVar);
                System.out.println("Instance field: " + instanceField);
                
                // 'this' refers to the anonymous class instance
                System.out.println("This class: " + this.getClass().getSimpleName());
            }
        };
        
        task.run();
        
        // nonFinalVar = "Modified";  // This would make it non-effectively-final
        
        System.out.println();
    }
    
    public void demonstrateVsLambda() {
        System.out.println("5. ANONYMOUS CLASS VS LAMBDA:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Anonymous class approach
        numbers.forEach(new java.util.function.Consumer<Integer>() {
            private int count = 0;  // Can have state
            
            @Override
            public void accept(Integer num) {
                count++;
                System.out.println("Processing #" + count + ": " + num);
            }
        });
        
        System.out.println("---");
        
        // Lambda approach (for functional interfaces only)
        numbers.forEach(num -> System.out.println("Lambda processing: " + num));
        
        // Anonymous class can implement multiple methods
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running with anonymous class");
            }
            
            // Could override other methods if Runnable had them
        });
        
        // Lambda for same functionality (cleaner for functional interfaces)
        Thread lambdaThread = new Thread(() -> 
            System.out.println("Thread running with lambda"));
        
        thread.start();
        try { thread.join(); } catch(InterruptedException e) {}
        
        lambdaThread.start();
        try { lambdaThread.join(); } catch(InterruptedException e) {}
        
        System.out.println();
    }
    
    public void demonstrateEventHandling() {
        System.out.println("6. EVENT HANDLING SIMULATION:");
        
        // Simulating event handling (common use case for anonymous classes)
        EventSource eventSource = new EventSource();
        
        // Multiple event listeners using anonymous classes
        eventSource.addListener(new EventListener() {
            @Override
            public void onEvent(String event) {
                System.out.println("Logger: Event occurred - " + event);
            }
        });
        
        eventSource.addListener(new EventListener() {
            private int eventCount = 0;
            
            @Override
            public void onEvent(String event) {
                eventCount++;
                System.out.println("Counter: Event #" + eventCount + " - " + event);
            }
        });
        
        // Trigger events
        eventSource.fireEvent("User Login");
        eventSource.fireEvent("Data Updated");
        
        System.out.println();
    }
    
    // Helper classes for event handling demo
    interface EventListener {
        void onEvent(String event);
    }
    
    static class EventSource {
        private List<EventListener> listeners = new ArrayList<>();
        
        public void addListener(EventListener listener) {
            listeners.add(listener);
        }
        
        public void fireEvent(String event) {
            for(EventListener listener : listeners) {
                listener.onEvent(event);
            }
        }
    }
}