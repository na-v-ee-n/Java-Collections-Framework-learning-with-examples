package com.java.collections.brushup;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/* COMPARATOR INTERFACE DEFINITION:
 * 
 * COMPARATOR<T> = Functional interface for defining custom sorting logic
 * - compare(T o1, T o2) - main method returning int
 * - Returns: negative (o1 < o2), zero (o1 == o2), positive (o1 > o2)
 * - Enables sorting objects that don't implement Comparable
 * - Allows multiple sorting strategies for same class
 * 
 * COMPARATOR vs COMPARABLE:
 * - Comparable: Natural ordering, implemented by the class itself
 * - Comparator: External sorting logic, separate from the class
 * 
 * STATIC METHODS (Java 8+):
 * - comparing(Function) - Create comparator from key extractor
 * - comparingInt/Long/Double(Function) - For primitive comparisons
 * - naturalOrder() - Natural ordering comparator
 * - reverseOrder() - Reverse natural ordering
 * - nullsFirst/Last(Comparator) - Handle null values
 * 
 * INSTANCE METHODS:
 * - reversed() - Reverse the comparator
 * - thenComparing(Comparator) - Chain comparators
 * - thenComparingInt/Long/Double(Function) - Chain with primitive comparison
 * 
 * USAGE:
 * - Collections.sort(list, comparator)
 * - list.sort(comparator)
 * - Stream.sorted(comparator)
 * - TreeSet/TreeMap constructor
 */

// Sample class for demonstration
class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;
    
    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return String.format("%s(%d, $%.0f, %s)", name, age, salary, department);
    }
}

public class ComparatorInterfaceDemo {
    
    public static void main(String[] args) {
        System.out.println("=== COMPARATOR INTERFACE DEMO ===\n");
        
        List<Employee> employees = createEmployeeList();
        
        demonstrateBasicComparator(new ArrayList<>(employees));
        demonstrateStaticMethods(new ArrayList<>(employees));
        demonstrateChainingComparators(new ArrayList<>(employees));
        demonstrateNullHandling();
        demonstrateWithCollections(new ArrayList<>(employees));
        demonstrateWithStreams(new ArrayList<>(employees));
    }
    
    private static List<Employee> createEmployeeList() {
        return Arrays.asList(
            new Employee("Alice", 30, 75000, "IT"),
            new Employee("Bob", 25, 60000, "HR"),
            new Employee("Charlie", 35, 80000, "IT"),
            new Employee("Diana", 28, 70000, "Finance"),
            new Employee("Eve", 32, 75000, "HR")
        );
    }
    
