package com.java.brushup;

/**
 * Comprehensive Enum Demonstration
 * Covers: Basic enums, methods, constructors, abstract methods, EnumSet, EnumMap
 */
public class EnumDemo {

    // 1. Basic Enum
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // 2. Enum with Fields and Constructor
    enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.37814e6),
        MARS(6.421e+23, 3.3972e6);

        private final double mass;
        private final double radius;

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        public double surfaceGravity() {
            return 6.67300E-11 * mass / (radius * radius);
        }
    }

    // 3. Enum with Abstract Methods
    enum Operation {
        PLUS("+") {
            public double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
            public double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
            public double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
            public double apply(double x, double y) { return x / y; }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public abstract double apply(double x, double y);

        @Override
        public String toString() {
            return symbol;
        }
    }

    // 4. Enum Implementing Interface
    interface Describable {
        String getDescription();
    }

    enum Status implements Describable {
        ACTIVE("Currently active"),
        INACTIVE("Not active"),
        PENDING("Waiting for approval");

        private final String description;

        Status(String description) {
            this.description = description;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    public static void main(String[] args) {
        // Basic enum usage
        Day today = Day.FRIDAY;
        System.out.println("Today is: " + today);
        System.out.println("Ordinal: " + today.ordinal());

        // Enum methods
        System.out.println("\nAll days:");
        for (Day day : Day.values()) {
            System.out.println(day + " (ordinal: " + day.ordinal() + ")");
        }

        // valueOf method
        Day parsedDay = Day.valueOf("MONDAY");
        System.out.println("\nParsed day: " + parsedDay);

        // Switch with enum
        switch (today) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("It's a weekday");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("It's weekend!");
                break;
        }

        // Enum with constructor and methods
        System.out.println("\nPlanet surface gravity:");
        for (Planet p : Planet.values()) {
            System.out.printf("%s: %.2f m/s²%n", p, p.surfaceGravity());
        }

        // Abstract methods in enum
        System.out.println("\nOperations:");
        double x = 10, y = 5;
        for (Operation op : Operation.values()) {
            System.out.printf("%.0f %s %.0f = %.2f%n", x, op, y, op.apply(x, y));
        }

        // Enum implementing interface
        System.out.println("\nStatus descriptions:");
        for (Status status : Status.values()) {
            System.out.println(status + ": " + status.getDescription());
        }

        // Comparison
        System.out.println("\nComparisons:");
        System.out.println("MONDAY == MONDAY: " + (Day.MONDAY == Day.MONDAY));
        System.out.println("MONDAY.equals(MONDAY): " + Day.MONDAY.equals(Day.MONDAY));
        System.out.println("MONDAY.compareTo(FRIDAY): " + Day.MONDAY.compareTo(Day.FRIDAY));
    }
}