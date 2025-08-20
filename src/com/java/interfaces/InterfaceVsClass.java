package com.java.interfaces;

// INTERFACE VS CLASS - Key Differences

/* DEFINITIONS:
 * ABSTRACT CLASS = A class declared with 'abstract' keyword that cannot be instantiated directly.
 *                  It provides partial implementation - can have both concrete and abstract methods.
 *                  Purpose: Share common code among related classes while forcing specific method implementations.
 *
 * ABSTRACT METHOD = A method declared with 'abstract' keyword that has NO implementation (no body).
 *                   It must be implemented by any non-abstract subclass.
 *                   Syntax: abstract returnType methodName();
 */

// Abstract Class Example
abstract class Shape {
    protected String color;  // Can have instance variables
    
    // Constructor
    public Shape(String color) {
        this.color = color;
    }
    
    // Concrete method
    public void setColor(String color) {
        this.color = color;
    }
    
    // Abstract method - declared without implementation, must be implemented by subclasses
    abstract double getArea();
}

/* INTERFACE DEFINITION:
 * INTERFACE = A contract/blueprint that defines WHAT methods a class must have.
 *             It's 100% abstract (except default/static methods in Java 8+).
 *             Purpose: Define common behavior that multiple unrelated classes can implement.
 */

// Interface Example  
interface Printable {
    // No instance variables (only constants)
    String FORMAT = "PDF";  // public static final
    
    // No constructors allowed
    
    // Abstract method
    void print();
    
    // Default method (Java 8+)
    default void preview() {
        System.out.println("Previewing document");
    }
}

// Class implementing both
class Rectangle extends Shape implements Printable {
    private double width, height;
    
    public Rectangle(String color, double width, double height) {
        super(color);  // Call parent constructor
        this.width = width;
        this.height = height;
    }
    
    // Implement abstract method from Shape
    public double getArea() {
        return width * height;
    }
    
    // Implement interface method
    public void print() {
        System.out.println("Printing rectangle in " + color);
    }
}

public class InterfaceVsClass {
    public static void main(String[] args) {
        System.out.println("=== INTERFACE VS CLASS ===\n");
        
        Rectangle rect = new Rectangle("Red", 5, 3);
        
        // From abstract class
        System.out.println("Area: " + rect.getArea());
        rect.setColor("Blue");
        
        // From interface
        rect.print();
        rect.preview();  // Default method
        
        System.out.println("\n=== KEY DIFFERENCES ===");
        printDifferences();
    }
    
    public static void printDifferences() {
        System.out.println("INTERFACE:");
        System.out.println("- Contract/Blueprint only");
        System.out.println("- All methods abstract (except default/static)");
        System.out.println("- No instance variables");
        System.out.println("- No constructors");
        System.out.println("- Multiple inheritance allowed");
        System.out.println("- 100% abstraction");
        
        System.out.println("\nABSTRACT CLASS:");
        System.out.println("- Partial implementation");
        System.out.println("- Can have concrete + abstract methods");
        System.out.println("- Can have instance variables");
        System.out.println("- Can have constructors");
        System.out.println("- Single inheritance only");
        System.out.println("- 0-100% abstraction");
        
        System.out.println("\nCONCRETE CLASS:");
        System.out.println("- Complete implementation");
        System.out.println("- All methods have body");
        System.out.println("- Can be instantiated directly");
        System.out.println("- 0% abstraction");
    }
}