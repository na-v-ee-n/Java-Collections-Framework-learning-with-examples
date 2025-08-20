package com.java.interfaces;

// ADVANCED INTERFACE CONCEPTS

// STEP 6: Interface with Constants
interface MathConstants {
    // Variables in interface are public, static, final by default
    double PI = 3.14159;
    int MAX_VALUE = 100;
}

// STEP 7: Multiple Interface Implementation
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

// Class can implement MULTIPLE interfaces
class Duck implements Animal, Flyable, Swimmable {
    public void makeSound() {
        System.out.println("Quack!");
    }
    
    public void move() {
        System.out.println("Duck waddles");
    }
    
    public void fly() {
        System.out.println("Duck flies");
    }
    
    public void swim() {
        System.out.println("Duck swims");
    }
}

// STEP 8: Interface Inheritance
interface Vehicle {
    void start();
}

interface Car extends Vehicle {  // Interface can extend another interface
    void drive();
}

class Toyota implements Car {
    public void start() {
        System.out.println("Toyota starts");
    }
    
    public void drive() {
        System.out.println("Toyota drives");
    }
}

// STEP 9: Default Methods (Java 8+)
interface Drawable {
    void draw();  // Abstract method
    
    // Default method - has implementation
    default void print() {
        System.out.println("Printing...");
    }
}

class Circle implements Drawable {
    public void draw() {
        System.out.println("Drawing circle");
    }
    // No need to implement print() - uses default
}

public class InterfaceAdvanced {
    public static void main(String[] args) {
        System.out.println("=== ADVANCED INTERFACE CONCEPTS ===\n");
        
        // Multiple interfaces
        Duck duck = new Duck();
        duck.makeSound();
        duck.fly();
        duck.swim();
        
        // Interface inheritance
        Car car = new Toyota();
        car.start();
        car.drive();
        
        // Default methods
        Circle circle = new Circle();
        circle.draw();
        circle.print();  // Uses default implementation
        
        // Constants
        System.out.println("PI = " + MathConstants.PI);
    }
}