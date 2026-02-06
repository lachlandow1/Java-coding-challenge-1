# Java Challenge: Declarative Validator
Build a mini-framework that validates objects declaratively using custom annotations and Java Reflection.

## Requirements
- **JDK**: 8+ recommended
- **Libraries**: Standard Library only (`java.lang.reflect`)

## Setup
Compile the project files from the root directory:
```bash
javac src/*.java
```

## Task
Implement a declarative validation system by creating two custom annotations and a `Validator` class.

### 1. Custom Annotations
Implement the following annotations in the `src` directory:
- **`@NotNull`**: Marks a field that cannot be `null`.
- **`@IntegerRange(min, max)`**: Marks an `int` or `Integer` field that must be within the specified inclusive bounds.

### 2. Validator Class
Implement the logic in `src/Validator.java`:
- **Method**: `public static List<String> validate(Object obj)`
- **Logic**: Use Java Reflection to inspect the fields of the provided object.
- **Rules**: 
    - Do not hardcode field names (e.g., `if (obj.username ...)`).
    - The validator must work on any class passed to it, even if you haven't seen it before.

### 3. Example Usage
```java
public class User {
    @NotNull
    private String username;

    @IntegerRange(min=18, max=99)
    private int age;
}

// Execution:
User u = new User(null, 10, "test@example.com");
List<String> errors = Validator.validate(u);

// Expected Output:
// ["Field 'username' cannot be null", "Field 'age' is 10, but must be between 18 and 99"]
```

## Running Tests
To verify your implementation, run the `Main` class:
```bash
java -cp src Main
```
The `Main.java` file contains several test cases for valid users, null fields, and out-of-range values.

## Success Criteria
- **Declarative**: Validation is driven by annotations, not hardcoded logic.
- **Extensible**: The validator works on any object with the supported annotations.
- **Accurate**: Error messages match the expected format exactly.
- **Standard Library**: No external dependencies like Hibernate Validator or Jakarta Validation are used.
