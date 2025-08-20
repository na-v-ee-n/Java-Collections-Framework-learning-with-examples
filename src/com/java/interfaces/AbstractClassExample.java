package com.java.interfaces;

// ABSTRACT CLASS TUTORIAL

// Abstract Class - Cannot be instantiated
abstract class Vehicle {
    // Instance variables allowed
    protected String brand;
    protected int year;
    
    // Constructor allowed
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    // Concrete method - has implementation
    public void displayInfo() {
        System.out.println(year + " " + brand);
    }
    
    // Abstract method - NO implementation
    abstract void start();
    abstract void stop();
    abstract double getFuelEfficiency();
}

// Concrete class MUST implement ALL abstract methods
class Car extends Vehicle {
    private String fuelType;
    
    public Car(String brand, int year, String fuelType) {
        super(brand, year);  // Call parent constructor
        this.fuelType = fuelType;
    }
    
    // MUST implement abstract methods
    void start() {
        System.out.println("Car engine starts with key");
    }
    
    void stop() {
        System.out.println("Car stops with brake pedal");
    }
    
    double getFuelEfficiency() {
        return 25.5;  // miles per gallon
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String brand, int year) {
        super(brand, year);
    }
    
    // MUST implement abstract methods
    void start() {
        System.out.println("Motorcycle starts with kick/button");
    }
    
    void stop() {
        System.out.println("Motorcycle stops with hand brake");
    }
    
    double getFuelEfficiency() {
        return 45.0;  // Better efficiency
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        System.out.println("=== ABSTRACT CLASS EXAMPLE ===\n");
        
        // Vehicle vehicle = new Vehicle("Toyota", 2020);  // ERROR! Cannot instantiate abstract class
        
        // Can create concrete subclass objects
        Car car = new Car("Toyota", 2020, "Gasoline");
        Motorcycle bike = new Motorcycle("Honda", 2021);
        
        // Use inherited concrete method
        car.displayInfo();
        bike.displayInfo();
        
        // Use implemented abstract methods
        car.start();
        System.out.println("Efficiency: " + car.getFuelEfficiency() + " mpg");
        
        bike.start();
        System.out.println("Efficiency: " + bike.getFuelEfficiency() + " mpg");
        
        // Polymorphism with abstract class
        Vehicle[] vehicles = {car, bike};
        
        System.out.println("\nPolymorphism:");
        for(Vehicle v : vehicles) {
            v.displayInfo();
            v.start();  // Different implementation for each
        }
        
        explainAbstractConcepts();
    }
    
    public static void explainAbstractConcepts() {
        System.out.println("\n=== ABSTRACT CLASS RULES ===");
        System.out.println("1. Cannot be instantiated directly");
        System.out.println("2. Can have constructors");
        System.out.println("3. Can have instance variables");
        System.out.println("4. Can have concrete methods (with body)");
        System.out.println("5. Can have abstract methods (without body)");
        System.out.println("6. Subclass MUST implement ALL abstract methods");
        System.out.println("7. If subclass doesn't implement abstract methods, it must also be abstract");
        
        System.out.println("\n=== ABSTRACT METHOD RULES ===");
        System.out.println("1. Declared with 'abstract' keyword");
        System.out.println("2. No method body (no curly braces)");
        System.out.println("3. Ends with semicolon");
        System.out.println("4. Must be in abstract class or interface");
        System.out.println("5. Cannot be private, static, or final");
    }
}