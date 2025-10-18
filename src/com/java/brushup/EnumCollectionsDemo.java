package com.java.brushup;

import java.util.*;

/**
 * Enum with Collections Framework
 * Demonstrates EnumSet and EnumMap usage
 */
public class EnumCollectionsDemo {

    enum Color {
        RED, GREEN, BLUE, YELLOW, ORANGE, PURPLE
    }

    enum Priority {
        LOW(1), MEDIUM(5), HIGH(10), CRITICAL(20);

        private final int value;

        Priority(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // EnumSet - High performance Set implementation for enums
        System.out.println("=== EnumSet Examples ===");

        // Create EnumSet with specific values
        EnumSet<Color> primaryColors = EnumSet.of(Color.RED, Color.GREEN, Color.BLUE);
        System.out.println("Primary colors: " + primaryColors);

        // Create EnumSet with all values
        EnumSet<Color> allColors = EnumSet.allOf(Color.class);
        System.out.println("All colors: " + allColors);

        // Create EnumSet with range
        EnumSet<Color> warmColors = EnumSet.range(Color.RED, Color.ORANGE);
        System.out.println("Warm colors: " + warmColors);

        // Complement set
        EnumSet<Color> coolColors = EnumSet.complementOf(warmColors);
        System.out.println("Cool colors: " + coolColors);

        // EnumSet operations
        EnumSet<Color> mixedColors = EnumSet.copyOf(primaryColors);
        mixedColors.add(Color.YELLOW);
        System.out.println("Mixed colors: " + mixedColors);

        // EnumMap - High performance Map implementation for enum keys
        System.out.println("\n=== EnumMap Examples ===");

        EnumMap<Priority, String> taskMap = new EnumMap<>(Priority.class);
        taskMap.put(Priority.HIGH, "Fix critical bug");
        taskMap.put(Priority.MEDIUM, "Code review");
        taskMap.put(Priority.LOW, "Update documentation");
        taskMap.put(Priority.CRITICAL, "Server down");

        System.out.println("Task priorities:");
        for (Map.Entry<Priority, String> entry : taskMap.entrySet()) {
            System.out.printf("%s (%d): %s%n", 
                entry.getKey(), 
                entry.getKey().getValue(), 
                entry.getValue());
        }

        // EnumMap with collections as values
        EnumMap<Color, List<String>> colorItems = new EnumMap<>(Color.class);
        colorItems.put(Color.RED, Arrays.asList("Apple", "Rose", "Fire"));
        colorItems.put(Color.BLUE, Arrays.asList("Sky", "Ocean", "Blueberry"));
        colorItems.put(Color.GREEN, Arrays.asList("Grass", "Tree", "Emerald"));

        System.out.println("\nColor associations:");
        colorItems.forEach((color, items) -> 
            System.out.println(color + ": " + items));

        // Performance comparison
        System.out.println("\n=== Performance Benefits ===");
        System.out.println("EnumSet: Bit vector implementation - O(1) operations");
        System.out.println("EnumMap: Array-based implementation - O(1) operations");
        System.out.println("Both are faster than HashSet/HashMap for enums");
    }
}