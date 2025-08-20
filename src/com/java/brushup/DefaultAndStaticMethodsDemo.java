package com.java.brushup;

import java.util.*;

/* DEFAULT AND STATIC METHODS IN INTERFACES:
 * 
 * DEFAULT METHODS:
 * - Methods with implementation in interface (Java 8+)
 * - Use 'default' keyword
 * - Implementing classes get them "for free"
 * - Can be overridden (optional)
 * - Solve backward compatibility problem
 * 
 * STATIC METHODS:
 * - Belong to interface, not instances
 * - Called using InterfaceName.methodName()
 * - Cannot be overridden
 * - Provide utility functions related to interface
 * - Help organize related functionality
 * 
 * BENEFITS:
 * - Backward compatibility
 * - Code reuse
 * - Interface evolution
 * - Utility methods organization
 */

// Interface with default and static methods
interface PaymentProcessor {
    // Abstract method - must be implemented
    boolean processPayment(double amount);
    
    // DEFAULT METHODS - optional to override
    default void logTransaction(double amount) {
        System.out.println("Transaction logged: $" + amount);
    }
    
    default String formatAmount(double amount) {
        return String.format("$%.2f", amount);
    }
    
    default void sendConfirmation(double amount) {
        System.out.println("Payment confirmation sent for " + formatAmount(amount));
        logTransaction(amount);
    }
    
    default boolean validateAmount(double amount) {
        return amount > 0 && amount <= 10000;
    }
    
    // STATIC METHODS - utility functions
    static PaymentProcessor createCreditCardProcessor() {
        return new CreditCardProcessor();
    }
    
    static PaymentProcessor createPayPalProcessor() {
        return new PayPalProcessor();
    }
    
    static void displaySupportedMethods() {
        System.out.println("Supported payment methods:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Bank Transfer");
    }
    
    static double calculateFee(double amount, String method) {
        switch(method.toLowerCase()) {
            case "credit": return amount * 0.03;
            case "paypal": return amount * 0.025;
            case "bank": return 2.50;
            default: return 0.0;
        }
    }
}

// Implementation 1 - Uses all default methods
class CreditCardProcessor implements PaymentProcessor {
    private String cardNumber;
    
    public CreditCardProcessor() {
        this.cardNumber = "****-****-****-1234";
    }
    
    @Override
    public boolean processPayment(double amount) {
        if(!validateAmount(amount)) {
            System.out.println("Invalid amount for credit card");
            return false;
        }
        System.out.println("Processing credit card payment: " + formatAmount(amount));
        return true;
    }
    
    // Uses default methods as-is: logTransaction, formatAmount, sendConfirmation, validateAmount
}

// Implementation 2 - Overrides some default methods
class PayPalProcessor implements PaymentProcessor {
    private String email;
    
    public PayPalProcessor() {
        this.email = "user@example.com";
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment: " + formatAmount(amount));
        return true;
    }
    
    // Override default method for custom behavior
    @Override
    public void logTransaction(double amount) {
        System.out.println("PayPal transaction logged: " + formatAmount(amount) + " to " + email);
    }
    
    // Override validation for different limits
    @Override
    public boolean validateAmount(double amount) {
        return amount > 0 && amount <= 5000; // Lower limit for PayPal
    }
    
    // Uses default methods: formatAmount, sendConfirmation
}

// Implementation 3 - Overrides most default methods
class BankTransferProcessor implements PaymentProcessor {
    private String accountNumber;
    
    public BankTransferProcessor() {
        this.accountNumber = "ACC-123456789";
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing bank transfer: " + formatAmount(amount));
        return true;
    }
    
    // Custom formatting for bank transfers
    @Override
    public String formatAmount(double amount) {
        return String.format("USD %.2f", amount);
    }
    
    // Custom logging
    @Override
    public void logTransaction(double amount) {
        System.out.println("Bank transfer logged: " + formatAmount(amount) + " from " + accountNumber);
    }
    
    // Custom confirmation
    @Override
    public void sendConfirmation(double amount) {
        System.out.println("Bank transfer confirmation: " + formatAmount(amount));
        System.out.println("Transfer will complete in 1-3 business days");
        logTransaction(amount);
    }
}

public class DefaultAndStaticMethodsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== DEFAULT AND STATIC METHODS DEMO ===\n");
        
        demonstrateStaticMethods();
        demonstrateDefaultMethods();
        demonstrateMethodOverriding();
        demonstratePolymorphism();
    }
    
    public static void demonstrateStaticMethods() {
        System.out.println("1. STATIC METHODS:");
        
        // Call static methods directly on interface
        PaymentProcessor.displaySupportedMethods();
        
        // Static factory methods
        PaymentProcessor creditCard = PaymentProcessor.createCreditCardProcessor();
        PaymentProcessor paypal = PaymentProcessor.createPayPalProcessor();
        
        System.out.println("Credit card processor: " + creditCard.getClass().getSimpleName());
        System.out.println("PayPal processor: " + paypal.getClass().getSimpleName());
        
        // Static utility methods
        double amount = 100.0;
        System.out.println("Credit card fee: $" + PaymentProcessor.calculateFee(amount, "credit"));
        System.out.println("PayPal fee: $" + PaymentProcessor.calculateFee(amount, "paypal"));
        System.out.println("Bank fee: $" + PaymentProcessor.calculateFee(amount, "bank"));
        
        System.out.println();
    }
    
    public static void demonstrateDefaultMethods() {
        System.out.println("2. DEFAULT METHODS:");
        
        PaymentProcessor processor = new CreditCardProcessor();
        double amount = 250.75;
        
        // Using default methods
        System.out.println("Formatted amount: " + processor.formatAmount(amount));
        System.out.println("Is valid amount: " + processor.validateAmount(amount));
        
        processor.logTransaction(amount);
        processor.sendConfirmation(amount);
        
        System.out.println();
    }
    
    public static void demonstrateMethodOverriding() {
        System.out.println("3. METHOD OVERRIDING:");
        
        List<PaymentProcessor> processors = Arrays.asList(
            new CreditCardProcessor(),
            new PayPalProcessor(),
            new BankTransferProcessor()
        );
        
        double amount = 150.0;
        
        for(PaymentProcessor processor : processors) {
            System.out.println("--- " + processor.getClass().getSimpleName() + " ---");
            
            // Same method calls, different behavior based on overrides
            System.out.println("Formatted: " + processor.formatAmount(amount));
            System.out.println("Valid: " + processor.validateAmount(amount));
            processor.logTransaction(amount);
            processor.sendConfirmation(amount);
            
            System.out.println();
        }
    }
    
    public static void demonstratePolymorphism() {
        System.out.println("4. POLYMORPHISM WITH DEFAULT METHODS:");
        
        // Process payments with different processors
        List<PaymentProcessor> processors = Arrays.asList(
            PaymentProcessor.createCreditCardProcessor(),
            PaymentProcessor.createPayPalProcessor(),
            new BankTransferProcessor()
        );
        
        double[] amounts = {50.0, 1500.0, 7500.0};
        
        for(double amount : amounts) {
            System.out.println("Processing amount: " + amount);
            
            for(PaymentProcessor processor : processors) {
                String processorType = processor.getClass().getSimpleName();
                
                if(processor.validateAmount(amount)) {
                    if(processor.processPayment(amount)) {
                        processor.sendConfirmation(amount);
                    }
                } else {
                    System.out.println(processorType + ": Amount validation failed");
                }
                System.out.println();
            }
            System.out.println("---");
        }
    }
}