    public static void demonstrateBasicComparator(List<Employee> employees) {
        System.out.println("1. BASIC COMPARATOR USAGE:");
        System.out.println("Original: " + employees);
        
        // Anonymous class comparator
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });
        System.out.println("Sorted by name (anonymous): " + employees);
        
        // Lambda comparator
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("Sorted by age (lambda): " + employees);
        
        // Method reference comparator
        employees.sort(Comparator.comparing(Employee::getSalary));
        System.out.println("Sorted by salary (method ref): " + employees);
        
        System.out.println();
    }
    
    public static void demonstrateStaticMethods(List<Employee> employees) {
        System.out.println("2. STATIC METHODS:");
        
        // comparing() with method reference
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("By name: " + employees);
        
        // comparingInt() for primitive int
        employees.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println("By age: " + employees);
        
        // comparingDouble() for primitive double
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("By salary: " + employees);
        
        // reverseOrder() - for Comparable objects
        List<String> names = employees.stream()
                .map(Employee::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Names reverse order: " + names);
        
        // naturalOrder() - same as Comparable
        List<Integer> ages = employees.stream()
                .map(Employee::getAge)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("Ages natural order: " + ages);
        
        System.out.println();
    }
    
    public static void demonstrateChainingComparators(List<Employee> employees) {
        System.out.println("3. CHAINING COMPARATORS:");
        
        // First by department, then by salary (descending), then by name
        Comparator<Employee> chainedComparator = Comparator
                .comparing(Employee::getDepartment)
                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
                .thenComparing(Employee::getName);
        
        employees.sort(chainedComparator);
        System.out.println("Dept -> Salary(desc) -> Name: " + employees);
        
        // Alternative chaining syntax
        employees.sort(Comparator
                .comparing(Employee::getAge)
                .thenComparingDouble(Employee::getSalary)
                .thenComparing(Employee::getName));
        System.out.println("Age -> Salary -> Name: " + employees);
        
        // Reversed chaining
        employees.sort(Comparator
                .comparing(Employee::getDepartment)
                .thenComparingInt(Employee::getAge)
                .reversed());
        System.out.println("(Dept -> Age) reversed: " + employees);
        
        System.out.println();
    }
    
    public static void demonstrateNullHandling() {
        System.out.println("4. NULL HANDLING:");
        
        List<String> namesWithNulls = Arrays.asList("Alice", null, "Bob", "Charlie", null);
        System.out.println("Original with nulls: " + namesWithNulls);
        
        // nullsFirst() - nulls come first
        List<String> nullsFirst = new ArrayList<>(namesWithNulls);
        nullsFirst.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("Nulls first: " + nullsFirst);
        
        // nullsLast() - nulls come last
        List<String> nullsLast = new ArrayList<>(namesWithNulls);
        nullsLast.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("Nulls last: " + nullsLast);
        
        // With custom objects
        List<Employee> employeesWithNull = new ArrayList<>();
        employeesWithNull.add(new Employee("Alice", 30, 75000, "IT"));
        employeesWithNull.add(null);
        employeesWithNull.add(new Employee("Bob", 25, 60000, "HR"));
        
        employeesWithNull.sort(Comparator.nullsLast(
                Comparator.comparing(Employee::getName)));
        System.out.println("Employees nulls last: " + employeesWithNull);
        
        System.out.println();
    }
    
    public static void demonstrateWithCollections(List<Employee> employees) {
        System.out.println("5. WITH COLLECTIONS:");
        
        // TreeSet with custom comparator
        Set<Employee> employeesByAge = new TreeSet<>(Comparator.comparingInt(Employee::getAge));
        employeesByAge.addAll(employees);
        System.out.println("TreeSet by age: " + employeesByAge);
        
        // TreeMap with custom comparator
        Map<Employee, String> employeeMap = new TreeMap<>(
                Comparator.comparing(Employee::getName));
        employees.forEach(emp -> employeeMap.put(emp, emp.getDepartment()));
        System.out.println("TreeMap by name: " + employeeMap.keySet());
        
        // PriorityQueue with comparator
        Queue<Employee> salaryQueue = new PriorityQueue<>(
                Comparator.comparingDouble(Employee::getSalary).reversed());
        salaryQueue.addAll(employees);
        
        System.out.print("Priority queue (highest salary first): ");
        while(!salaryQueue.isEmpty()) {
            Employee emp = salaryQueue.poll();
            System.out.print(emp.getName() + "($" + (int)emp.getSalary() + ") ");
        }
        System.out.println("\n");
    }
    
    public static void demonstrateWithStreams(List<Employee> employees) {
        System.out.println("6. WITH STREAMS:");
        
        // Stream sorting
        List<Employee> topEarners = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3 earners: " + topEarners);
        
        // Grouping with sorting
        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        
        // Sort within each department by age
        byDepartment.forEach((dept, empList) -> {
            empList.sort(Comparator.comparingInt(Employee::getAge));
            System.out.println(dept + " (by age): " + empList);
        });
        
        // Finding min/max with comparator
        Optional<Employee> youngest = employees.stream()
                .min(Comparator.comparingInt(Employee::getAge));
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        
        System.out.println("Youngest: " + youngest.orElse(null));
        System.out.println("Highest paid: " + highestPaid.orElse(null));
        
        // Complex sorting in streams
        List<String> departmentsByAvgSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Departments by avg salary: " + departmentsByAvgSalary);
        
        System.out.println();
    }
}