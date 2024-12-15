# Factory Method Pattern

## 📚 References

- [Refactoring Guru - Factory Method Pattern](https://refactoring.guru/design-patterns/factory-method)
- Design Patterns: Elements of Reusable Object-Oriented Software

---

## 📖 Description

The **Factory Method Pattern** is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. This pattern is useful when a class cannot anticipate the class of objects it must create.

- **Category:** Creational Pattern  
- **Intent:** Define an interface for creating an object, but let subclasses alter the type of objects that will be created.

---

## 🔧 Problem

When a class cannot anticipate the class of objects it must create, or when a class wants its subclasses to specify the objects it creates.

---

## 💡 Solution

The **Factory Method Pattern** delegates the responsibility of object instantiation to subclasses. This is achieved by:
- Defining a factory method in the superclass.
- Subclasses override the factory method to create specific objects.

- **Advantages:**
  - Promotes loose coupling by eliminating the need to bind application-specific classes into the code.
  - Enhances code maintainability and scalability.
  - Provides hooks for subclasses to create specific objects.

---

## 🛠 Structure

1. **Relatory Interface:** Declares the interface `Relatory` for the objects created by the factory method.
2. **Concrete Products:** Implement the `Relatory` interface, such as `RelatoryCsv`.
3. **Relatory Factory Interface:** Declares the factory method in the interface `RelatoryFactory`, which returns an object of type `Relatory`.
4. **Concrete Factories:** Implement the factory interface and override the factory method to return instances of specific products, such as `RelatoryCsvFactory`.


---

## 📋 Implementation

### `Relatory.java`
Represents the product interface.
```java
package model;

public interface Relatory {
    void generateRelatory();
}
```

### `RelatoryCsv.java`
Represents a concrete product.
```java
package model;

public class RelatoryCsv implements Relatory {
    @Override
    public void generateRelatory() {
        System.out.println("Generating CSV relatory...");
    }
}
```

### `RelatoryFactory.java`
Declares the factory method.
```java
package relatory;

import model.Relatory;

public interface RelatoryFactory {
    Relatory createRelatory();
}
```

### `RelatoryCsvFactory.java`
Overrides the factory method to create a RelatoryCsv object.
```java
package relatory;

import model.Relatory;
import model.RelatoryCsv;

public class RelatoryCsvFactory implements RelatoryFactory {
    @Override
    public Relatory createRelatory() {
        RelatoryCsv relatoryCsv = new RelatoryCsv();
        relatoryCsv.generateRelatory();
        return relatoryCsv;
    }
}
```

### `App.java`
In the App class, you can use the factory method to create different types of relatories:
```java
import model.Relatory;
import relatory.RelatoryCsvFactory;
import relatory.RelatoryFactory;

public class App {
    public static void main(String[] args) {
        Relatory relatory;
        RelatoryFactory relatoryFactory;

        relatoryFactory = new RelatoryCsvFactory();
        relatory = relatoryFactory.createRelatory();

        /* Output
           Generating CSV relatory...
        */
    }
}
```