# Prototype

## About the Pattern
The **Prototype** design pattern allows for creating new objects by cloning an existing object, referred to as the prototype.

## Implementation

### ChessPiece (Abstract Class)
`ChessPiece` is an abstract class and cannot be instantiated directly. It serves as a superclass for specific chess pieces. Its default constructor is protected, meaning only classes within the same package or subclasses can invoke it. Additionally, a second protected constructor accepts an instance of `ChessPiece`, allowing attributes to be copied from the provided object.

The `clone` method is abstract and must be overridden by subclasses. This method is responsible for cloning the object and should return an instance of `ChessPiece`.

```java
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

    public abstract ChessPiece clone(String currentPosition);

    // Other methods like getters and setters
}
```

### Pawn (Concrete Implementation)
The `Pawn` class overrides the `clone` method. This method calls the `Pawn` constructor, passing itself as an argument to enable attribute copying. The constructor of `Pawn` assigns specific attributes and invokes the superclass constructor using `super()`. Since `Pawn` is a subclass, upcasting occurs automatically.

The returned object is a clone of the original, with the exception of the `currentPosition` attribute. This attribute is explicitly set after cloning to ensure that the new piece has a different position on the chessboard. The default constructor is public, as an original object must first be created before clones can be generated and assigned values using setter methods.

```java
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

    // Other methods like getters and setters
}
```

### Object Creation Using the Default Constructor and Clone Method
The object can be instantiated using the default constructor and then cloned using the `clone` method. Since the `clone` method is defined in the abstract class `ChessPiece`, it returns a `ChessPiece` type. Therefore, explicit downcasting is required when assigning the cloned object to a `Pawn` variable.

```java
Pawn pawn = new Pawn();
pawn.setAlive(true);
pawn.setColor("White");
pawn.setCurrentPosition("A2");
pawn.setPointValue(1);
pawn.setPromotion(false);
pawn.setFirstMoveBonus(true);

Pawn pawnClone = (Pawn) pawn.clone("A3");
```