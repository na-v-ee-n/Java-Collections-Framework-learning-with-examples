package com.java.brushup;

/**
 * Enum Best Practices and Advanced Patterns
 */
public class EnumBestPractices {

    // 1. Singleton Pattern with Enum (Best practice)
    enum DatabaseConnection {
        INSTANCE;

        public void connect() {
            System.out.println("Connected to database");
        }
    }

    // 2. Strategy Pattern with Enum
    enum PaymentMethod {
        CREDIT_CARD {
            @Override
            public void processPayment(double amount) {
                System.out.println("Processing $" + amount + " via Credit Card");
            }
        },
        PAYPAL {
            @Override
            public void processPayment(double amount) {
                System.out.println("Processing $" + amount + " via PayPal");
            }
        },
        BANK_TRANSFER {
            @Override
            public void processPayment(double amount) {
                System.out.println("Processing $" + amount + " via Bank Transfer");
            }
        };

        public abstract void processPayment(double amount);
    }

    // 3. Enum with Nested Class
    enum HttpStatus {
        OK(200, "OK"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_ERROR(500, "Internal Server Error");

        private final int code;
        private final String message;

        HttpStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public static class Response {
            private final HttpStatus status;
            private final String body;

            public Response(HttpStatus status, String body) {
                this.status = status;
                this.body = body;
            }

            @Override
            public String toString() {
                return status.code + " " + status.message + ": " + body;
            }
        }

        public Response createResponse(String body) {
            return new Response(this, body);
        }
    }

    // 4. Enum with Utility Methods
    enum FileSize {
        BYTE(1),
        KB(1024),
        MB(1024 * 1024),
        GB(1024 * 1024 * 1024);

        private final long bytes;

        FileSize(long bytes) {
            this.bytes = bytes;
        }

        public long toBytes(long value) {
            return value * bytes;
        }

        public static String formatSize(long bytes) {
            for (FileSize size : values()) {
                if (bytes >= size.bytes) {
                    double value = (double) bytes / size.bytes;
                    return String.format("%.2f %s", value, size.name());
                }
            }
            return bytes + " BYTE";
        }
    }

    public static void main(String[] args) {
        // Singleton pattern
        System.out.println("=== Singleton Pattern ===");
        DatabaseConnection.INSTANCE.connect();

        // Strategy pattern
        System.out.println("\n=== Strategy Pattern ===");
        PaymentMethod[] methods = PaymentMethod.values();
        for (PaymentMethod method : methods) {
            method.processPayment(100.0);
        }

        // Nested class usage
        System.out.println("\n=== Nested Class Pattern ===");
        HttpStatus.Response response = HttpStatus.OK.createResponse("Success");
        System.out.println(response);

        // Utility methods
        System.out.println("\n=== Utility Methods ===");
        System.out.println("1 GB = " + FileSize.GB.toBytes(1) + " bytes");
        System.out.println("File size: " + FileSize.formatSize(2048576));

        // Best practices summary
        System.out.println("\n=== Best Practices ===");
        System.out.println("1. Use enum for Singleton (thread-safe, serialization-safe)");
        System.out.println("2. Implement Strategy pattern with abstract methods");
        System.out.println("3. Use EnumSet/EnumMap for better performance");
        System.out.println("4. Add utility methods for common operations");
        System.out.println("5. Use nested classes for complex data structures");
    }
}