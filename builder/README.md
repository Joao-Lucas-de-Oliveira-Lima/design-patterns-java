# Builder Pattern

## 📚 References

- [Refactoring Guru - Builder Pattern](https://refactoring.guru/design-patterns/builder)
- Design Patterns: Elements of Reusable Object-Oriented Software

---

## 📖 Description

The **Builder Pattern** is a creational design pattern that constructs a complex object step by step. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations. This pattern is useful when the object to be created has multiple optional parameters.

- **Category:** Creational Pattern  
- **Intent:** Separate the construction of a complex object from its representation so that the same construction process can create different representations.

---

## 🔧 Problem

Creating complex objects directly within a constructor or using a telescoping constructor pattern can lead to code that is difficult to read and maintain.

---

## 💡 Solution

The **Builder Pattern** suggests defining a separate builder object that encapsulates the construction of a complex object. The builder provides a fluent interface for configuring the object step by step.

- **Advantages:**
  - Simplifies the creation of complex objects.
  - Provides a clear and fluent interface for object construction.
  - Allows different representations of the constructed object.

---

## 🛠 Structure

1. **Order:** Represents the complex object being built, containing optional components like `snack`, `drink`, `condiment`, and `sideDish`.
2. **OrderBuilder:** Provides a interface for building an `Order` object step by step.
3. **App:** Demonstrates the usage of `OrderBuilder` to construct `Order` objects with different configurations.

---

## 📋 Implementation

### `Order.java`
Represents a food order, which can include optional components such as a snack, drink, condiment, and side dish.
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
### `OrderBuilder.java`
```java
package model;

// Imports

public class OrderBuilder {
    private Order order = new Order();

    private OrderBuilder() {}

    public static OrderBuilder builder() {
        return new OrderBuilder();

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

### `App.java`
```java
// Imports

public class App {
    public static void main(String[] args) {

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

