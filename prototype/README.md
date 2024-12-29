# Prototype Design Pattern

## About the Pattern
The **Prototype** design pattern allows for creating new objects by cloning an existing object, referred to as the prototype. This approach is especially useful when object creation is computationally expensive or when you need to generate objects with similar attributes but slight variations.

- **Type:** Creational

---

## Project Structure
```
prototype/
├── src/
│   ├── App.java               # Main application logic
│   └── model/
│       ├── ChessPiece.java    # Abstract class for chess pieces
│       └── Pawn.java          # Concrete implementation using Prototype
└── README.md                  # Documentation
```

---

## Solution
This project demonstrates the Prototype pattern using chess piece objects. The pattern simplifies the creation of chess pieces by allowing them to be cloned, rather than instantiating new objects from scratch.

### Abstract Class: ChessPiece
The `ChessPiece` class serves as the base class for all chess pieces. It defines shared attributes, such as `color` and `currentPosition`, and requires subclasses to implement the `clone` method. A protected constructor is used to initialize a new object by copying attributes from an existing instance.

**Code Example:**
```java
public abstract class ChessPiece {
    private String color;
    private String currentPosition;

    protected ChessPiece() {}

    protected ChessPiece(ChessPiece target) {
        this.color = target.color;
        this.currentPosition = target.currentPosition;
    }

    public abstract ChessPiece clone(String newPosition);
}
```

### Concrete Class: Pawn
The `Pawn` class extends `ChessPiece` and provides specific functionality for pawn pieces. It allows objects to be created either through the default constructor or by cloning an existing `Pawn` instance using the `clone` method.

**Code Example:**
```java
public class Pawn extends ChessPiece {
    private boolean promotion;

    public Pawn() {}

    protected Pawn(Pawn target) {
        super(target);
        this.promotion = target.promotion;
    }

    @Override
    public ChessPiece clone(String newPosition) {
        Pawn clone = new Pawn(this);
        clone.setCurrentPosition(newPosition);
        return clone;
    }
}
```

### Main Application
The `App` class demonstrates how to use the Prototype pattern. A `Pawn` object is created, and then a clone is made with a new position. All attributes of the original pawn are copied to the cloned instance.

**Code Example:**
```java
public class App {
    public static void main(String[] args) {
        Pawn pawn = new Pawn();
        pawn.setColor("White");
        pawn.setCurrentPosition("A2");

        Pawn clonedPawn = (Pawn) pawn.clone("A3");

        System.out.println(clonedPawn);
    }
}
```

---

## References
- [Refactoring Guru - Prototype Pattern](https://refactoring.guru/design-patterns/prototype)
- *Design Patterns: Elements of Reusable Object-Oriented Software*

