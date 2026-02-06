import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting Partial Validation Tests ---");

        // Test Case 1: Valid User
        System.out.println("\nTest Case 1: Valid User (Name, Age 25, Email)");
        validateAndPrint(new User("JohnDoe", 25, "john@example.com"));

        // Test Case 2: Invalid User (Null Name)
        System.out.println("\nTest Case 2: Invalid User (Null Name)");
        validateAndPrint(new User(null, 25, "john@example.com"));

        // Test Case 3: Invalid Age - Too Young (17)
        System.out.println("\nTest Case 3: Invalid Age (17)");
        validateAndPrint(new User("Underage", 17, "test@example.com"));

        // Test Case 4: Invalid Age - Too Old (100)
        System.out.println("\nTest Case 4: Invalid Age (100)");
        validateAndPrint(new User("Overage", 100, "test@example.com"));

        // Test Case 5: Edge Case - Minimum Valid Age (18)
        System.out.println("\nTest Case 5: Edge Case Age (18)");
        validateAndPrint(new User("MinAge", 18, "test@example.com"));

        // Test Case 6: Edge Case - Maximum Valid Age (99)
        System.out.println("\nTest Case 6: Edge Case Age (99)");
        validateAndPrint(new User("MaxAge", 99, "test@example.com"));
        
        System.out.println("\n--- Tests Completed ---");
    }

    private static void validateAndPrint(User user) {
        List<String> errors = Validator.validate(user);
        if (errors.isEmpty()) {
            System.out.println("Result: VALID");
        } else {
            System.out.println("Result: INVALID (" + errors.size() + " errors)");
            for (String error : errors) {
                System.out.println(" - " + error);
            }
        }
    }
}
