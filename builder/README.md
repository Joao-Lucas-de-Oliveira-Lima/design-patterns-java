# Builder Design Pattern

## About the Pattern
The **Builder** design pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations. It is especially useful when objects require complex initialization or when creating objects step by step provides flexibility in the creation process.

- **Type:** Creational

---

## Project Structure
```
builder/
├── src/
│   ├── App.java            # Main application logic
│   ├── enums/              # Enums for order components
│   ├── model/              # Order and Builder classes
└── README.md               # Project documentation
```

---

## Solution
This project demonstrates the Builder pattern in the context of a customizable order system, such as for a restaurant. 

### Builder Class: OrderBuilder
The `OrderBuilder` class defines methods to incrementally construct a complete `Order` object. Each setter method for `Order` returns the `OrderBuilder` entity itself, allowing method chaining.

**Code Example:**
```java
public class OrderBuilder {
    private Order order = new Order();

    private OrderBuilder() {}

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

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

    public Order build() {
        return this.order;
    }
}
```

### Product Class: Order
The `Order` class represents the final product created by the builder. With the use of the builder, there is no need to declare additional constructors besides the default constructor. The builder uses the setter methods of the class to construct the object.

**Code Example:**
```java
public class Order {
    private Snack snack;
    private Drink drink;
    private Condiment condiment;
    private SideDish sideDish;

    protected Order() {}

    public void setSnack(Snack snack) {
        this.snack = snack;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setCondiment(Condiment condiment) {
        this.condiment = condiment;
    }

    public void setSideDish(SideDish sideDish) {
        this.sideDish = sideDish;
    }
}
```
### Main Application
The `App` class demonstrates how to use the Builder pattern. Multiple `Order` objects are created using the `OrderBuilder` class.

**Code Example:**
```java
public class App {
    public static void main(String[] args) throws Exception {
        Order order1 = OrderBuilder.builder()
                .snack(Snack.POPCORN)
                .drink(Drink.SODA)
                .condiment(Condiment.KETCHUP)
                .sideDish(SideDish.FRIES)
                .build();

        Order order2 = OrderBuilder.builder()
                .snack(Snack.CHIPS)
                .drink(Drink.SODA)
                .build();

        Order order3 = OrderBuilder.builder()
                .drink(Drink.SODA)
                .build();
    }
}
```

---

## References
- [Refactoring Guru - Builder Pattern](https://refactoring.guru/design-patterns/builder)
- *Design Patterns: Elements of Reusable Object-Oriented Software*