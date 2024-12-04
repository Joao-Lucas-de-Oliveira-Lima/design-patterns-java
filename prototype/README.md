# Prototype Pattern

 Prototype Pattern

## Description
- Type of Pattern: Creational

The Prototype pattern is used to create a new object by copying an existing object, known as the prototype. This pattern is useful when the cost of creating a new object is expensive or complex. It allows for the creation of new objects without knowing the exact class of the object that will be created.

## Implementation

The `ChessPiece` class represents a generic chess piece with attributes such as color, current position, point value, and alive status. The `Pawn` class extends `ChessPiece` and adds additional attributes such as promotion and first move bonus. The `Pawn` class features a **protected constructor** to restrict direct instantiation. This design ensures that objects are created either through the `clone` method or via a default no-argument constructor.

The `clone` method in the `Pawn` class creates a new instance of `Pawn` by copying the attributes of the existing `Pawn` object. This allows for the creation of new `Pawn` objects without directly instantiating them.

### ChessPiece.java
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

    // Additional methods
}
```

### Pawn.java
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

    // Additional methods
}
```

### App.java
```java
import model.Pawn;

public class App {
    public static void main(String[] args) throws Exception {
        // Pawn created empty and then set
        Pawn pawn = new Pawn();
        pawn.setAlive(true);
        pawn.setColor("White");
        pawn.setCurrentPosition("A2");
        pawn.setPointValue(1);
        pawn.setPromotion(false);
        pawn.setFirstMoveBonus(true);

        // Pawn cloned using the prototype pattern
        Pawn pawnClone = (Pawn) pawn.clone("A3");

        System.out.println(pawnClone.toString());

        /*
         * output:
         * Color: White
         * Current Position: A3
         * Point Value: 1
         * Alive: true
         * Promotion: false
         * First Move Bonus: true
         */
    }
}
```
