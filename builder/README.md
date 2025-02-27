# Builder

## About the Pattern

The **Builder** design pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

## Implementation

### Order

The `Order` object represents an order. The default constructor is protected, meaning it can only be used by subclasses or classes within the same package.

```java
public class Order {
    private Snack snack;
    private Drink drink;
    private Condiment condiment;
    private SideDish sideDish;

    protected Order() {}

    // Other methods such as setters and getters
}
```

### OrderBuilder

Each `OrderBuilder` object has its own instance of an `Order`, since the `order` attribute is instantiated whenever a new `OrderBuilder` is created. The static method `builder` returns a new instance of `OrderBuilder`. Since the constructor is private, accessing it via the static method is the only way to obtain a `OrderBuilder` instance. The `build` method returns the constructed `Order` instance. Other methods set their respective fields in `order` and return the `OrderBuilder` instance itself, enabling method chaining.

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

### Creating Different Orders Using the Builder

```java
Order order01 = OrderBuilder.builder()
                .snack(Snack.POPCORN)
                .drink(Drink.SODA)
                .condiment(Condiment.KETCHUP)
                .sideDish(SideDish.FRIES)
                .build();

Order order02 = OrderBuilder.builder()
                .snack(Snack.CHIPS)
                .drink(Drink.SODA)
                .build();

Order order03 = OrderBuilder.builder()
                .drink(Drink.SODA)
                .build();
```