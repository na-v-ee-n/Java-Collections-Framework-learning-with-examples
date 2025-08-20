package com.java.interfaces;

// STEP 1: What is an Interface?
// Interface = Contract/Blueprint that defines WHAT methods a class must have
// It's like a job description - tells what to do, not HOW to do it

interface Animal {
    // Interface methods are abstract by default (no body)
    void makeSound();
    void move();
}

// STEP 2: Implementing Interface
// Class MUST implement ALL interface methods
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
    
    public void move() {
        System.out.println("Dog runs");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
    
    public void move() {
        System.out.println("Cat walks silently");
    }
}

public class InterfaceBasics {
    public static void main(String[] args) {
        System.out.println("=== INTERFACE BASICS ===\n");
        
        // STEP 3: Using Interface as Reference Type
        Animal dog = new Dog();  // Interface reference, Dog object
        Animal cat = new Cat();  // Interface reference, Cat object
        
        dog.makeSound();  // Calls Dog's implementation
        cat.makeSound();  // Calls Cat's implementation
        
        // STEP 4: Polymorphism with Interfaces
        Animal[] animals = {new Dog(), new Cat()};
        
        System.out.println("\nPolymorphism in action:");
        for(Animal animal : animals) {
            animal.makeSound();  // Different behavior for each
            animal.move();
        }
        
        // STEP 5: Why use interfaces?
        makeAnimalSound(dog);  // Can pass any Animal implementation
        makeAnimalSound(cat);
    }
    
    // Method accepts ANY class that implements Animal interface
    public static void makeAnimalSound(Animal animal) {
        System.out.println("Making sound: ");
        animal.makeSound();
    }
}