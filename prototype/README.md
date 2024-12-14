# Prototype Pattern

## 📚 References

- [Refactoring Guru - Prototype Pattern](https://refactoring.guru/design-patterns/prototype)
- Design Patterns: Elements of Reusable Object-Oriented Software

---

## 📖 Description

The **Prototype Pattern** is a creational design pattern that enables the creation of new objects by copying an existing prototype. This is useful when creating an object is costly or complex.

- **Category:** Creational Pattern  
- **Intent:** Facilitate object creation without depending on their concrete classes, using cloning as an alternative to direct instantiation.

---

## 🔧 Problem

Creating an exact copy of an object manually can be unmanageable for complex objects and tightly couples the code to the concrete class.

---

## 💡 Solution

The **Prototype Pattern** delegates the cloning process to the object itself using a `clone` method, removing the client’s dependency on the concrete class.

- **Advantages:**
  - Copies complex objects without coupling the client code.
  - Enables creating pre-configured prototypes for reuse.

---

## 🛠 Structure

1. **Abstract Class ChessPiece:** Declares the `clone` method.
2. **Concrete Prototype Pawn:** Implements the `clone` method to create full copies of the object.

---

## 📋 Implementation

### `ChessPiece.java`
Represents a generic chess piece with attributes like color, position, point value, and life status.

```java
package model;

public abstract class ChessPiece {
    private String color;
    private String currentPosition;
    private Integer pointValue;
    private Boolean alive;

    protected ChessPiece() {}

    protected ChessPiece(ChessPiece target) {
        if (target != null) {
            this.color = target.color;
            this.currentPosition = target.currentPosition;
            this.pointValue = target.pointValue;
            this.alive = target.alive;
        }
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public abstract ChessPiece clone(String currentPosition);

    public String toString() {
        return "Color: " + this.color + "\n" +
               "Current Position: " + this.currentPosition + "\n" +
               "Point Value: " + this.pointValue + "\n" +
               "Alive: " + this.alive + "\n";
    }
}
```

### `Pawn.java`
The `Pawn` class extends `ChessPiece` and implements the `clone` method, ensuring that new pawns are created by copying an existing prototype.

```java
package model;

public class Pawn extends ChessPiece {
    private Boolean promotion;
    private Boolean firstMoveBonus;

    public Pawn() {}

    protected Pawn(Pawn target) {
        super(target);
        if (target != null) {
            this.promotion = target.promotion;
            this.firstMoveBonus = target.firstMoveBonus;
        }
    }

    @Override
    public ChessPiece clone(String currentPosition) {
        Pawn pawnClone = new Pawn(this);
        pawnClone.setCurrentPosition(currentPosition);
        return pawnClone;
    }

    public String toString() {
        return super.toString() +
               "Promotion: " + this.promotion + "\n" +
               "First Move Bonus: " + this.firstMoveBonus + "\n";
    }
}
```

### `App.java`
An example of using the Prototype Pattern to clone a `Pawn` object.

```java
import model.Pawn;

public class App {
    public static void main(String[] args) {
        Pawn pawn = new Pawn();
        pawn.setAlive(true);
        pawn.setColor("White");
        pawn.setCurrentPosition("A2");
        pawn.setPointValue(1);
        pawn.setPromotion(false);
        pawn.setFirstMoveBonus(true);

        // Cloning the pawn with a new position
        Pawn pawnClone = (Pawn) pawn.clone("A3");

        System.out.println(pawnClone.toString());
    }
}
```

