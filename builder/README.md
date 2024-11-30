# Builder Pattern

## Description
- Type of Pattern: Creational

The Builder pattern is used to construct a complex object step by step. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations. This pattern is useful when the object to be created has multiple optional parameters.
## Implementation

The `Order` class represents a food order, which can include optional components such as a snack, drink, condiment, and side dish. The `Order` class uses a **protected constructor**, ensuring that objects can only be instantiated through the `OrderBuilder`.
The `OrderBuilder` class has a private constructor and a static method called `builder`, which returns a new instance of `OrderBuilder`. Each method in the builder, which accepts an argument, corresponds to a setter in the `Order` class and returns the builder instance itself, enabling **method chaining**. Once all attributes are set, the `build()` method can be called to return the fully constructed `Order` object.


### Order.java
```java
package model;

// Imports

public class Order {
    private Snack snack;
    private Drink drink;
    private Condiment condiment;
    private SideDish sideDish;

    // Protected constructor to prevent direct instantiation
    protected Order() {}

    public void setSnack(Snack snack) { this.snack = snack; }

    public void setDrink(Drink drink) { this.drink = drink; }

    public void setCondiment(Condiment condiment) { this.condiment = condiment; }

    public void setSideDish(SideDish sideDish) { this.sideDish = sideDish; }

    // Additional methods
}
```
### OrderBuilder.java
```java
package model;

// Imports

public class OrderBuilder {
    private Order order = new Order();

    // Private constructor to prevent direct instantiation
    private OrderBuilder() {}

    // Static method to start the builder process
    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    // Builder methods for setting attributes
    public OrderBuilder snack(Snack snack) {
        order.setSnack(snack);
        return this;
    }

    public OrderBuilder drink(Drink drink) {
        order.setDrink(drink);
        return this;
    }

    public OrderBuilder condiment(Condiment condiment) {
        order.setCondiment(condiment);
        return this;
    }

    public OrderBuilder sideDish(SideDish sideDish) {
        order.setSideDish(sideDish);
        return this;
    }

    // Method to build the final Order object
    public Order build() {
        return this.order;
    }
}
```

### App.java
```java
// Imports

public class App {
    public static void main(String[] args) {
        // Different ways to create an Order object

        // Order with all components
        Order order01 = OrderBuilder.builder()
                .snack(Snack.POPCORN)
                .drink(Drink.SODA)
                .condiment(Condiment.KETCHUP)
                .sideDish(SideDish.FRIES)
                .build();

        // Order with snack and drink only
        Order order02 = OrderBuilder.builder()
                .snack(Snack.CHIPS)
                .drink(Drink.SODA)
                .build();

        // Order with only drink
        Order order03 = OrderBuilder.builder()
                .drink(Drink.SODA)
                .build();
    }
}

```